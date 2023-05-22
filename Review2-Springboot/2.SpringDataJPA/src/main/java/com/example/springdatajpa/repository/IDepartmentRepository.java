package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by quan0
 * Date 5/21/2023 - 1:48 PM
 * Description: ...
 */
public interface IDepartmentRepository extends JpaRepository<Department,Integer> {
    public Department findByDepartmentName(String name);
    
}
