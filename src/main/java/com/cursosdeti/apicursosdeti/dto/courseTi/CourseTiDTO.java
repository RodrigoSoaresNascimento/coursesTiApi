package com.cursosdeti.apicursosdeti.dto.courseTi;

import com.cursosdeti.apicursosdeti.enums.Modality;

public class CourseTiDTO extends CourseTiCreateDTO {

    public CourseTiDTO(String courseName, String institution, Modality modality, String period, String city, Integer _idCourse) {
        super(courseName, institution, modality, period, city);
        this._idCourse = _idCourse;
    }

    public CourseTiDTO() {
    }

    private Integer _idCourse;

    public Integer getIdCourse() {
        return _idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this._idCourse = idCourse;
    }
}
