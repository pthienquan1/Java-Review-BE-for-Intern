package com.example.review3.form;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by quan0
 * Date 5/22/2023 - 7:37 PM
 * Description: ...
 */
@Data
@NoArgsConstructor
public class AccountFilterForm {
    private Integer minId;
    private Integer maxId;
}
