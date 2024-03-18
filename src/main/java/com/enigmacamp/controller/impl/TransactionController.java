package com.enigmacamp.controller.impl;

import com.enigmacamp.constant.ApiPathConstant;
import com.enigmacamp.controller.TransactionOperations;
import com.enigmacamp.model.dto.request.loan.transaction.ApproveRequest;
import com.enigmacamp.model.dto.request.loan.transaction.TransactionRequest;
import com.enigmacamp.model.dto.response.CommonResponse;
import com.enigmacamp.model.dto.response.loan.transaction.TransactionResponse;
import com.enigmacamp.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiPathConstant.TRANSACTION)
public class TransactionController implements TransactionOperations {
    private TransactionService transactionService;

    @Override
    @PostMapping
    public ResponseEntity<CommonResponse<TransactionResponse>> requestLoan(@RequestBody TransactionRequest request) {
        return null;
    }

    @Override
    @GetMapping(ApiPathConstant.PARAM_ID)
    public ResponseEntity<CommonResponse<TransactionResponse>> getLoanTransactionById(@PathVariable String id) {
        return null;
    }

    @Override
    @PutMapping
    public CommonResponse<TransactionResponse> approveTransactionRequstByAdminId(@RequestBody ApproveRequest request) {
        return null;
    }
}
