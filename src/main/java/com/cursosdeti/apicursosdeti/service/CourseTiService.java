package com.cursosdeti.apicursosdeti.service;

import com.cursosdeti.apicursosdeti.dto.components.create.ComponentComputingDTO;
import com.cursosdeti.apicursosdeti.dto.courseTi.CourseTiDTO;
import com.cursosdeti.apicursosdeti.dto.courseTi.CourseTiDisableDTO;
import com.cursosdeti.apicursosdeti.dto.courseTi.CourseTiPageDTO;
import com.cursosdeti.apicursosdeti.entity.ComponentComputingEntity;
import com.cursosdeti.apicursosdeti.entity.CourseTiEntity;
import com.cursosdeti.apicursosdeti.enums.CourseOptions;
import com.cursosdeti.apicursosdeti.enums.Modality;
import com.cursosdeti.apicursosdeti.enums.Period;
import com.cursosdeti.apicursosdeti.exception.RecordNotFoundException;
import com.cursosdeti.apicursosdeti.repository.CourseTiRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseTiService {


    private final CourseTiRepository courseTiRepository;
    private final ObjectMapper objectMapper;

    public CourseTiEntity converterParaCourseTiEntity (CourseTiDTO courseTiDTO) {
        CourseTiEntity courseTiEntity = objectMapper.convertValue(courseTiDTO, CourseTiEntity.class);
        Set<ComponentComputingEntity> componentComputingEntities = courseTiDTO.getComponentComputingDTOSet()
                .stream()
                .map(componentComputingDTO -> {
                        ComponentComputingEntity componentComputingEntity = new ComponentComputingEntity();
                        componentComputingEntity.setIdCourse(componentComputingDTO.getIdCourse());
                        componentComputingEntity.setCourseName(componentComputingDTO.getCourseName());
                        componentComputingEntity.setClassHours(componentComputingDTO.getClassHours());
                        componentComputingEntity.setSyllabus(componentComputingDTO.getSyllabus());
                        componentComputingEntity.setCourse(courseTiEntity);
                        return componentComputingEntity;
                })
                .collect(Collectors.toSet());
        courseTiEntity.setComputingComponents(componentComputingEntities);

        return courseTiEntity;
    }

    public CourseTiDTO converterParaCourseTiDTO (CourseTiEntity courseTi) {

        CourseTiDTO courseTiDTO = objectMapper.convertValue(courseTi, CourseTiDTO.class);
        Set<ComponentComputingDTO> computingDTOList = courseTi.getComputingComponents().stream().map(computingEntity -> objectMapper.convertValue(computingEntity, ComponentComputingDTO.class)).collect(Collectors.toSet());
        courseTiDTO.setComponentComputingDTOSet(computingDTOList);
        return courseTiDTO;
    }

    public CourseTiDTO getByid(Integer idCourse){
        Optional<CourseTiEntity> curso = Optional.ofNullable(courseTiRepository.findById(idCourse)
                .orElseThrow(() -> new RecordNotFoundException(idCourse)));

        return this.converterParaCourseTiDTO(curso.get());
    }

    public CourseTiDisableDTO create (CourseTiDTO courseTiDTO, Period period, Modality modality){


        CourseTiEntity courseTi = new CourseTiEntity();
        courseTi.setCourseName(courseTiDTO.getCourseName());
        courseTi.setCity(courseTiDTO.getCity());
        courseTi.setInstitution(courseTiDTO.getInstitution());
        courseTi.setPeriod(period);
        courseTi.setModality(modality);
        courseTi.setDisabled(CourseOptions.HABILITAR);
        Set<ComponentComputingEntity> componentComputingEntities = courseTiDTO.getComponentComputingDTOSet()
                .stream()
                .map(componentComputingDTO -> {
                            ComponentComputingEntity componentComputingEntity = new ComponentComputingEntity();
                            componentComputingEntity.setIdCourse(componentComputingDTO.getIdCourse());
                            componentComputingEntity.setCourseName(componentComputingDTO.getCourseName());
                            componentComputingEntity.setClassHours(componentComputingDTO.getClassHours());
                            componentComputingEntity.setSyllabus(componentComputingDTO.getSyllabus());
                            componentComputingEntity.setCourse(courseTi);
                            return componentComputingEntity;
                        })
                .collect(Collectors.toSet());
        courseTi.setComputingComponents(componentComputingEntities);
        courseTiRepository.save(courseTi);
        return objectMapper.convertValue(courseTi, CourseTiDisableDTO.class);
    }

    public CourseTiDTO update (CourseTiDTO courseTiDTO, Integer idCourse, Period period, Modality modality){

        CourseTiEntity courseTi = converterParaCourseTiEntity(getByid(idCourse));

        Set<ComponentComputingEntity> newComponents = new HashSet<>();

        courseTiDTO.getComponentComputingDTOSet().forEach(componentComputingDTO -> {
            ComponentComputingEntity component = objectMapper.convertValue(componentComputingDTO, ComponentComputingEntity.class);
            component.setCourse(courseTi);
            newComponents.add(component);
        });

        courseTi.setPeriod(period);
        courseTi.setModality(modality);

        courseTi.getComputingComponents().clear();
        courseTi.setComputingComponents(newComponents);


        courseTiRepository.save(courseTi);
        courseTiDTO = converterParaCourseTiDTO(courseTi);

        return  courseTiDTO;
    }

    public void delete (Integer idCourse){
        CourseTiDTO courseDelete = getByid(idCourse);
        CourseTiEntity courseTi = converterParaCourseTiEntity(courseDelete);
        courseTiRepository.delete(courseTi);
    }

    public List<CourseTiDTO> findAll() {
        return courseTiRepository.findAll()
                .stream()
                .filter(courseTi -> courseTi.getDisabled() != CourseOptions.DESABILITAR )
                .map(this::converterParaCourseTiDTO)
                .toList();
    }

    public CourseTiPageDTO PageList (int pageNumber, int size){
        Page<CourseTiEntity> page = courseTiRepository.findAll(PageRequest.of(pageNumber, size));
        List<CourseTiDTO> courseTiDTOList = page.get().map(this::converterParaCourseTiDTO).collect(Collectors.toList());
        return new CourseTiPageDTO(courseTiDTOList, page.getTotalElements(), page.getTotalPages());
    }

    public CourseTiDisableDTO disableCourseTi (Integer idCourseTi, CourseOptions options){

        CourseTiDTO courseTiDTO = getByid(idCourseTi);
        CourseTiEntity courseTi = converterParaCourseTiEntity(courseTiDTO);
        courseTi.setDisabled(options);
        courseTiRepository.save(courseTi);
        return objectMapper.convertValue(courseTi, CourseTiDisableDTO.class);

    }

}
