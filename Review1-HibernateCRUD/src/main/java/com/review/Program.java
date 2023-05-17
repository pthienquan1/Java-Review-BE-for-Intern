package com.review;

import com.review.entity.Department;
import com.review.repository.DepartmentRepository;

import java.util.List;

/**
 * Created by quan0
 * Date 5/17/2023 - 2:19 PM
 * Description: ...
 */
public class Program {
    public static void main(String[] args){
        DepartmentRepository repository = new DepartmentRepository();
        System.out.println("--------GET ALL DEPARTMENT-----");
        List<Department> departments = repository.getAllDepartment();
        for(Department d:departments){
            System.out.println(d);
        }
    }
}
