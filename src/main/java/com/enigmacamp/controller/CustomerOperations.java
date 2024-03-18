package com.enigmacamp.controller;

import com.enigmacamp.constant.ApiPathConstant;
import com.enigmacamp.model.dto.request.customer.CustomerRequest;
import com.enigmacamp.model.dto.response.CommonResponse;
import com.enigmacamp.model.dto.response.customer.CustomerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ApiPathConstant.DEFAULT)
public interface CustomerOperations {
    @GetMapping(ApiPathConstant.PARAM_ID)
    ResponseEntity<CommonResponse<CustomerResponse>> getCustomerById(@PathVariable String id);

    @GetMapping
    ResponseEntity<CommonResponse<List<CustomerResponse>>> getCustomers();

    @PutMapping
    ResponseEntity<CommonResponse<CustomerResponse>> updateCustomer(@RequestBody CustomerRequest request);

    @DeleteMapping(ApiPathConstant.PARAM_ID)
    ResponseEntity<CommonResponse<String>> deleteCustomer(@PathVariable String id);


}
