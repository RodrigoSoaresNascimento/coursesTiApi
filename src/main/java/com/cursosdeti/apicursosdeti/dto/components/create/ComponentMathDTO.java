package com.cursosdeti.apicursosdeti.dto.components.create;

public class ComponentMathDTO extends ComponentMathCreateDTO{

    private Integer idCurso;

    public ComponentMathDTO(String courseName, Integer classHours, String syllabus, Integer idCurso) {
        super(courseName, classHours, syllabus);
        this.idCurso = idCurso;
    }

    public ComponentMathDTO() {
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }
}
