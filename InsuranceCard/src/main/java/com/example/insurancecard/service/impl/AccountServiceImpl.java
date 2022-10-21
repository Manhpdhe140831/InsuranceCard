package com.example.insurancecard.service.impl;

import com.example.insurancecard.dto.AccountDto;
import com.example.insurancecard.entity.Role;
import com.example.insurancecard.repository.AccountRepository;
import com.example.insurancecard.repository.RoleRepository;
import com.example.insurancecard.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.insurancecard.entity.Account;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<AccountDto> getAll() {
        List<Account> list = repository.findAll();
        List<AccountDto> result = new ArrayList<>();
        for (Account acc : list){
            result.add(new AccountDto(acc));
        }
        return result;
    }

    @Override
    public AccountDto saveAccount(AccountDto accountDto) {
        if(accountDto != null){
            Account user = new Account();
            user.setName(accountDto.getName());
            user.setUsername(accountDto.getUsername());
            user.setPassword(accountDto.getPassword());
//            user.setGender(accountDto.isGender());
            user.setFolk(accountDto.getFolk());
            user.setBrithDate(accountDto.getBrithDate());
            user.setPhone(accountDto.getPhone());
            user.setEmail(accountDto.getEmail());

            user.setCountry(accountDto.getCountry());
            user.setCity(accountDto.getCity());
            user.setDistrict(accountDto.getDistrict());
            user.setStreet(accountDto.getStreet());
            if(accountDto.getRole()!=null){
                Role role = null;
                Optional<Role> optional = roleRepository.findById(accountDto.getRole().getId());
                if (optional.isPresent()) {
                    role = optional.get();
                }
                user.setRole(role);
            }
            user = repository.save(user);
            if(user != null){
                return new AccountDto(user);
            }
        }
        return null;
    }

    @Override
    public List<AccountDto> getListStaff() {
        List<AccountDto> listStaff = new ArrayList<>();
        List<Account> list = repository.getListStaff();
        for (Account item: list
             ) {
            listStaff.add(new AccountDto(item));
        }
        return listStaff;
    }

    @Override
    public List<AccountDto> getListCustomer() {
        List<AccountDto> listCustomer = new ArrayList<>();
        List<Account> list = repository.getListCustomer();
        for (Account item: list
             ) {
            listCustomer.add(new AccountDto(item));
        }
        return listCustomer;
    }


}
