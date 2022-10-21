package com.example.insurancecard.service;

import com.example.insurancecard.dto.MotorBikeDto;

import java.util.List;

public interface MotorBikeService {

    List<MotorBikeDto> getAll();
    MotorBikeDto getMotorbikeById(Long id);
    Boolean removeMotorbike(Long id);

    MotorBikeDto save(MotorBikeDto motorBikeDto);
}
