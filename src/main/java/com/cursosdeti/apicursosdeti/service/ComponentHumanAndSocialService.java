package com.cursosdeti.apicursosdeti.service;

import com.cursosdeti.apicursosdeti.dto.courseTi.CourseTiDTO;
import com.cursosdeti.apicursosdeti.entity.ComponentHumanAndSocialEntity;
import com.cursosdeti.apicursosdeti.entity.CourseTiEntity;
import com.cursosdeti.apicursosdeti.repository.ComponentHumanAndSocialRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ComponentHumanAndSocialService {


    private final ComponentHumanAndSocialRepository repository;

    private final CourseTiService courseTiService;

    public ComponentHumanAndSocialEntity getById (Integer idCourse) {
        Optional<ComponentHumanAndSocialEntity> curso = Optional.ofNullable(repository.findById(idCourse)
                .orElseThrow(() -> new IllegalArgumentException("Curso n�o encontrado")));

        return curso.get();
    }

    public ComponentHumanAndSocialEntity create (ComponentHumanAndSocialEntity componentHumanAndSocial, Integer idCourseTi){

        CourseTiDTO courseTiDTO = courseTiService.getByid(idCourseTi);
        CourseTiEntity courseTi = courseTiService.converterParaCourseTiEntity(courseTiDTO);

        ComponentHumanAndSocialEntity humanAndSocialEntity = new ComponentHumanAndSocialEntity();
        humanAndSocialEntity.setClassHours(componentHumanAndSocial.getClassHours());
        humanAndSocialEntity.setCourseName(componentHumanAndSocial.getCourseName());
        humanAndSocialEntity.setSyllabus(componentHumanAndSocial.getSyllabus());
        humanAndSocialEntity.setCourse(courseTi);
        repository.save(humanAndSocialEntity);
        return humanAndSocialEntity;
    }

    public ComponentHumanAndSocialEntity update (ComponentHumanAndSocialEntity componentHumanAndSocial, Integer idCourse){
        ComponentHumanAndSocialEntity humanAndSocialEntity = getById(idCourse);
        if (componentHumanAndSocial.getClassHours() != null){
            humanAndSocialEntity.setClassHours(componentHumanAndSocial.getClassHours());
        }
        if (componentHumanAndSocial.getCourseName() != null){
            humanAndSocialEntity.setCourseName(componentHumanAndSocial.getCourseName());
        }
        if (componentHumanAndSocial.getSyllabus() != null){
            humanAndSocialEntity.setSyllabus(componentHumanAndSocial.getSyllabus());
        }
        repository.save(humanAndSocialEntity);
        return humanAndSocialEntity;
    }

    public void delete (Integer idCourse){
        ComponentHumanAndSocialEntity humanAndSocialEntity = getById(idCourse);
        repository.delete(humanAndSocialEntity);
    }

    public Page<ComponentHumanAndSocialEntity> findAll (Pageable pageable){
        return repository.findAll(pageable);
    }
}
