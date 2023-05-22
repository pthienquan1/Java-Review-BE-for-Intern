package com.example.review3.specification;

import com.example.review3.entity.Account;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by quan0
 * Date 5/22/2023 - 6:56 PM
 * Description: ...
 */
public class AccountSpecification {
    @SuppressWarnings("deprecation")
    public static Specification<Account> buildWhere(String search){
        if( StringUtils.isEmpty(search) ){
            return null;
        }
        search = search.trim();
        CustomSpecification name = new CustomSpecification("username",search);
        return Specification.where(name);
    }
}

@SuppressWarnings("serial")
@RequiredArgsConstructor
class CustomSpecification implements Specification<Account>{
    @NonNull
    private String field;
    @NonNull
    private Object value;


    @Override
    public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(field.equalsIgnoreCase("username")){
            return criteriaBuilder.like(root.get("username"), "%" +value.toString() + "%");
        }
        return null;
    }
}
