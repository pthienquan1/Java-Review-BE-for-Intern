package review.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by quan0
 * Date 5/25/2023 - 3:35 PM
 * Description: ...
 */
@Data
@NoArgsConstructor
public class AccountDTO {
    private int id;
    private String username;
    private String departmentName;
}
