package com.example.review3.specification;

import com.example.review3.entity.Department;
import com.example.review3.form.DepartmentFilterForm;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.util.Date;

/**
 * Created by quan0
 * Date 5/24/2023 - 9:56 PM
 * Description: ...
 */
public class DepartmentSpecification {

    @SuppressWarnings("deprecation")
    public static Specification<Department> buildWhere(String search, DepartmentFilterForm filterForm) {

        Specification<Department> where = null;

        if (!StringUtils.isEmpty(search)) {
            search = search.trim();
            CustomSpecificationDepartment username = new CustomSpecificationDepartment("username", search);
            where = Specification.where(username);
        }
        // if there is filter by min created date
        if (filterForm != null && filterForm.getCreatedDate() != null) {
            CustomSpecificationDepartment createdDate = new CustomSpecificationDepartment("createdDate", filterForm.getCreatedDate());
            if (where == null) {
                where = createdDate;
            } else {
                where = where.and(createdDate);
            }
        }

        // if there is filter by min created date
        if (filterForm != null && filterForm.getMinCreatedDate() != null) {
            CustomSpecificationDepartment minCreatedDate = new CustomSpecificationDepartment("minCreatedDate", filterForm.getMinCreatedDate());
            if (where == null) {
                where = minCreatedDate;
            } else {
                where = where.and(minCreatedDate);
            }
        }

        // if there is filter by max created date
        if (filterForm != null && filterForm.getMaxCreatedDate() != null) {
            CustomSpecificationDepartment maxCreatedDate = new CustomSpecificationDepartment("maxCreatedDate", filterForm.getMaxCreatedDate());
            if (where == null) {
                where = maxCreatedDate;
            } else {
                where = where.and(maxCreatedDate);
            }
        }

        // if there is filter by min year
        if (filterForm != null && filterForm.getMinYear() != null) {
            CustomSpecificationDepartment minYear = new CustomSpecificationDepartment("minYear", filterForm.getMinYear());
            if (where == null) {
                where = minYear;

            } else {
                where = where.and(minYear);
            }
        }

        return where;
    }
}

@SuppressWarnings("serial")
@RequiredArgsConstructor
class CustomSpecificationDepartment implements Specification<Department> {

    @NonNull
    private String field;
    @NonNull
    private Object value;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Predicate toPredicate(
            Root<Department> root,
            CriteriaQuery<?> query,
            CriteriaBuilder criteriaBuilder) {

        if (field.equalsIgnoreCase("username")) {
            Join join = root.join("accounts", JoinType.LEFT);
            return criteriaBuilder.like(join.get("username"), "%" + value.toString() + "%");
        }

        if (field.equalsIgnoreCase("createdDate")) {
            return criteriaBuilder.equal(
                    root.get("createdDate").as(java.sql.Date.class),
                    (Date) value);
        }

        if (field.equalsIgnoreCase("minCreatedDate")) {
            return criteriaBuilder.greaterThanOrEqualTo(
                    root.get("createdDate").as(java.sql.Date.class),
                    (Date) value);
        }

        if (field.equalsIgnoreCase("maxCreatedDate")) {
            return criteriaBuilder.lessThanOrEqualTo(
                    root.get("createdDate").as(java.sql.Date.class),
                    (Date) value);
        }

        if (field.equalsIgnoreCase("minYear")) {
            return criteriaBuilder.greaterThanOrEqualTo(
                    criteriaBuilder.function("YEAR", Integer.class, root.get("createdDate")),
                    (Integer) value);
        }

        return null;
    }
}

