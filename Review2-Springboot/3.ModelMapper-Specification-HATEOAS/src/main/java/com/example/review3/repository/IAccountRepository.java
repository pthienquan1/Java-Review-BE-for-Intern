package com.example.review3.repository;

import com.example.review3.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by quan0
 * Date 5/22/2023 - 5:01 PM
 * Description: ...
 */
public interface IAccountRepository extends JpaRepository<Account,Integer> {
}
