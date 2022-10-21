package com.example.insurancecard.service;

import com.example.insurancecard.dto.ContractDto;
import com.example.insurancecard.entity.Contract;

import java.util.List;

public interface ContractService {

    List<ContractDto> getAll();

    ContractDto saveContract(ContractDto contract);

    ContractDto updateContract(ContractDto contract, Long id);

    Boolean removeContract(Long id);

    List<ContractDto> getContractByAccountID(Long id);


    List<ContractDto> getContractByFeeContractDate();

    List<ContractDto> findContractByCode(String code);

    ContractDto getContractById(Long id);

    ContractDto renewContract(ContractDto contractDto, Long id);
}
