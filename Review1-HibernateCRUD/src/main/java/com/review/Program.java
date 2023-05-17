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

        System.out.println("------GET DEPARTMENT BY ID-------");
        Department department1 = repository.getDepartmentById((short) 1);
        System.out.println(department1);

        System.out.println("-----GET DEPARTMETN BY NAME-----");
        Department department2 = repository.getDepartmentByName("BOD");
        System.out.println(department2);

        System.out.println("----CREATE DEPARTMENT------");
        Department department3 = new Department();
        department3.setName("Test01");
        repository.createDepartment(department3);

        System.out.println("----UPDATE DEPARTMENT-----");
        repository.updateDepartment((short) 2,"Update");

        System.out.println("---DELETE DEPARTMENT-----");
        repository.deleteDepartment((short) 2);
    }
}
