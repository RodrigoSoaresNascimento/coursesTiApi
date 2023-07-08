package com.cursosdeti.apicursosdeti.service;

import com.cursosdeti.apicursosdeti.entity.ComponentPhysicsEntity;
import com.cursosdeti.apicursosdeti.entity.CourseTiEntity;
import com.cursosdeti.apicursosdeti.repository.ComponentPhysicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComponentPhysicsService {

    @Autowired
    private ComponentPhysicsRepository repository;

    @Autowired
    private CourseTiService courseTiService;

    public ComponentPhysicsEntity getById (Integer idCourse) {
        Optional<ComponentPhysicsEntity> curso = Optional.ofNullable(repository.findById(idCourse)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado")));

        return curso.get();
    }

    public ComponentPhysicsEntity create (ComponentPhysicsEntity componentPhysics, Integer idCourseTi){

        CourseTiEntity courseTi = courseTiService.getByid(idCourseTi);

        ComponentPhysicsEntity physicsEntity = new ComponentPhysicsEntity();
        physicsEntity.setClassHours(componentPhysics.getClassHours());
        physicsEntity.setCourseName(componentPhysics.getCourseName());
        physicsEntity.setSyllabus(componentPhysics.getSyllabus());
        physicsEntity.setCourse(courseTi);
        repository.save(physicsEntity);
        return physicsEntity;
    }

    public ComponentPhysicsEntity update (ComponentPhysicsEntity componentPhysics, Integer idCourse){
        ComponentPhysicsEntity physicsEntity = getById(idCourse);
        if (componentPhysics.getClassHours() != null){
            physicsEntity.setClassHours(componentPhysics.getClassHours());
        }
        if (componentPhysics.getCourseName() != null){
            physicsEntity.setCourseName(componentPhysics.getCourseName());
        }
        if (componentPhysics.getSyllabus() != null){
            physicsEntity.setSyllabus(componentPhysics.getSyllabus());
        }
        repository.save(physicsEntity);
        return physicsEntity;
    }

    public void delete (Integer idCourse){
        ComponentPhysicsEntity physicsEntity = getById(idCourse);
        repository.delete(physicsEntity);
    }

    public Page<ComponentPhysicsEntity> findAll (Pageable pageable){
        return repository.findAll(pageable);
    }
}
