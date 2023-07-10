package com.cursosdeti.apicursosdeti.dto.components.create;

public class ComponentPhysicsDTO extends ComponentPhysicsCreateDTO {

    private Integer idCurso;

    public ComponentPhysicsDTO(String courseName, Integer classHours, String syllabus, Integer idCurso) {
        super(courseName, classHours, syllabus);
        this.idCurso = idCurso;
    }

    public ComponentPhysicsDTO() {
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }
}
