package com.example.review3.service;

import com.example.review3.entity.Department;
import com.example.review3.form.DepartmentFilterFormm;
import com.example.review3.repository.IDepartmentRepository;
import com.example.review3.specification.DepartmentSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 * Created by quan0
 * Date 5/22/2023 - 5:06 PM
 * Description: ...
 */
@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    private IDepartmentRepository repository;

//    @Override
//    public List<Department> getAllDepartments() {
//        return repository.findAll();
//    }

    @Override
    public Page<Department> getAllDepartments(Pageable pageable, String search, DepartmentFilterFormm filterForm) {

        Specification<Department> where = DepartmentSpecification.buildWhere(search, filterForm);
        return repository.findAll(where, pageable);
    }

    @Override
    public Department getDepartmentByID(int id) {
        return repository.findById(id).get();
    }
}
