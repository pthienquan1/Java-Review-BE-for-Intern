package review.form;

import lombok.Data;
import lombok.NoArgsConstructor;
import review.entity.Account;

import java.util.List;

/**
 * Created by quan0
 * Date 5/26/2023 - 4:18 PM
 * Description: ...
 */
@Data
@NoArgsConstructor
public class CreatingDepartmentForm {
    private String name;
    private int totalMember;
    private String type;
    private List<Account> accounts;

    @Data
    @NoArgsConstructor
    private static class Account{
        private String username;
    }
}
