package review.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import review.entity.Account;
import review.form.AccountFilterForm;

/**
 * Created by quan0
 * Date 5/25/2023 - 4:27 PM
 * Description: ...
 */
public interface IAccountService {
    public Page<Account> getAllAccounts(Pageable pageable, AccountFilterForm filterForm, String search);
    public Account getAccountById(int id);
    
    
}
