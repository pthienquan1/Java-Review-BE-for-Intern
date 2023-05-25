package review.specification.account;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import review.entity.Account;
import review.form.AccountFilterForm;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by quan0
 * Date 5/25/2023 - 4:53 PM
 * Description: ...
 */
public class AccountSpecification {
    @SuppressWarnings("deprecation")
    public static Specification<Account> buildWhere(String search, AccountFilterForm filterForm){
        Specification<Account> where = null;
        if(!StringUtils.isEmpty(search) ){
            search = search.trim();
            CustomSpecification username = new CustomSpecification("username",search);
            CustomSpecification departmentName = new CustomSpecification("departmentName",search);
            where = Specification.where(username).or(departmentName);
        }
        if(filterForm != null && filterForm.getMinID() != null){
            CustomSpecification minID = new CustomSpecification("minID",filterForm.getMinID());
            if(where == null){
                where = minID;
            }else{
                where = where.and(minID);
            }
        }
        if(filterForm != null && filterForm.getMaxID() != null){
            CustomSpecification maxID = new CustomSpecification("maxID", filterForm.getMaxID());
            if(where == null){
                where = maxID;
            }
            else{
                where = where.and(maxID);
            }
        }
        return where;
    }

}

@SuppressWarnings("serial")
@RequiredArgsConstructor
@NoArgsConstructor
class CustomSpecification implements Specification<Account> {

    @NonNull
    private String field;
    @NonNull
    private Object value;

    @Override
    public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(field.equalsIgnoreCase("username")){
            return criteriaBuilder.like(root.get("username"), "%" + value.toString() +"%");
        }
        if(field.equalsIgnoreCase("minID")){
            return criteriaBuilder.greaterThanOrEqualTo(root.get("id"), value.toString());
        }
        if(field.equalsIgnoreCase("maxID")){
            return criteriaBuilder.lessThanOrEqualTo(root.get("id"),value.toString());
        }
        if(field.equalsIgnoreCase("departmentName")){
            return criteriaBuilder.like(root.get("departmentName"), "%" + value.toString() + "%");
        }
        return null;
    }
}
