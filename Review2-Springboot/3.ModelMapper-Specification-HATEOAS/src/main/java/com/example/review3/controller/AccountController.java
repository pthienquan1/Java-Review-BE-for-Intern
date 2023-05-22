package com.example.review3.controller;

import com.example.review3.dto.AccountDTO;
import com.example.review3.entity.Account;
import com.example.review3.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quan0
 * Date 5/22/2023 - 5:15 PM
 * Description: ...
 */
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    @Autowired
    private IAccountService service;

    @GetMapping()
    public List<AccountDTO> getAllAccounts(){
        List<Account> entities = service.getAllAccounts();
        List<AccountDTO> dtos = new ArrayList<>();
        for(Account entity:entities){
            AccountDTO dto = new AccountDTO(entity.getUsername(),entity.getDepartment().getName());
            dtos.add(dto);
        }
        return dtos;
    }

    @GetMapping(value="/{id}")
    public AccountDTO getAccountById(@PathVariable(name="id") int id){
        Account entity = service.getAccountByID(id);
        AccountDTO dto = new AccountDTO(entity.getUsername(),entity.getDepartment().getName());
        return dto;
    }
}
