package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.dto.AccountResponse;
import com.workintech.s18d4.dto.CustomerResponse;

import java.util.List;

public interface AccountService {

    List<Account> findAll();

    Account find(long id);

    Account save(long customer_id , Account account);

    CustomerResponse update(long customer_id , Account account);

    Account delete(long id);

    Account save(Account account);
}
