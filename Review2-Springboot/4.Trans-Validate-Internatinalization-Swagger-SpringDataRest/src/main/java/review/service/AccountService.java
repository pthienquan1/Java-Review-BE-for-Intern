package review.service;

import org.aspectj.asm.IModelFilter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import review.entity.Account;
import review.form.AccountFilterForm;
import review.form.CreatingAccountForm;
import review.repository.IAccountRepository;
import review.specification.account.AccountSpecification;

/**
 * Created by quan0
 * Date 5/25/2023 - 4:27 PM
 * Description: ...
 */
@Service
public class AccountService implements IAccountService{
    @Autowired
    private IAccountRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<Account> getAllAccounts(Pageable pageable, AccountFilterForm filterForm, String search) {
        Specification<Account> where = AccountSpecification.buildWhere(search,filterForm);
        return repository.findAll(where,pageable);
    }

    @Override
    public Account getAccountById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void createAccount(CreatingAccountForm creatingAccountForm) {
        TypeMap<CreatingAccountForm, Account> typeMap = modelMapper.getTypeMap(CreatingAccountForm.class,Account.class);
        if(typeMap == null){
            modelMapper.addMappings(new PropertyMap<CreatingAccountForm, Account>() {

                @Override
                protected void configure() {
                    skip(destination.getId());
                }
            });
        }
        Account account = modelMapper.map(creatingAccountForm,Account.class);
        repository.save(account);
    }
}
