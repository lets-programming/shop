package com.letsprogramming.shop.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Converter
public class DateTimeConverter implements AttributeConverter<OffsetDateTime, String> {

    @Override
    public String convertToDatabaseColumn(OffsetDateTime attribute) {
        return attribute.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public OffsetDateTime convertToEntityAttribute(String dbData) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return OffsetDateTime.parse(dbData, format);
    }
}
