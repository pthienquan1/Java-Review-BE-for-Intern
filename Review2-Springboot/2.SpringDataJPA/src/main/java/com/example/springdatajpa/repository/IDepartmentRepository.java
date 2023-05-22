package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by quan0
 * Date 5/21/2023 - 1:48 PM
 * Description: ...
 */
public interface IDepartmentRepository extends JpaRepository<Department,Integer> {
    public Department findByDepartmentName(String name);

    //Paging with query
    @Query("SELECT d FROM Department d where d.departmentName LIKE %?1% ")
    Page<Department> findByNamePagin(String name, Pageable pageable);
}
