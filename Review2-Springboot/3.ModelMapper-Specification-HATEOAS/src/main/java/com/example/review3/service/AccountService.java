package com.example.review3.service;

import com.example.review3.entity.Account;
import com.example.review3.form.DepartmentFilterForm;
import com.example.review3.repository.IAccountRepository;
import com.example.review3.service.IAccountService;
import com.example.review3.specification.AccountSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by quan0
 * Date 5/22/2023 - 5:06 PM
 * Description: ...
 */
@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository repository;

//    @Override
//    public List<Account> getAllAccounts() {
//        return repository.findAll();
//    }

    @Override
    public Account getAccountByID(int id) {
        return repository.findById(id).get();
    }

    public Page<Account> getAllAccounts(Pageable pageable, String search, DepartmentFilterForm filterForm){
        Specification<Account> where = AccountSpecification.buildWhere(search,filterForm);
        return repository.findAll(where,pageable);
    }
}
