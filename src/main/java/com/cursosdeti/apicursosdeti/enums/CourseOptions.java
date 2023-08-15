package com.cursosdeti.apicursosdeti.enums;

public enum CourseOptions {

    HABILITAR("S"),
    DESABILITAR("N");

    private String option;

    CourseOptions(String option) {
        this.option = option;
    }

    public String getModality() {
        return option;
    }
}
