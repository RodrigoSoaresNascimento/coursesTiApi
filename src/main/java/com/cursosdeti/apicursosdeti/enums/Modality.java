package com.cursosdeti.apicursosdeti.enums;

public enum Modality {
    PRESENCIAL("PRESENCIAL"),
    A_DISTANCIA("A_DISTANCIA"),
    HIBRIDO("HIBRIDO");

    private String modality;

    Modality(String modality) {
        this.modality = modality;
    }

    public String getModality() {
        return modality;
    }
}
