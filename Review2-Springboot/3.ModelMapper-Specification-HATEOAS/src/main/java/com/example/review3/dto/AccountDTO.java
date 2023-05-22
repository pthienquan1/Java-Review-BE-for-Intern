package com.example.review3.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created by quan0
 * Date 5/22/2023 - 4:56 PM
 * Description: ...
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    @NonNull
    private String username;

    @NonNull
    private String departmentName;
}
