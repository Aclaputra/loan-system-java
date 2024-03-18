package com.enigmacamp.controller.impl;

import com.enigmacamp.constant.ApiPathConstant;
import com.enigmacamp.constant.MessageConstant;
import com.enigmacamp.controller.InstalmentTypeOperations;
import com.enigmacamp.model.dto.request.installment.InstallmentTypeRequest;
import com.enigmacamp.model.dto.request.installment.InstallmentTypeUpdateRequest;
import com.enigmacamp.model.dto.response.CommonResponse;
import com.enigmacamp.model.dto.response.installment.InstallmentTypeResponse;
import com.enigmacamp.service.InstalmentTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiPathConstant.INSTALLMENT_TYPE)
public class InstallmentTypeController implements InstalmentTypeOperations {

    private final InstalmentTypeService instalmentTypeService;

    @Override
    public ResponseEntity<CommonResponse<InstallmentTypeResponse>> createInstallmentType(InstallmentTypeRequest request) {
        InstallmentTypeResponse instalmentType = instalmentTypeService.create(request);

        CommonResponse<InstallmentTypeResponse> response = new CommonResponse<>();
        response.setMessage(MessageConstant.LIST_SUCCESS);
        response.setData(instalmentType);

        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @Override
    public ResponseEntity<CommonResponse<InstallmentTypeResponse>> getInstallmentTypeById(String id) {
        InstallmentTypeResponse installmentType = instalmentTypeService.getById(id);

        CommonResponse<InstallmentTypeResponse> response = new CommonResponse<>();
        response.setMessage(MessageConstant.GET_BY_ID_SUCCESS);
        response.setData(installmentType);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @Override
    public ResponseEntity<CommonResponse<List<InstallmentTypeResponse>>> getInstallmentTypes() {
        List<InstallmentTypeResponse> installmentTypeResponses = instalmentTypeService.getAll();

        CommonResponse<List<InstallmentTypeResponse>> response = new CommonResponse<>();
        response.setMessage(MessageConstant.LIST_SUCCESS);
        response.setData(installmentTypeResponses);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @Override
    public ResponseEntity<CommonResponse<InstallmentTypeResponse>> updateInstallmentType(InstallmentTypeUpdateRequest request) {
        InstallmentTypeResponse installmentTypeResponse = instalmentTypeService.update(request);

        CommonResponse<InstallmentTypeResponse> response = new CommonResponse<>();
        response.setMessage(MessageConstant.UPDATE_SUCCESS);
        response.setData(installmentTypeResponse);

        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @Override
    public ResponseEntity<CommonResponse<String>> deleteInstallmentType(String id) {

        String message = instalmentTypeService.deleteById(id);

        CommonResponse<String> response = new CommonResponse<>();
        response.setMessage(message);
        response.setData(id);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
