package com.cursosdeti.apicursosdeti.enums.converter;

import com.cursosdeti.apicursosdeti.enums.Modality;
import jakarta.persistence.AttributeConverter;

public class ModalityConverter implements AttributeConverter<Modality, String> {

    @Override
    public String convertToDatabaseColumn(Modality modality) {
        if (modality == null){
            return null;
        }
        return modality.getModality();
    }

    @Override
    public Modality convertToEntityAttribute(String s) {
        return Modality.getModalityString(s);
    }
}
