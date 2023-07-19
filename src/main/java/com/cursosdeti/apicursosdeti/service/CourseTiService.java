package com.cursosdeti.apicursosdeti.service;

import com.cursosdeti.apicursosdeti.dto.courseTi.CourseTiDTO;
import com.cursosdeti.apicursosdeti.entity.CourseTiEntity;
import com.cursosdeti.apicursosdeti.repository.CourseTiRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseTiService {


    private final CourseTiRepository courseTiRepository;

    private final ObjectMapper objectMapper;

    public CourseTiEntity converterParaCourseTiEntity (CourseTiDTO courseTiDTO) {
        return objectMapper.convertValue(courseTiDTO, CourseTiEntity.class);
    }

    public CourseTiDTO converterParaCourseTiDTO (CourseTiEntity courseTi) {
        return objectMapper.convertValue(courseTi, CourseTiDTO.class);
    }

    public CourseTiDTO getByid(Integer idCourse){
        Optional<CourseTiEntity> curso = Optional.ofNullable(courseTiRepository.findById(idCourse)
                .orElseThrow(() -> new IllegalArgumentException("Curso n�o encontrado")));

        return this.converterParaCourseTiDTO(curso.get());
    }

    public CourseTiDTO create (CourseTiDTO courseTiDTO){

        CourseTiEntity courseTi = new CourseTiEntity();
        courseTi.setCourseName(courseTiDTO.getCourseName());
        courseTi.setCity(courseTiDTO.getCity());
        courseTi.setInstitution(courseTiDTO.getInstitution());
        courseTi.setPeriod(courseTiDTO.getPeriod());
        courseTi.setModality(courseTiDTO.getModality());
        courseTiRepository.save(courseTi);
        return this.converterParaCourseTiDTO(courseTi);
    }

    public CourseTiDTO update (CourseTiDTO courseTiDTO, Integer idCourse){

        CourseTiDTO courseUpdate = getByid(idCourse);
        CourseTiEntity courseTi = converterParaCourseTiEntity(courseUpdate);


        if (courseTiDTO.getCity() != null){
            courseTi.setCity(courseTiDTO.getCity());
        }
        if (courseTiDTO.getCourseName() != null){
            courseTi.setCourseName(courseTiDTO.getCourseName());
        }
        if (courseTiDTO.getInstitution() != null){
            courseTi.setInstitution(courseTiDTO.getInstitution());
        }
        if (courseTiDTO.getPeriod() != null){
            courseTi.setPeriod(courseTiDTO.getPeriod());
        }
        if (courseTiDTO.getModality() != null){
            courseTi.setModality(courseTiDTO.getModality());
        }
        courseTiRepository.save(courseTi);

        return this.converterParaCourseTiDTO(courseTi);
    }

    public void delete (Integer idCourse){
        CourseTiDTO courseDelete = getByid(idCourse);
        CourseTiEntity courseTi = converterParaCourseTiEntity(courseDelete);
        courseTiRepository.delete(courseTi);
    }

    public List<CourseTiDTO> findAll() {
        return courseTiRepository.findAll()
                .stream()
                .map(this::converterParaCourseTiDTO)
                .toList();
    }

}
