package com.cursosdeti.apicursosdeti.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum Period {
    MATUTINO("MATUTINO"),
    VESPERTINO("VESPERTINO"),
    INTEGRAL("INTEGRAL"),
    NORTUNO("NORTUNO");

    @JsonValue
    private String period;

    Period(String period) {
        this.period = period;
    }

    public String getPeriod() {
        return period;
    }

    @Override
    public String toString() {
        return "Modality{" +
                "modality='" + period + '\'' +
                '}';
    }

    public static Period getPeriodString (String period){
        return Arrays.stream(Period.values())
                .filter(tp -> tp.getPeriod().equalsIgnoreCase(period))
                .findFirst()
                .get();
    }

}
