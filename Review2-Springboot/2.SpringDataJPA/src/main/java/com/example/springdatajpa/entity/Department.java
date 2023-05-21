package com.example.springdatajpa.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by quan0
 * Date 5/21/2023 - 1:35 PM
 * Description: ...
 */
@Entity
@Table(name ="Department")
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="DepartmentID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;

    @Column(name="DepartmentName", length = 30, nullable = false, unique = true)
    private String departmentName;

    @Column(name="TotalMember")
    private int totalMember;

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department(int departmentId) {
        this.departmentId = departmentId;
    }
    public Department(){

    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getTotalMember() {
        return totalMember;
    }

    public void setTotalMember(int totalMember) {
        this.totalMember = totalMember;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", totalMember=" + totalMember +
                '}';
    }
}
