package com.enigmacamp.controller.impl;

import com.enigmacamp.constant.ApiPathConstant;
import com.enigmacamp.constant.LoanStatus;
import com.enigmacamp.constant.MessageConstant;
import com.enigmacamp.controller.LoanTypeOperations;
import com.enigmacamp.model.dto.request.loan.LoanTypeRequest;
import com.enigmacamp.model.dto.request.loan.LoanTypeUpdateRequest;
import com.enigmacamp.model.dto.response.CommonResponse;
import com.enigmacamp.model.dto.response.loan.LoanTypeResponse;
import com.enigmacamp.model.entity.LoanType;
import com.enigmacamp.repository.LoanTypeRepository;
import com.enigmacamp.service.LoanTypeService;
import lombok.RequiredArgsConstructor;
import org.aspectj.bridge.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiPathConstant.LOAN_TYPE)
public class LoanTypeController implements LoanTypeOperations {
    private LoanTypeService loanTypeService;

    @Override
    @PostMapping
    public ResponseEntity<CommonResponse<LoanTypeResponse>> createLoanType(@RequestBody LoanTypeRequest request) {
        LoanTypeResponse loanTypeResponse = loanTypeService.create(request);

        CommonResponse<LoanTypeResponse> response = new CommonResponse<>();
        response.setMessage(MessageConstant.CREATED_SUCCESS);
        response.setData(loanTypeResponse);

        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @Override
    @GetMapping(ApiPathConstant.PARAM_ID)
    public ResponseEntity<CommonResponse<LoanTypeResponse>> getLoanTypeById(@PathVariable String id) {
        LoanTypeResponse loanTypeResponse = loanTypeService.getById(id);

        CommonResponse<LoanTypeResponse> response = new CommonResponse<>();
        response.setMessage(String.format(MessageConstant.GET_BY_ID_SUCCESS, id));
        response.setData(loanTypeResponse);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @Override
    @GetMapping
    public ResponseEntity<CommonResponse<List<LoanTypeResponse>>> getLoanTypes() {
        List<LoanTypeResponse> loanTypeResponses = loanTypeService.getAll();

        CommonResponse<List<LoanTypeResponse>> response = new CommonResponse<>();
        response.setMessage(MessageConstant.LIST_SUCCESS);
        response.setData(loanTypeResponses);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @Override
    @PutMapping
    public ResponseEntity<CommonResponse<LoanTypeResponse>> updateLoanType(@RequestBody LoanTypeUpdateRequest request) {
        LoanTypeResponse loanTypeResponse = loanTypeService.update(request);

        CommonResponse<LoanTypeResponse> response = new CommonResponse<>();
        response.setMessage(String.format(MessageConstant.UPDATE_SUCCESS, loanTypeResponse.getType()));
        response.setData(loanTypeResponse);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @Override
    @DeleteMapping(ApiPathConstant.PARAM_ID)
    public ResponseEntity<CommonResponse<String>> deleteLoanType(String id) {
        String message = loanTypeService.deleteById(id);

        CommonResponse<String> response = new CommonResponse<>();
        response.setMessage(String.format(MessageConstant.DELETE_SUCCESS, id));
        response.setData(message);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
