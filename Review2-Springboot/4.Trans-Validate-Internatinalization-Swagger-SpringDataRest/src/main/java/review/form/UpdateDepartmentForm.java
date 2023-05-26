package review.form;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by quan0
 * Date 5/26/2023 - 9:09 PM
 * Description: ...
 */
@Data
@NoArgsConstructor
public class UpdateDepartmentForm {
    private int id;
    private String name;
    private int totalMember;
    private String type;
}
