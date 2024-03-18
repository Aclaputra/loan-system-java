package com.enigmacamp.service;

import com.enigmacamp.model.dto.request.loan.transaction.TransactionRequest;
import com.enigmacamp.model.dto.response.loan.transaction.TransactionResponse;

public interface TransactionService extends ApproveTransactionService{
    TransactionResponse create(TransactionRequest request);
    TransactionResponse getById(String id);
}
