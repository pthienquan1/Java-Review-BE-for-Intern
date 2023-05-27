package review.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import review.service.IDepartmentService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by quan0
 * Date 5/27/2023 - 4:01 PM
 * Description: ...
 */

public class DepartmentNameNotExistsValidator implements ConstraintValidator<DepartmentNameNotExists, String> {

    @Autowired
    private IDepartmentService service;

    @SuppressWarnings("deprecation")
    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {

        if (StringUtils.isEmpty(name)) {
            return true;
        }

        return !service.isDepartmentExistsByName(name);
    }
}
