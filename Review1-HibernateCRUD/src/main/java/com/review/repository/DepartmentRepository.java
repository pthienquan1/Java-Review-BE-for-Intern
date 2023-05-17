package com.review.repository;

import com.review.entity.Department;
import com.review.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by quan0
 * Date 5/17/2023 - 2:14 PM
 * Description: ...
 */
public class DepartmentRepository {
    private HibernateUtils hibernateUtils;

    public DepartmentRepository(){
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Department> getAllDepartment(){
        Session session = null;
        try{
            session = hibernateUtils.openSession();

            Query<Department> query = session.createQuery("FROM Department");
            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }

    }

    public Department getDepartmentById(short id){
        Session session = null;
        try{
            session = hibernateUtils.openSession();
            Department department = session.get(Department.class,id);
            return department;
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public Department getDepartmentByName(String name) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<Department> query = session.createQuery("FROM Department WHERE name = :nameParameter");
            query.setParameter("nameParameter", name);
            Department dept = query.uniqueResult();
            return dept;
        } finally {
            if ( session != null ) {
                session.close();
            }
        }
    }
}
