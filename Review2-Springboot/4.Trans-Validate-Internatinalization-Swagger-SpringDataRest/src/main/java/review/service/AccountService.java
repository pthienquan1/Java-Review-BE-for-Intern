package review.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import review.entity.Account;
import review.form.AccountFilterForm;
import review.repository.IAccountRepository;

/**
 * Created by quan0
 * Date 5/25/2023 - 4:27 PM
 * Description: ...
 */
@Service
public class AccountService implements IAccountService{
    @Autowired
    private IAccountRepository repository;


    @Override
    public Page<Account> getAllAccounts(Pageable pageable, AccountFilterForm filterForm, String search) {
        return null;
    }

    @Override
    public Account getAccountById(int id) {
        return repository.findById(id).get();
    }
}
