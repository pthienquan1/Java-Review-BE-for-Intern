package com.example.review3.service;

import com.example.review3.entity.Department;

import java.util.List;

/**
 * Created by quan0
 * Date 5/22/2023 - 5:04 PM
 * Description: ...
 */
public interface IDepartmentService {
    public List<Department> getAllDepartments();

    public Department getDepartmentByID(int id);
}
