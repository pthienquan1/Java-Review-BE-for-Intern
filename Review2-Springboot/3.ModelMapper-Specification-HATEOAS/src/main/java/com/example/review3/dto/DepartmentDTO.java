package com.example.review3.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * Created by quan0
 * Date 5/24/2023 - 1:25 PM
 * Description: ...
 */
@Data
@NoArgsConstructor
public class DepartmentDTO {
    private String name;
    private String type;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    private List<AccountDTO> accounts;
    @Data
    @NoArgsConstructor
    static class AccountDTO {

        @JsonProperty("accountId")
        private int id;

        private String username;
    }
}
