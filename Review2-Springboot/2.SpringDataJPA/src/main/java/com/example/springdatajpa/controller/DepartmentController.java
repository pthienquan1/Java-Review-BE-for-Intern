package com.example.springdatajpa.controller;

import com.example.springdatajpa.entity.Department;
import com.example.springdatajpa.form.DepartmentForm;
import com.example.springdatajpa.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by quan0
 * Date 5/21/2023 - 2:05 PM
 * Description: ...
 */
@RestController
@RequestMapping(value="api/v1/departments")
public class DepartmentController {
    @Autowired
    IDepartmentService service;

    @GetMapping()
    public List<Department> getAllDepartment(){
        return service.getAllDepartments();
    }
    @GetMapping(value= "/{id}")
    public Department getDepartmentById(@PathVariable(name="id") int id){
        return service.getDepartmentById(id);
    }
    @GetMapping(value="/name/{name}")
    public Department getDepartmentByName(@PathVariable(name="name") String name){
        return service.getDepartmentByName(name);
    }
    @PostMapping
    public void createDepartment(@RequestBody DepartmentForm form){
        service.createDepartment(form.toEntity());
    }
}
