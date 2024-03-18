package com.enigmacamp.service;

import com.enigmacamp.model.dto.request.installment.InstallmentTypeRequest;
import com.enigmacamp.model.dto.request.installment.InstallmentTypeUpdateRequest;
import com.enigmacamp.model.dto.response.installment.InstallmentTypeResponse;

import java.util.List;

public interface InstalmentTypeService {
    InstallmentTypeResponse create(InstallmentTypeRequest request);
    InstallmentTypeResponse getById(String id);
    List<InstallmentTypeResponse> getAll();
    InstallmentTypeResponse update(InstallmentTypeUpdateRequest request);
    String deleteById(String id);
}
