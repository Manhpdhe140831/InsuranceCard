package com.example.insurancecard.dto;

import com.example.insurancecard.entity.Account;
import com.example.insurancecard.entity.Role;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;

@Getter
@Setter
public class AccountDto {
    private long id;
    private String username;
    private String password;
    private String name;
//    private boolean gender;
    private String folk;
    private Date brithDate;
    private String phone;
    private String email;

    private String country;
    private String city;
    private String district;
    private String street;

    private RoleDto role;

    public AccountDto() {
    }

    public AccountDto(Account account){
        if(null != account){
            this.setId(account.getId());
            this.setUsername(account.getUsername());
            this.setPassword(account.getPassword());
            this.setName(account.getName());
//            this.setGender(account.isGender());
            this.setFolk(account.getFolk());
            this.setBrithDate(account.getBrithDate());
            this.setPhone(account.getPhone());
            this.setCountry(account.getCountry());
            this.setCity(account.getCity());
            this.setDistrict(account.getDistrict());
            this.setStreet(account.getStreet());
            this.setEmail(account.getEmail());
            if(account.getRole()!=null){
                role =new RoleDto(account.getRole());
            }
        }

    }





}
