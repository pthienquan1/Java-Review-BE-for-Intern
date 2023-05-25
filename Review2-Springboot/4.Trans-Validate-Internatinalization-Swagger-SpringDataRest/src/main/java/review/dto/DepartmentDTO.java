package review.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;
import java.util.List;

/**
 * Created by quan0
 * Date 5/25/2023 - 3:35 PM
 * Description: ...
 */
@Data
@NoArgsConstructor
public class DepartmentDTO extends RepresentationModel<DepartmentDTO> {
    private int id;
    private String name;
    private String type;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;

    private List<AccountDTO> accountDTOS;

    @Data
    @NoArgsConstructor
    public static class AccountDTO extends RepresentationModel<DepartmentDTO>{
        @JsonProperty("accountId")
        private int id;
        private String username;
    }

}
