package com.example.insurancecard.service;

import com.example.insurancecard.dto.AccountDto;
import com.example.insurancecard.entity.Account;

import java.util.List;

public interface AccountService {
    List<AccountDto> getAll();

    AccountDto saveAccount(AccountDto accountDto);

    List<AccountDto> getListStaff();
    List<AccountDto> getListCustomer();




}
