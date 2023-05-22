package com.example.springdatajpa.service;

import com.example.springdatajpa.entity.Department;

import java.util.List;

/**
 * Created by quan0
 * Date 5/21/2023 - 1:51 PM
 * Description: ...
 */
public interface IDepartmentService {
    public List<Department> getAllDepartments();
    public Department getDepartmentById(int id);
    public Department getDepartmentByName(String name);
    public void createDepartment(Department department);
    public void updateDepartment(Department department);
    public void deleteDepartmentById(int id);
}
