package com.example.security.jwt.repository;

import com.example.security.jwt.dto.BankAccountDTO;
import com.example.security.jwt.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    @Query(value = "SELECT ba FROM BankAccount ba WHERE ba.fullName LIKE %:fullName%")
    List<BankAccount>findAllByFullNameLike(@Param(value = "fullName") String fullName);

    @Query(value = "SELECT new com.example.security.jwt.dto.BankAccountDTO(ba.fullName, ba.balance) FROM BankAccount ba WHERE ba.fullName LIKE %:fullName%")
    List<BankAccountDTO>retrieveDataToBankAccountDTO(@Param(value = "fullName") String fullName);
}
