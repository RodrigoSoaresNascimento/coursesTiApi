package com.cursosdeti.apicursosdeti.service;

import com.cursosdeti.apicursosdeti.entity.CourseTiEntity;
import com.cursosdeti.apicursosdeti.repository.CourseTiRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseTiService {


    private final CourseTiRepository courseTiRepository;

    public CourseTiEntity getByid(Integer idCourse){
        Optional<CourseTiEntity> curso = Optional.ofNullable(courseTiRepository.findById(idCourse)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado")));

        return curso.get();
    }

    public CourseTiEntity create (CourseTiEntity entity){

        CourseTiEntity courseTi = new CourseTiEntity();
        courseTi.setCourseName(entity.getCourseName());
        courseTi.setCity(entity.getCity());
        courseTi.setInstitution(entity.getInstitution());
        courseTi.setPeriod(entity.getPeriod());
        courseTi.setModality(entity.getModality());
        courseTiRepository.save(courseTi);
        return courseTi;
    }

    public CourseTiEntity update (CourseTiEntity entity, Integer idCourse){
        CourseTiEntity courseTi = getByid(idCourse);
        if (entity.getCity() != null){
            courseTi.setCity(entity.getCity());
        }
        if (entity.getCourseName() != null){
            courseTi.setCourseName(entity.getCourseName());
        }
        if (entity.getInstitution() != null){
            courseTi.setInstitution(entity.getInstitution());
        }
        if (entity.getPeriod() != null){
            courseTi.setPeriod(entity.getPeriod());
        }
        if (entity.getModality() != null){
            courseTi.setModality(entity.getModality());
        }
        courseTiRepository.save(courseTi);
        return courseTi;
    }

    public void delete (Integer idCourse){
        CourseTiEntity courseTi = getByid(idCourse);
        courseTiRepository.delete(courseTi);
    }

    public Page<CourseTiEntity> findAll(Pageable pageable) {
        return courseTiRepository.findAll(pageable);
    }

}
