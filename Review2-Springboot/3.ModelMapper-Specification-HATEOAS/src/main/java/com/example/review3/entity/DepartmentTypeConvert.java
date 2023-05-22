package com.example.review3.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by quan0
 * Date 5/22/2023 - 4:31 PM
 * Description: ...
 */
@Converter(autoApply = true)
public class DepartmentTypeConvert implements AttributeConverter<Department.Type ,String> {


    @Override
    public String convertToDatabaseColumn(Department.Type type) {
        if (type == null) {
            return null;
        }

        return type.getValue();
    }

    @Override
    public Department.Type convertToEntityAttribute(String sqlValue) {
        if (sqlValue == null) {
            return null;
        }

        return Department.Type.toEnum(sqlValue);
    }
}
