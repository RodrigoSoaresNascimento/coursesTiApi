package com.cursosdeti.apicursosdeti.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public enum CourseOptions {

    HABILITAR(0),
    DESABILITAR(1);

    private Integer option;

    CourseOptions(Integer option) {
        this.option = option;
    }

    public Integer getOptions() {
        return option;
    }


}
