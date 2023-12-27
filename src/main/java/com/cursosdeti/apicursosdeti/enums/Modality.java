package com.cursosdeti.apicursosdeti.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum Modality {
    PRESENCIAL("PRESENCIAL"),
    A_DISTANCIA("A_DISTANCIA"),
    HIBRIDO("HIBRIDO");

    @JsonValue
    private String modality;

    Modality(String modality) {
        this.modality = modality;
    }

    public String getModality() {
        return modality;
    }

    public static Modality getModalityString (String modality){
        return Arrays.stream(Modality.values())
                .filter(tp -> tp.getModality().equalsIgnoreCase(modality))
                .findFirst()
                .get();
    }

    @Override
    public String toString() {
        return "Modality{" +
                "modality='" + modality + '\'' +
                '}';
    }
}
