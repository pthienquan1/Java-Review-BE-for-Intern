package com.example.review3.controller;

import com.example.review3.dto.AccountDTO;
import com.example.review3.entity.Account;
import com.example.review3.service.IAccountService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private ModelMapper modelMapper;

//    @GetMapping()
//    public List<AccountDTO> getAllAccounts(){
//        List<Account> entities = service.getAllAccounts();
//        List<AccountDTO> dtos = new ArrayList<>();
//        for(Account entity:entities){
//            AccountDTO dto = new AccountDTO(entity.getUsername(),entity.getDepartment().getName());
//            dtos.add(dto);
//        }
//        return dtos;
//    }
//    @GetMapping()
//    public List<AccountDTO> getAllAccounts(){
//        List<Account> entities = service.getAllAccounts();
//        List<AccountDTO> dtos = modelMapper.map(entities, new TypeToken<List<AccountDTO>>() {
//        }.getType());
//        return dtos;
//    }


    @GetMapping()
    public Page<AccountDTO> getAllAccounts(Pageable pageable, @RequestParam(value="search",required = false) String search){
        Page<Account> entitiesPage = service.getAllAccounts(pageable,search);
        List<AccountDTO> dtos = modelMapper.map(entitiesPage.getContent(), new TypeToken<List<AccountDTO>>() {}.getType());
        Page<AccountDTO> dtosPages = new PageImpl<>(dtos,pageable,entitiesPage.getTotalElements());
        return dtosPages;
    }
//    @GetMapping(value="/{id}")
//    public AccountDTO getAccountById(@PathVariable(name="id") int id){
//        Account entity = service.getAccountByID(id);
//        AccountDTO dto = new AccountDTO(entity.getUsername(),entity.getDepartment().getName());
//        return dto;
//    }
    @GetMapping(value="/{id}")
    public AccountDTO getAccountById(@PathVariable(name="id") int id){
        Account entity = service.getAccountByID(id);
        AccountDTO dto = modelMapper.map(entity,AccountDTO.class);
        return dto;
    }
}
