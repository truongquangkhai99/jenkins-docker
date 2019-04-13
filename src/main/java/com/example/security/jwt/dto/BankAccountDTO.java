package com.example.security.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BankAccountDTO {

    private String fullName;

    private double balance;
}
