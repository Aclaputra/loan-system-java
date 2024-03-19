package com.enigmacamp.controller.impl;

import com.enigmacamp.constant.ApiPathConstant;
import com.enigmacamp.constant.MessageConstant;
import com.enigmacamp.controller.CustomerOperations;
import com.enigmacamp.model.dto.request.customer.CustomerRequest;
import com.enigmacamp.model.dto.response.CommonResponse;
import com.enigmacamp.model.dto.response.customer.CustomerResponse;
import com.enigmacamp.model.entity.Customer;
import com.enigmacamp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiPathConstant.CUSTOMER)
public class CustomerController implements CustomerOperations {

    private final CustomerService customerService;

    @Override
    @GetMapping(ApiPathConstant.PARAM_ID)
    public ResponseEntity<CommonResponse<CustomerResponse>> getCustomerById(@PathVariable  String id) {
        CustomerResponse customer = customerService.getById(id);

        CommonResponse<CustomerResponse> response = new CommonResponse<>();
        response.setMessage(String.format(MessageConstant.GET_BY_ID_SUCCESS, id));
        response.setData(customer);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @Override
    @GetMapping
    public ResponseEntity<CommonResponse<List<CustomerResponse>>> getCustomers() {
        List<CustomerResponse> customers = customerService.getAll();

        CommonResponse<List<CustomerResponse>> response = new CommonResponse<>();
        response.setMessage(MessageConstant.LIST_SUCCESS);
        response.setData(customers);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @Override
    @PutMapping
    public ResponseEntity<CommonResponse<CustomerResponse>> updateCustomer(@RequestBody CustomerRequest request) {
        String message = String.format(MessageConstant.UPDATE_SUCCESS, request.getFirstName());

        Customer updateCustomer = customerService.updateOrSave(request);
        CustomerResponse customerResponse = CustomerResponse.builder()
                .id(updateCustomer.getId())
                .firstName(updateCustomer.getFirstName())
                .lastName(updateCustomer.getLastName())
                .phone(updateCustomer.getPhone())
                .dateOfBirth(String.valueOf(updateCustomer.getDateOfBirth()))
                .build();

        CommonResponse<CustomerResponse> response = new CommonResponse<>();
        response.setMessage(MessageConstant.UPDATE_SUCCESS);
        response.setData(customerResponse);

        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @Override
    @DeleteMapping(ApiPathConstant.PARAM_ID)
    public ResponseEntity<CommonResponse<String>> deleteCustomer(String id) {
        String message = customerService.deleteById(id);

        CommonResponse<String> response = new CommonResponse<>();
        response.setMessage(message);
        response.setData(id);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
