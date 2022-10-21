package com.example.insurancecard.service.impl;

import com.example.insurancecard.dto.MotorBikeDto;
import com.example.insurancecard.entity.Account;
import com.example.insurancecard.entity.MotorBike;
import com.example.insurancecard.repository.AccountRepository;
import com.example.insurancecard.repository.MotorBikeRepository;
import com.example.insurancecard.service.MotorBikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MotorbikeServiceImpl implements MotorBikeService {

    @Autowired
    private MotorBikeRepository repository;
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public List<MotorBikeDto> getAll() {
        List<MotorBikeDto> list = new ArrayList<>();
        List<MotorBike> listMotorbike = repository.findAll();
        for (MotorBike item: listMotorbike
             ) {
            list.add(new MotorBikeDto(item));
        }
        return list;
    }

    @Override
    public MotorBikeDto getMotorbikeById(Long id) {
        return null;
    }

    @Override
    public Boolean removeMotorbike(Long id) {
        return null;
    }

    @Override
    public MotorBikeDto save(MotorBikeDto motorBikeDto) {
        if (null != motorBikeDto){
            MotorBike motorBike = new MotorBike();
            motorBike.setId(motorBikeDto.getId());
            motorBike.setLicense(motorBikeDto.getLicense());
            motorBike.setModel(motorBikeDto.getModel());
            motorBike.setManufacturer(motorBikeDto.getManufacturer());
            motorBike.setColor(motorBikeDto.getColor());
            motorBike.setMFG(motorBikeDto.getMFG());
            motorBike.setFrameNumber(motorBikeDto.getFrameNumber());
            motorBike.setImage(motorBikeDto.getImage());
            if (null != motorBikeDto.getAccountDto()){
                Account account = null;
                Optional<Account> optional = accountRepository.findById(motorBikeDto.getAccountDto().getId());
                if (optional.isPresent()){
                    account = optional.get();
                }
                motorBike.setAccount(account);
            }
            motorBike = repository.save(motorBike);
            if (null != motorBike){
                return new MotorBikeDto(motorBike);
            }
        }
        return null;
    }


}
