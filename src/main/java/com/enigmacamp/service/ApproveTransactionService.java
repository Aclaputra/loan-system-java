package com.enigmacamp.service;

import com.enigmacamp.model.dto.request.loan.transaction.ApproveRequest;
import com.enigmacamp.model.dto.response.loan.transaction.TransactionResponse;

public interface ApproveTransactionService {
    TransactionResponse approve(ApproveRequest request);
}
