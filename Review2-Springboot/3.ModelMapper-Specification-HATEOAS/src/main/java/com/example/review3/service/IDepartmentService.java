package com.example.review3.service;

import com.example.review3.entity.Department;
import com.example.review3.form.DepartmentFilterFormm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by quan0
 * Date 5/22/2023 - 5:04 PM
 * Description: ...
 */
public interface IDepartmentService {
//    public List<Department> getAllDepartments();
    public Page<Department> getAllDepartments(Pageable pageable, String search, DepartmentFilterFormm departmentFilterForm);

    public Department getDepartmentByID(int id);
}
