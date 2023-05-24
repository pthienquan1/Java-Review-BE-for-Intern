package com.example.review3.specification;

import com.example.review3.entity.Department;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class DepartmentSpecification {
    @SuppressWarnings("deprecation")
    public static Specification<Department> buildWhere(String search) {
        Specification<Department> where = null;
        if ( !StringUtils.isEmpty(search) ) {
            search = search.trim();
            CustomSpecificationDepartment username = new CustomSpecificationDepartment("username", search);
            where = Specification.where(username);
        }
        return where;
    }
}
