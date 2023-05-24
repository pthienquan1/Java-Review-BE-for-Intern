package com.example.review3.service;

import com.example.review3.entity.Department;
import com.example.review3.form.DepartmentFilterForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by quan0
 * Date 5/22/2023 - 5:04 PM
 * Description: ...
 */
public interface IDepartmentService {
//    public List<Department> getAllDepartments();
    public Page<Department> getAllDepartments(Pageable pageable, String search, DepartmentFilterForm departmentFilterForm);

    public Department getDepartmentByID(int id);
}
