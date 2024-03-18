package com.enigmacamp.controller;

import com.enigmacamp.model.dto.request.loan.transaction.ApproveRequest;
import com.enigmacamp.model.dto.response.CommonResponse;
import com.enigmacamp.model.dto.response.loan.transaction.TransactionResponse;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ApproveTransactionOperations {
    @PutMapping
    CommonResponse<TransactionResponse> approveTransactionRequstByAdminId(@RequestBody ApproveRequest request);

//    @PutMapping
//    CommonResponse<> payInstall
}
