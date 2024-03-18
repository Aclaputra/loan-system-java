package com.enigmacamp.entity;

import com.enigmacamp.constant.ApprovalStatus;

import java.util.List;

public class LoanTransaction {
    private String id;
    private LoanType loanType;
    private InstalmentType instalmentType;
    private Customer customer;
    private Double nominal;
    private Long approvedAt;
    private String approvedBy;
    private ApprovalStatus approvalStatus; // enum
    private List<LoanTransactionDetail> loanTransactionDetails;
    private Long createdAt;
    private Long updatedAt;
}

