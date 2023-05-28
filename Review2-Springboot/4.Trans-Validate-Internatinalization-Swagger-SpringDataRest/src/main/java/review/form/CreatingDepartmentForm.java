package review.form;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import review.entity.Account;
import review.validation.AccountUsernameNotExists;
import review.validation.DepartmentNameNotExists;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

/**
 * Created by quan0
 * Date 5/26/2023 - 4:18 PM
 * Description: ...
 */
@Data
@NoArgsConstructor
public class CreatingDepartmentForm {
    @NotBlank(message = "{Department.createDepartment.form.name.NotBlank}")
    @Length(max = 50,message = "{Department.createDepartment.form.name.Length}")
    @DepartmentNameNotExists
    private String name;

    @NotNull(message = "Total member mustn't null")
    @PositiveOrZero(message = "Total member must >= 0")
    private int totalMember;

    @NotNull(message = "Type mustn't null")
    @Pattern(regexp = "DEV|TEST|PM|SCRUMMASTER", message = "Type must has only one of: TEST / DEV / PM " )
    private String type;
    @NotEmpty(message = "Accounts mustn't be empty")
    private List<@Valid Account> accounts;

    @Data
    @NoArgsConstructor
    public static class Account {

        @NotBlank(message = "The name mustn't be null value")
        @Length(max = 50, message = "The name's length is max 50 characters")
        @AccountUsernameNotExists
        private String username;
    }
}

