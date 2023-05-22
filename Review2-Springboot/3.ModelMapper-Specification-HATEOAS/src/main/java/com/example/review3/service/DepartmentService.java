package com.example.review3.service;

import com.example.review3.entity.Department;
import com.example.review3.repository.IDepartmentRepository;
import com.example.review3.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by quan0
 * Date 5/22/2023 - 5:06 PM
 * Description: ...
 */
@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    private IDepartmentRepository repository;

    @Override
    public List<Department> getAllDepartments() {
        return repository.findAll();
    }

    @Override
    public Department getDepartmentByID(int id) {
        return repository.findById(id).get();
    }
}
