package review.form;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import review.entity.Account;
import review.validation.DepartmentNameNotExists;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

/**
 * Created by quan0
 * Date 5/26/2023 - 4:18 PM
 * Description: ...
 */
@Data
@NoArgsConstructor
public class CreatingDepartmentForm {
    @NotBlank(message = "The name mustn't null")
    @Length(max = 50,message = "Max length of name is 50 characters")
    @DepartmentNameNotExists
    private String name;

    @NotNull(message = "Total member mustn't null")
    @PositiveOrZero(message = "Total member must >= 0")
    private int totalMember;

    @NotNull(message = "Type mustn't null")
    @Pattern(regexp = "DEV|TEST|PM|SCRUMMASTER", message = "Type must has only one of: TEST / DEV / PM " )
    private String type;
    private List<Account> accounts;

    @Data
    @NoArgsConstructor
    private static class Account{
        private String username;
    }
}
