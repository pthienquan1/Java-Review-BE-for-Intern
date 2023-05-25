package com.example.review3.form;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by quan0
 * Date 5/24/2023 - 8:54 PM
 * Description: ...
 */
@Data
@NoArgsConstructor
public class DepartmentFilterFormm {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date minCreatedDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date maxCreatedDate;

    private Integer minYear;
}
