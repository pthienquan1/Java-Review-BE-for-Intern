package review.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import review.service.IAccountService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by quan0
 * Date 5/27/2023 - 5:46 PM
 * Description: ...
 */
public class AccountUsernameNotExistsValidator implements ConstraintValidator<AccountUsernameNotExists, String> {

    @Autowired
    private IAccountService service;

    @SuppressWarnings("deprecation")
    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {

        if (StringUtils.isEmpty(username)) {
            return true;
        }

        return !service.isAccountExistsByUsername(username);
    }
}