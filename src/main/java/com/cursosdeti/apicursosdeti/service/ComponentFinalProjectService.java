package com.cursosdeti.apicursosdeti.service;

import com.cursosdeti.apicursosdeti.entity.ComponentFinalProjectEntity;
import com.cursosdeti.apicursosdeti.entity.CourseTiEntity;
import com.cursosdeti.apicursosdeti.repository.ComponentFinalProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComponentFinalProjectService {

    @Autowired
    private ComponentFinalProjectRepository finalProjectRepository;

    @Autowired
    private CourseTiService courseTiService;

    public ComponentFinalProjectEntity getById (Integer idCourse) {
        Optional<ComponentFinalProjectEntity> curso = Optional.ofNullable(finalProjectRepository.findById(idCourse)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado")));

        return curso.get();
    }

    public ComponentFinalProjectEntity create (ComponentFinalProjectEntity componentFinalProject, Integer idCourseTi){

        CourseTiEntity courseTi = courseTiService.getByid(idCourseTi);

        ComponentFinalProjectEntity finalProjectEntity = new ComponentFinalProjectEntity();
        finalProjectEntity.setClassHours(componentFinalProject.getClassHours());
        finalProjectEntity.setCourseName(componentFinalProject.getCourseName());
        finalProjectEntity.setSyllabus(componentFinalProject.getSyllabus());
        finalProjectEntity.setCourse(courseTi);
        finalProjectRepository.save(finalProjectEntity);
        return finalProjectEntity;
    }

    public ComponentFinalProjectEntity update (ComponentFinalProjectEntity componentFinalProject, Integer idCourse){
        ComponentFinalProjectEntity finalProjectEntity = getById(idCourse);
        if (componentFinalProject.getClassHours() != null){
            finalProjectEntity.setClassHours(componentFinalProject.getClassHours());
        }
        if (componentFinalProject.getCourseName() != null){
            finalProjectEntity.setCourseName(componentFinalProject.getCourseName());
        }
        if (componentFinalProject.getSyllabus() != null){
            finalProjectEntity.setSyllabus(componentFinalProject.getSyllabus());
        }
        finalProjectRepository.save(finalProjectEntity);
        return finalProjectEntity;
    }

    public void delete (Integer idCourse){
        ComponentFinalProjectEntity finalProjectEntity = getById(idCourse);
        finalProjectRepository.delete(finalProjectEntity);
    }

    public Page<ComponentFinalProjectEntity> findAll (Pageable pageable){
        return finalProjectRepository.findAll(pageable);
    }
}
