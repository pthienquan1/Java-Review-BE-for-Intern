package review.form;

import lombok.Data;
import lombok.NoArgsConstructor;

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
}
