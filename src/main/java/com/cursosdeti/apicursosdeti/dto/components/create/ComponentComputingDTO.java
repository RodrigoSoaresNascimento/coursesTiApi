package com.cursosdeti.apicursosdeti.dto.components.create;

import com.cursosdeti.apicursosdeti.dto.components.create.ComponentComputingCreateDTO;

public class ComponentComputingDTO extends ComponentComputingCreateDTO {

    private Integer idCurso;

    public ComponentComputingDTO(String courseName, Integer classHours, String syllabus, Integer idCurso) {
        super(courseName, classHours, syllabus);
        this.idCurso = idCurso;
    }

    public ComponentComputingDTO() {
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }
}
