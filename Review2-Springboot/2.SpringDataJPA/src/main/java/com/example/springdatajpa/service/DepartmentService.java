package com.example.springdatajpa.service;

import com.example.springdatajpa.entity.Department;
import com.example.springdatajpa.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by quan0
 * Date 5/21/2023 - 1:51 PM
 * Description: ...
 */
@Service
public class DepartmentService implements IDepartmentService{
    @Autowired
    private IDepartmentRepository repository;

//    @Override
//    public List<Department> getAllDepartments(){
//        return repository.findAll();
//    }
    @Override
    public Department getDepartmentById(int id){
        return repository.findById(id).get();
    }
    @Override
    public Department getDepartmentByName(String name) {
        return repository.findByDepartmentName(name);
    }

    @Override
    public void createDepartment(Department department){
        repository.save(department);
    }
    @Override
    public void updateDepartment(Department department){
        repository.save(department);
    }
    @Override
    public void deleteDepartmentById(int id){
        repository.deleteById(id);
    }


    @Override
    public Page<Department> getAllDepartments(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void updateDepartment2(int id, String newName) {
        Department department = repository.findById(id).get();
        department.setDepartmentName(newName);
        repository.save(department);
    }
}
