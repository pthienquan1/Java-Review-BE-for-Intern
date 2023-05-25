package review.form;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by quan0
 * Date 5/25/2023 - 4:14 PM
 * Description: ...
 */
@Data
@NoArgsConstructor
public class AccountFilterForm {
    private Integer minID;
    private Integer maxID;
}
