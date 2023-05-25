package review.form;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import review.entity.Department;

import java.util.Date;

/**
 * Created by quan0
 * Date 5/25/2023 - 4:14 PM
 * Description: ...
 */
@Data
@NoArgsConstructor
public class DepartmentFilterForm {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date minCreatedDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date maxCreatedDate;

    private Integer minYear;

    private Department.Type type;
}
