package com.cursosdeti.apicursosdeti.dto.courseTi;

import com.cursosdeti.apicursosdeti.enums.Modality;

public class CourseTiDTO extends CourseTiCreateDTO {

    public CourseTiDTO(String courseName, String institution, Modality modality, String period, String city, Integer idCourse) {
        super(courseName, institution, modality, period, city);
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
