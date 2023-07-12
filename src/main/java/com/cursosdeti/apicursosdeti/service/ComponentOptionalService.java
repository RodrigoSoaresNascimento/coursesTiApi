package com.cursosdeti.apicursosdeti.service;

import com.cursosdeti.apicursosdeti.entity.ComponentOptionalEntity;
import com.cursosdeti.apicursosdeti.entity.CourseTiEntity;
import com.cursosdeti.apicursosdeti.repository.ComponentOptionalRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ComponentOptionalService {


    private final ComponentOptionalRepository repository;


    private final CourseTiService courseTiService;

    public ComponentOptionalEntity getById (Integer idCourse) {
        Optional<ComponentOptionalEntity> curso = Optional.ofNullable(repository.findById(idCourse)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado")));

        return curso.get();
    }

    public ComponentOptionalEntity create (ComponentOptionalEntity optionalComponent, Integer idCourseTi){

        CourseTiEntity courseTi = courseTiService.getByid(idCourseTi);

        ComponentOptionalEntity optionalEntity = new ComponentOptionalEntity();
        optionalEntity.setClassHours(optionalComponent.getClassHours());
        optionalEntity.setCourseName(optionalComponent.getCourseName());
        optionalEntity.setSyllabus(optionalComponent.getSyllabus());
        optionalEntity.setCourse(courseTi);
        repository.save(optionalEntity);
        return optionalEntity;
    }

    public ComponentOptionalEntity update (ComponentOptionalEntity optionalComponent, Integer idCourse){
        ComponentOptionalEntity optionalEntity = getById(idCourse);
        if (optionalComponent.getClassHours() != null){
            optionalEntity.setClassHours(optionalComponent.getClassHours());
        }
        if (optionalComponent.getCourseName() != null){
            optionalEntity.setCourseName(optionalComponent.getCourseName());
        }
        if (optionalComponent.getSyllabus() != null){
            optionalEntity.setSyllabus(optionalComponent.getSyllabus());
        }
        repository.save(optionalEntity);
        return optionalEntity;
    }

    public void delete (Integer idCourse){
        ComponentOptionalEntity optionalEntity = getById(idCourse);
        repository.delete(optionalEntity);
    }

    public Page<ComponentOptionalEntity> findAll (Pageable pageable){
        return repository.findAll(pageable);
    }
}
