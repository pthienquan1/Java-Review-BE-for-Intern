package review.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

/**
 * Created by quan0
 * Date 5/25/2023 - 3:35 PM
 * Description: ...
 */
@Data
@NoArgsConstructor
public class AccountDTO extends RepresentationModel<DepartmentDTO> {
    private int id;
    private String username;
    private String departmentName;
}
