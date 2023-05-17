package com.review.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by quan0
 * Date 5/17/2023 - 1:28 PM
 * Description: ...
 */
@Getter
@Setter
@Entity
@ToString
@Table(name="department")
public class Department {
    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name="name",length = 50, nullable = false,unique = true)
    private String name;

    public Department() {

    }
}
