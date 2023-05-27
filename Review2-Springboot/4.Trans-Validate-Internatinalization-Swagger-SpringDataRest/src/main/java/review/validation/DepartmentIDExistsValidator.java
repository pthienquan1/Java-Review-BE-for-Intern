package review.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import review.repository.IDepartmentRepository;
import review.service.IDepartmentService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by quan0
 * Date 5/27/2023 - 4:45 PM
 * Description: ...
 */
public class DepartmentIDExistsValidator implements ConstraintValidator<DepartmentIDExists, Integer> {

    @Autowired
    private IDepartmentService service;

    @SuppressWarnings("deprecation")
    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext constraintValidatorContext) {

        if (StringUtils.isEmpty(id)) {
            return true;
        }

        return service.isDepartmentExistsByID(id);
    }
}
