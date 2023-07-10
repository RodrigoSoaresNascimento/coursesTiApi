package com.cursosdeti.apicursosdeti.service;

import com.cursosdeti.apicursosdeti.dto.PageDTO;
import com.cursosdeti.apicursosdeti.dto.components.create.ComponentComputingCreateDTO;
import com.cursosdeti.apicursosdeti.dto.components.create.ComponentComputingDTO;
import com.cursosdeti.apicursosdeti.entity.ComponentComputingEntity;
import com.cursosdeti.apicursosdeti.entity.CourseTiEntity;
import com.cursosdeti.apicursosdeti.repository.ComponentComputingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComponentComputingService {

    @Autowired
    private ComponentComputingRepository componentComputingRepository;

    @Autowired
    private CourseTiService courseTiService;

    @Autowired
    private ObjectMapper objectMapper;

    public ComponentComputingEntity converterComputingEntity (ComponentComputingCreateDTO computingCreateDTO) {
        return objectMapper.convertValue(computingCreateDTO, ComponentComputingEntity.class);
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

        CourseTiEntity courseTi = courseTiService.getByid(idCourseTi);

        ComponentComputingEntity computingEntity = converterComputingEntity(componentComputing);
        computingEntity.setClassHours(componentComputing.getClassHours());
        computingEntity.setCourseName(componentComputing.getCourseName());
        computingEntity.setSyllabus(componentComputing.getSyllabus());
        computingEntity.setCourse(courseTi);
        componentComputingRepository.save(computingEntity);
        ComponentComputingDTO computingDTO = converterComputingDTO(computingEntity);
        return computingDTO;
    }

    public ComponentComputingEntity update (ComponentComputingEntity componentComputing, Integer idCourse){

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
        return computingEntity;
    }

    public void delete (Integer idCourse){
        ComponentComputingDTO computingDTO = getById(idCourse);
        ComponentComputingEntity computingEntity = converterComputingEntity(computingDTO);
        componentComputingRepository.delete(computingEntity);
    }

    public Page<ComponentComputingEntity> findAll (Pageable pageable){
        return componentComputingRepository.findAll(pageable);
    }
}
