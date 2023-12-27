package com.cursosdeti.apicursosdeti.dto.components.create;


import com.cursosdeti.apicursosdeti.dto.courseTi.CourseTiDTO;

public class ComponentComputingDTO extends ComponentComputingCreateDTO {


    public ComponentComputingDTO(String courseName, Integer classHours, String syllabus, CourseTiDTO courseTiDTO, Integer idCourse) {
        super(courseName, classHours, syllabus, courseTiDTO);
        this.idCourse = idCourse;
    }

    public ComponentComputingDTO() {
    }

    private Integer idCourse;

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }

    @Override
    public String toString() {
        return "ComponentComputingDTO{" +
                "idCourse=" + idCourse +
                '}';
    }
}
