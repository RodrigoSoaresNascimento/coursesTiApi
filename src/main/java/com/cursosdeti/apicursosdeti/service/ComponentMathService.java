package com.cursosdeti.apicursosdeti.service;

import com.cursosdeti.apicursosdeti.entity.ComponentMathEntity;
import com.cursosdeti.apicursosdeti.entity.CourseTiEntity;
import com.cursosdeti.apicursosdeti.repository.ComponentMathRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ComponentMathService {


    private final ComponentMathRepository repository;


    private final CourseTiService courseTiService;

    public ComponentMathEntity getById (Integer idCourse) {
        Optional<ComponentMathEntity> curso = Optional.ofNullable(repository.findById(idCourse)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado")));

        return curso.get();
    }

    public ComponentMathEntity create (ComponentMathEntity mathComponent, Integer idCourseTi){

        CourseTiEntity courseTi = courseTiService.getByid(idCourseTi);

        ComponentMathEntity mathEntity = new ComponentMathEntity();
        mathEntity.setClassHours(mathComponent.getClassHours());
        mathEntity.setCourseName(mathComponent.getCourseName());
        mathEntity.setSyllabus(mathComponent.getSyllabus());
        mathEntity.setCourse(courseTi);
        repository.save(mathEntity);
        return mathEntity;
    }

    public ComponentMathEntity update (ComponentMathEntity mathComponent, Integer idCourse){
        ComponentMathEntity mathEntity = getById(idCourse);
        if (mathComponent.getClassHours() != null){
            mathEntity.setClassHours(mathComponent.getClassHours());
        }
        if (mathComponent.getCourseName() != null){
            mathEntity.setCourseName(mathComponent.getCourseName());
        }
        if (mathComponent.getSyllabus() != null){
            mathEntity.setSyllabus(mathComponent.getSyllabus());
        }
        repository.save(mathEntity);
        return mathEntity;
    }

    public void delete (Integer idCourse){
        ComponentMathEntity mathEntity = getById(idCourse);
        repository.delete(mathEntity);
    }

    public Page<ComponentMathEntity> findAll (Pageable pageable){
        return repository.findAll(pageable);
    }
}
