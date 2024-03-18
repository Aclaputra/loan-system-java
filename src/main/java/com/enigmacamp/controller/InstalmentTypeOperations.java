package com.enigmacamp.controller;

import com.enigmacamp.constant.ApiPathConstant;
import com.enigmacamp.model.dto.request.installment.InstallmentTypeRequest;
import com.enigmacamp.model.dto.request.installment.InstallmentTypeUpdateRequest;
import com.enigmacamp.model.dto.response.CommonResponse;
import com.enigmacamp.model.dto.response.installment.InstallmentTypeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ApiPathConstant.DEFAULT)
public interface InstalmentTypeOperations {
    @PostMapping
    ResponseEntity<CommonResponse<InstallmentTypeResponse>> createInstallmentType(@RequestBody InstallmentTypeRequest request);

    @GetMapping(ApiPathConstant.PARAM_ID)
    ResponseEntity<CommonResponse<InstallmentTypeResponse>> getInstallmentTypeById(@PathVariable  String id);

    @GetMapping
    ResponseEntity<CommonResponse<List<InstallmentTypeResponse>>> getInstallmentTypes();

    @PutMapping
    ResponseEntity<CommonResponse<InstallmentTypeResponse>> updateInstallmentType(@RequestBody InstallmentTypeUpdateRequest request);

    @DeleteMapping(ApiPathConstant.PARAM_ID)
    ResponseEntity<CommonResponse<String>> deleteInstallmentType(@PathVariable String id);
}
