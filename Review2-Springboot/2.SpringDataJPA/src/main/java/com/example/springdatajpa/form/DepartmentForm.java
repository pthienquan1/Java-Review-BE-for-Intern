package com.example.springdatajpa.form;

import com.example.springdatajpa.entity.Department;

/**
 * Created by quan0
 * Date 5/21/2023 - 2:10 PM
 * Description: ...
 */
public class DepartmentForm {
    private String name;

    public DepartmentForm() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Department toEntity() {
        return new Department(name);
    }


}
