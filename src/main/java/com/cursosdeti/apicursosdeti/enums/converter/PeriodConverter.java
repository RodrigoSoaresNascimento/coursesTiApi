package com.cursosdeti.apicursosdeti.enums.converter;

import com.cursosdeti.apicursosdeti.enums.Period;
import jakarta.persistence.AttributeConverter;

public class PeriodConverter implements AttributeConverter<Period, String> {
    @Override
    public String convertToDatabaseColumn(Period period) {
        if (period == null){
            return null;
        }
        return period.getPeriod();
    }

    @Override
    public Period convertToEntityAttribute(String s) {
        return Period.getPeriodString(s);
    }
}
