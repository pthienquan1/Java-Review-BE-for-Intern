package com.example.review3.service;

import com.example.review3.entity.Account;
import com.example.review3.form.DepartmentFilterForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by quan0
 * Date 5/22/2023 - 5:04 PM
 * Description: ...
 */
public interface IAccountService {
//    public List<Account> getAllAccounts();
    public Page<Account> getAllAccounts(Pageable pageable, String search, DepartmentFilterForm filterForm);
    public Account getAccountByID(int id);
}
