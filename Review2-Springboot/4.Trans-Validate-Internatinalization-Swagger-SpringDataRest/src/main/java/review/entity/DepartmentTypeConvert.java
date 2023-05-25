package review.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by quan0
 * Date 5/25/2023 - 2:36 PM
 * Description: ...
 */
@Converter(autoApply = true)
public class DepartmentTypeConvert implements AttributeConverter<Department.Type, String> {
    @Override
    public String convertToDatabaseColumn(Department.Type type) {
        if(type == null){
            return null;
        }
        return type.getValue();
    }

    @Override
    public Department.Type convertToEntityAttribute(String sqlValue) {
        return null;
    }
}
