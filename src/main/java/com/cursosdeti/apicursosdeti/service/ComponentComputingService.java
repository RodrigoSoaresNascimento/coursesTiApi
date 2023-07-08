package com.cursosdeti.apicursosdeti.service;

import com.cursosdeti.apicursosdeti.entity.ComponentComputingEntity;
import com.cursosdeti.apicursosdeti.entity.CourseTiEntity;
import com.cursosdeti.apicursosdeti.repository.ComponentComputingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComponentComputingService {

    @Autowired
    private ComponentComputingRepository componentComputingRepository;

    @Autowired
    private CourseTiService courseTiService;

    public ComponentComputingEntity getById (Integer idCourse) {
        Optional<ComponentComputingEntity> curso = Optional.ofNullable(componentComputingRepository.findById(idCourse)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado")));

        return curso.get();
    }

    public ComponentComputingEntity create (ComponentComputingEntity componentComputing, Integer idCourseTi){

        CourseTiEntity courseTi = courseTiService.getByid(idCourseTi);

        ComponentComputingEntity computingEntity = new ComponentComputingEntity();
        computingEntity.setClassHours(componentComputing.getClassHours());
        computingEntity.setCourseName(componentComputing.getCourseName());
        computingEntity.setSyllabus(componentComputing.getSyllabus());
        computingEntity.setCourse(courseTi);
        componentComputingRepository.save(computingEntity);
        return computingEntity;
    }

    public ComponentComputingEntity update (ComponentComputingEntity componentComputing, Integer idCourse){
        ComponentComputingEntity computingEntity = getById(idCourse);
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
        ComponentComputingEntity computingEntity = getById(idCourse);
        componentComputingRepository.delete(computingEntity);
    }

    public Page<ComponentComputingEntity> findAll (Pageable pageable){
        return componentComputingRepository.findAll(pageable);
    }
}
