package com.enigmacamp.service;

import com.enigmacamp.model.dto.request.loan.LoanTypeRequest;
import com.enigmacamp.model.dto.request.loan.LoanTypeUpdateRequest;
import com.enigmacamp.model.dto.response.loan.LoanTypeResponse;

import java.util.List;

public interface LoanTypeService {
    LoanTypeResponse create(LoanTypeRequest request);
    LoanTypeResponse getById(String id);
    List<LoanTypeResponse> getAll();
    LoanTypeResponse update(LoanTypeUpdateRequest request);
    String deleteById(String id);
}
