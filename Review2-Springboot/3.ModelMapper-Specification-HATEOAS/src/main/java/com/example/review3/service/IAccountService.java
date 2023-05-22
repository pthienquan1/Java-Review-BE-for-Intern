package com.example.review3.service;

import com.example.review3.entity.Account;

import java.util.List;

/**
 * Created by quan0
 * Date 5/22/2023 - 5:04 PM
 * Description: ...
 */
public interface IAccountService {
    public List<Account> getAllAccounts();

    public Account getAccountByID(int id);
}
