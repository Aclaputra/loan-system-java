package com.enigmacamp.entity;

import com.enigmacamp.constant.LoanStatus;

public class LoanTransactionDetail {
    private String id;
    private Long transactionDate;
    private Double nominal;
    private LoanTransaction loanTransaction;
    private LoanStatus loanStatus; // enum
    private Long createdAt;
    private Long updatedAt;
}

