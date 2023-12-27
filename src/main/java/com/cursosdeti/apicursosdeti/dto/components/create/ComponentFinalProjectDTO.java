package com.cursosdeti.apicursosdeti.dto.components.create;

public class ComponentFinalProjectDTO extends ComponentFinalProjectCreateDTO{

    private Integer idCurso;

    public ComponentFinalProjectDTO(String courseName, Integer classHours, String syllabus, Integer idCurso) {
        super(courseName, classHours, syllabus);
        this.idCurso = idCurso;
    }

    public ComponentFinalProjectDTO() {
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }
}
