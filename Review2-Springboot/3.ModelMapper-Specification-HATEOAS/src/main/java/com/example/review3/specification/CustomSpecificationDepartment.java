package com.example.review3.specification;

import com.example.review3.entity.Department;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;

@RequiredArgsConstructor
@SuppressWarnings("serial")
public class CustomSpecificationDepartment implements Specification<Department> {

    @NonNull
    private String field;
    @NonNull
    private Object value;

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if ( field.equalsIgnoreCase("username") ) {
            Join join = root.join("accounts", JoinType.LEFT);
            return criteriaBuilder.like(join.get("username"), "%" + value.toString() + "%");
        }
        return null;
    }
}


