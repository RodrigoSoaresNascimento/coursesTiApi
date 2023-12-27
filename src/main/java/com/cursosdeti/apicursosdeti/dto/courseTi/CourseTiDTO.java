package com.cursosdeti.apicursosdeti.dto.courseTi;

import com.cursosdeti.apicursosdeti.dto.components.create.ComponentComputingDTO;
import com.cursosdeti.apicursosdeti.enums.Modality;
import com.cursosdeti.apicursosdeti.enums.Period;

import java.util.Set;

public class CourseTiDTO extends CourseTiCreateDTO {

    public CourseTiDTO(String courseName, String institution, String city, Modality modality, Period period, Set<ComponentComputingDTO> componentComputingDTOSet, Integer idCourse) {
        super(courseName, institution, city, modality, period, componentComputingDTOSet);
        this.idCourse = idCourse;
    }

    public CourseTiDTO() {
    }

    private Integer idCourse;

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }
}
