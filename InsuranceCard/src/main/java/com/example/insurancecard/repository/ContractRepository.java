package com.example.insurancecard.repository;

import com.example.insurancecard.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

    @Query(value = "SELECT c FROM Contract c where c.code like %?1%")
    public List<Contract> findByCode(String code);

    @Query(value = "SELECT c from Contract c where c.account.id = ?1")
    public List<Contract> getContractByAccountId(Long id);

}
