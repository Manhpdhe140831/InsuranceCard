package com.example.insurancecard.service.impl;

import com.example.insurancecard.dto.ContractDto;
import com.example.insurancecard.entity.Account;
import com.example.insurancecard.entity.Contract;
import com.example.insurancecard.repository.AccountRepository;
import com.example.insurancecard.repository.ContractRepository;
import com.example.insurancecard.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository repository;
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<ContractDto> getAll() {
        List<ContractDto> list = new ArrayList<>();
        List<Contract> contractList = repository.findAll();
        for (Contract item: contractList
             ) {
            list.add(new ContractDto(item));
        }
        return list;
    }

    @Override
    public ContractDto saveContract(ContractDto contract) {
        if (null != contract){
            Contract con = new Contract();
            con.setCode(contract.getCode());
            con.setBeginDate(contract.getBeginDate());
            con.setEndDate(contract.getEndDate());
            con.setPriceContract(contract.getPriceContract());
            con.setFPF(contract.getFPF());
            con.setSPF(contract.getSPF());
            con.setFPFDate(contract.getFPFDate());
            con.setSPFDate(contract.getSPFDate());
            con.setContractDate(contract.getContractDate());
            if (null != contract.getAccountDto()){
                Account account = null;
                Optional<Account> optional = accountRepository.findById(contract.getAccountDto().getId());
                if (optional.isPresent()){
                    account = optional.get();
                }
                con.setAccount(account);
            }
            con = repository.save(con);
            if (null != con){
                return new ContractDto(con);
            }
        }
        return null;
    }

    @Override
    public ContractDto updateContract(ContractDto contract, Long id) {
        if(null != contract){
            Contract contractObj = null;
            if (null != id){
                Optional<Contract> optional = repository.findById(id);
                if (optional.isPresent()){
                    contractObj = optional.get();
                }
            }
            if (null != contractObj){
                contractObj.setCode(contract.getCode());
                contractObj.setBeginDate(contract.getBeginDate());
                contractObj.setEndDate(contract.getEndDate());
                contractObj.setPriceContract(contract.getPriceContract());
                contractObj.setFPF(contract.getFPF());
                contractObj.setSPF(contract.getSPF());
                contractObj.setFPFDate(contract.getFPFDate());
                contractObj.setSPFDate(contract.getSPFDate());
                contractObj.setContractDate(contract.getContractDate());
                if (null != contract.getAccountDto()){
                    Account account = null;
                    Optional<Account> optional = accountRepository.findById(contract.getAccountDto().getId());
                    if (optional.isPresent()){
                        account = optional.get();
                    }
                    contractObj.setAccount(account);
                    contractObj = repository.save(contractObj);
                    return new ContractDto(contractObj);
                }else {
                    return null;
                }
            }
        }
        return null;
    }

    @Override
    public Boolean removeContract(Long id) {
        Contract contract = null;
        Optional<Contract> optional = repository.findById(id);
        if (optional.isPresent()){
            contract =optional.get();
        }
        if (null != contract){
            repository.delete(contract);
            return true;
        }
        return false;
    }

    @Override
    public List<ContractDto> getContractByAccountID(Long id) {
         List<ContractDto> list = new ArrayList<>();
         List<Contract> listContract = repository.getContractByAccountId(id);
        for (Contract item: listContract
             ) {
            list.add(new ContractDto(item));
        }
        return list;
    }

    @Override
    public List<ContractDto> getContractByFeeContractDate() {
        return null;
    }

    @Override
    public List<ContractDto> findContractByCode(String code) {
        List<ContractDto> listResult = new ArrayList<>();
         List<Contract> listContract = repository.findByCode(code);
        for (Contract item: listContract
             ) {
            listResult.add(new ContractDto(item));
        }
        return listResult;
    }

    @Override
    public ContractDto getContractById(Long id) {
            if (null != id){
                Contract contract = null;
                Optional<Contract> optional = repository.findById(id);
                if (optional.isPresent()){
                    contract = optional.get();
                    return new ContractDto(contract);
                }
            }
            return null;
    }

    @Override
    public ContractDto renewContract(ContractDto contractDto, Long id) {
        return null;
    }

}
