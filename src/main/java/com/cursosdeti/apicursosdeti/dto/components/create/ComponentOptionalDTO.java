package com.cursosdeti.apicursosdeti.dto.components.create;

public class ComponentOptionalDTO extends ComponentOptionalCreateDTO {

    private Integer idCurso;

    public ComponentOptionalDTO(String courseName, Integer classHours, String syllabus, Integer idCurso) {
        super(courseName, classHours, syllabus);
        this.idCurso = idCurso;
    }

    public ComponentOptionalDTO() {
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }
}
