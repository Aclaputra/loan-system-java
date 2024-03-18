package com.enigmacamp.controller;

import com.enigmacamp.constant.ApiPathConstant;
import com.enigmacamp.model.dto.request.loan.LoanTypeRequest;
import com.enigmacamp.model.dto.request.loan.LoanTypeUpdateRequest;
import com.enigmacamp.model.dto.response.CommonResponse;
import com.enigmacamp.model.dto.response.loan.LoanTypeResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ApiPathConstant.DEFAULT)
public interface LoanTypeOperations {
    @PostMapping
    CommonResponse<LoanTypeResponse> createLoanType(@RequestBody LoanTypeRequest request);

    @GetMapping(ApiPathConstant.PARAM_ID)
    CommonResponse<LoanTypeResponse> getLoanTypeById(@PathVariable String id);

    @GetMapping
    CommonResponse<List<LoanTypeResponse>> getLoanTypes();

    @PutMapping
    CommonResponse<LoanTypeResponse> updateLoanType(@RequestBody LoanTypeUpdateRequest request);

    @DeleteMapping(ApiPathConstant.PARAM_ID)
    CommonResponse<String> deleteLoanType(@PathVariable String id);
}
