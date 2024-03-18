package com.enigmacamp.controller;

import com.enigmacamp.constant.ApiPathConstant;
import com.enigmacamp.model.dto.request.loan.transaction.TransactionRequest;
import com.enigmacamp.model.dto.response.CommonResponse;
import com.enigmacamp.model.dto.response.loan.transaction.TransactionResponse;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathConstant.DEFAULT)
public interface TransactionOperations {
    @PostMapping
    CommonResponse<TransactionResponse> requestLoan(@RequestBody TransactionRequest request);

    @GetMapping(ApiPathConstant.PARAM_ID)
    CommonResponse<TransactionResponse> getLoanTransactionById(@PathVariable String id);
}
