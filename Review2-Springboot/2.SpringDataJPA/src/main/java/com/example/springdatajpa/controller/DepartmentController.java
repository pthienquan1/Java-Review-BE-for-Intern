package com.example.springdatajpa.controller;

import com.example.springdatajpa.entity.Department;
import com.example.springdatajpa.form.DepartmentForm;
import com.example.springdatajpa.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

//    @GetMapping()
//    public List<Department> getAllDepartment(){
//        return service.getAllDepartments();
//    }
    @GetMapping()
    public Page<Department> getAllDepartments(Pageable pageable){
        return service.getAllDepartments(pageable);
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

    @PutMapping("/update")
    public void updateDepartment(@RequestParam(name="id",value = "") int id, @RequestParam(name = "name" ,value="")String newName){
        service.updateDepartment2(id,newName);
    }
}
