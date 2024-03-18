package com.enigmacamp.service.impl;

import com.enigmacamp.constant.ApprovalStatus;
import com.enigmacamp.model.dto.request.loan.transaction.ApproveRequest;
import com.enigmacamp.model.dto.request.loan.transaction.TransactionRequest;
import com.enigmacamp.model.dto.response.loan.transaction.TransactionDetailResponse;
import com.enigmacamp.model.dto.response.loan.transaction.TransactionResponse;
import com.enigmacamp.model.entity.*;
import com.enigmacamp.repository.CustomerRepository;
import com.enigmacamp.repository.InstalmentTypeRepository;
import com.enigmacamp.repository.LoanTransactionRepository;
import com.enigmacamp.repository.LoanTypeRepository;
import com.enigmacamp.service.TransactionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private LoanTypeRepository loanTypeRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private InstalmentTypeRepository instalmentTypeRepository;
    @Autowired
    private LoanTransactionRepository loanTransactionRepository;


    @Override
    public TransactionResponse create(TransactionRequest request) {
        LoanType loanType = loanTypeRepository.findById(request.getLoanType().getId()).get();
        Customer customer = customerRepository.findById(request.getCustomer().getId()).get();
        InstalmentType instalmentType = instalmentTypeRepository.findById(request.getInstallmentType().getId()).get();
        List<LoanTransactionDetail> loanTransactionDetails = new ArrayList<>();
        LoanTransaction loanTransaction = LoanTransaction.builder()
                .loanType(loanType)
                .customer(customer)
                .instalmentType(instalmentType)
                .nominal(request.getNominal())
                .createdAt(System.currentTimeMillis())
                .build();

        LoanTransaction savedLoanTransaction = loanTransactionRepository.save(loanTransaction);

        return TransactionResponse.builder()
                .id(savedLoanTransaction.getId())
                .loanTypeId(savedLoanTransaction.getLoanType().getId())
                .installmentTypeId(savedLoanTransaction.getInstalmentType().getId())
                .customerId(savedLoanTransaction.getCustomer().getId())
                .nominal(savedLoanTransaction.getNominal())
                .createdAt(savedLoanTransaction.getCreatedAt())
                .build();
    }

    @Override
    public TransactionResponse getById(String id) {
        LoanTransaction loanTransaction = loanTransactionRepository.findById(id).get();
        List<TransactionDetailResponse> transactionDetailResponses = new ArrayList<>();
        loanTransaction.getLoanTransactionDetails().forEach(detail -> {
            TransactionDetailResponse response = TransactionDetailResponse.builder()
                    .id(detail.getId())
                    .transactionDate(detail.getTransactionDate())
                    .nominal(detail.getNominal())
                    .loanStatus(String.valueOf(detail.getLoanStatus()))
                    .createdAt(detail.getCreatedAt())
                    .updatedAt(detail.getUpdatedAt())
                    .build();

            transactionDetailResponses.add(response);
        });

        return TransactionResponse.builder()
                .id(loanTransaction.getId())
                .loanTypeId(loanTransaction.getLoanType().getId())
                .installmentTypeId(loanTransaction.getInstalmentType().getId())
                .customerId(loanTransaction.getCustomer().getId())
                .nominal(loanTransaction.getNominal())
                .approvedAt(String.valueOf(loanTransaction.getApprovedAt()))
                .approvedBy(loanTransaction.getApprovedBy())
                .approvalStatus(String.valueOf(loanTransaction.getApprovalStatus()))
                .transactionDetailResponses(transactionDetailResponses)
                .createdAt(loanTransaction.getCreatedAt())
                .updatedAt(loanTransaction.getUpdatedAt())
                .build();
    }

    @Override
    @Transactional
    public TransactionResponse approve(ApproveRequest request, String adminId) {
        Customer admin = customerRepository.findById(adminId).get();
        LoanTransaction loanTransaction = loanTransactionRepository.findById(request.getLoanTransactionId()).get();

        loanTransaction.setApprovedAt(System.currentTimeMillis());
        loanTransaction.setApprovedBy(admin.getUser().getEmail());
        loanTransaction.setApprovalStatus(ApprovalStatus.APPROVED);

        LoanTransaction approvedTransaction = loanTransactionRepository.save(loanTransaction);

        List<TransactionDetailResponse> transactionDetailResponses = new ArrayList<>();
        loanTransaction.getLoanTransactionDetails().forEach(detail -> {
            TransactionDetailResponse response = TransactionDetailResponse.builder()
                    .id(detail.getId())
                    .transactionDate(detail.getTransactionDate())
                    .nominal(detail.getNominal())
                    .loanStatus(String.valueOf(detail.getLoanStatus()))
                    .createdAt(detail.getCreatedAt())
                    .updatedAt(detail.getUpdatedAt())
                    .build();

            transactionDetailResponses.add(response);
        });

        return TransactionResponse.builder()
                .id(approvedTransaction.getId())
                .loanTypeId(approvedTransaction.getLoanType().getId())
                .installmentTypeId(approvedTransaction.getInstalmentType().getId())
                .customerId(approvedTransaction.getCustomer().getId())
                .nominal(approvedTransaction.getNominal())
                .approvedAt(String.valueOf(approvedTransaction.getApprovedAt()))
                .approvedBy(approvedTransaction.getApprovedBy())
                .approvalStatus(String.valueOf(approvedTransaction.getApprovalStatus()))
                .transactionDetailResponses(transactionDetailResponses)
                .createdAt(approvedTransaction.getCreatedAt())
                .updatedAt(approvedTransaction.getUpdatedAt())
                .build();
    }
}
