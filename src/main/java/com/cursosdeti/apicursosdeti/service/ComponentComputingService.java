package com.cursosdeti.apicursosdeti.service;

import com.cursosdeti.apicursosdeti.dto.PageDTO;
import com.cursosdeti.apicursosdeti.dto.components.create.ComponentComputingCreateDTO;
import com.cursosdeti.apicursosdeti.dto.components.create.ComponentComputingDTO;
import com.cursosdeti.apicursosdeti.dto.courseTi.CourseTiDTO;
import com.cursosdeti.apicursosdeti.entity.ComponentComputingEntity;
import com.cursosdeti.apicursosdeti.entity.CourseTiEntity;
import com.cursosdeti.apicursosdeti.repository.ComponentComputingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ComponentComputingService {


    private final ComponentComputingRepository componentComputingRepository;

    private final CourseTiService courseTiService;


    private final ObjectMapper objectMapper;

    public ComponentComputingEntity converterComputingEntity (ComponentComputingDTO componentComputingDTO) {
        return objectMapper.convertValue(componentComputingDTO, ComponentComputingEntity.class);
    }

    public ComponentComputingDTO converterComputingDTO(ComponentComputingEntity computing) {
        return objectMapper.convertValue(computing, ComponentComputingDTO.class);
    }

    public PageDTO <ComponentComputingDTO> listarComponentesComputingPaginado (Integer pagina, Integer record) {
        PageRequest pageRequest = PageRequest.of(pagina, record);
        Page<ComponentComputingEntity> page = componentComputingRepository.findAll(pageRequest);
        List<ComponentComputingDTO> computingDTOS = page.getContent().stream()
                .map(this::converterComputingDTO)
                .toList();

        return new PageDTO<>(page.getTotalElements(), page.getTotalPages(),pagina ,record, computingDTOS);
    }

    public ComponentComputingDTO getById (Integer idCourse) {
        Optional<ComponentComputingEntity> curso = Optional.ofNullable(componentComputingRepository.findById(idCourse)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado")));

        ComponentComputingDTO computingDTO = converterComputingDTO(curso.get());

        return computingDTO;
    }

    public ComponentComputingDTO create (ComponentComputingCreateDTO componentComputing, Integer idCourseTi){

        CourseTiDTO courseTiDTO = courseTiService.getByid(idCourseTi);
        CourseTiEntity courseTi = courseTiService.converterParaCourseTiEntity(courseTiDTO);

        ComponentComputingEntity computingEntity = new ComponentComputingEntity();
        computingEntity.setClassHours(componentComputing.getClassHours());
        computingEntity.setCourseName(componentComputing.getCourseName());
        computingEntity.setSyllabus(componentComputing.getSyllabus());
        computingEntity.setCourse(courseTi);
        componentComputingRepository.save(computingEntity);
        ComponentComputingDTO computingDTO = converterComputingDTO(computingEntity);
        return computingDTO;
    }

    public ComponentComputingDTO update (ComponentComputingDTO componentComputing, Integer idCourse){

        ComponentComputingDTO computingDTO = getById(idCourse);
        ComponentComputingEntity computingEntity = converterComputingEntity(computingDTO);


        if (componentComputing.getClassHours() != null){
            computingEntity.setClassHours(componentComputing.getClassHours());
        }
        if (componentComputing.getCourseName() != null){
            computingEntity.setCourseName(componentComputing.getCourseName());
        }
        if (componentComputing.getSyllabus() != null){
            computingEntity.setSyllabus(componentComputing.getSyllabus());
        }
        componentComputingRepository.save(computingEntity);
        return componentComputing;
    }

    public void delete (Integer idCourse){
        ComponentComputingDTO computingDTO = getById(idCourse);
        ComponentComputingEntity computingEntity = converterComputingEntity(computingDTO);
        componentComputingRepository.delete(computingEntity);
    }

    public List<ComponentComputingDTO> findAll (){
        return componentComputingRepository.findAll()
                .stream()
                .map(this::converterComputingDTO)
                .collect(Collectors.toList());
    }
}
