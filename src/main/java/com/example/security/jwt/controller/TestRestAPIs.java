package com.example.security.jwt.controller;

import com.example.security.jwt.dto.BankAccountDTO;
import com.example.security.jwt.entity.BankAccount;
import com.example.security.jwt.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestRestAPIs {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String userAccess() {
        return ">>> User Contents!";
    }

    @GetMapping("/pm")
    @PreAuthorize("hasRole('PM') or hasRole('ADMIN')")
    public String projectManagementAccess() {
        return ">>> Board Management Project";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return ">>> Admin Contents";
    }

    @GetMapping("/ba")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM')")
    public List<BankAccount> getBankAccounts(@RequestParam(value = "fullname") String fullName) {
        if (StringUtils.isEmpty(fullName)) {
            return Collections.emptyList();
        }
        return bankAccountRepository.findAllByFullNameLike(fullName);
    }

    @GetMapping("/ba_dto")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM')")
    public List<BankAccountDTO> getBankAccountsDTO(@RequestParam(value = "fullname") String fullName) {
        if (StringUtils.isEmpty(fullName)) {
            return Collections.emptyList();
        }
        return bankAccountRepository.retrieveDataToBankAccountDTO(fullName);
    }
}
