package com.enigmacamp.controller;

import com.enigmacamp.constant.ApiPathConstant;
import com.enigmacamp.model.dto.request.customer.CustomerRequest;
import com.enigmacamp.model.dto.response.CommonResponse;
import com.enigmacamp.model.dto.response.customer.CustomerResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ApiPathConstant.DEFAULT)
public interface CustomerOperations {
    @GetMapping(ApiPathConstant.PARAM_ID)
    CommonResponse<CustomerResponse> getCustomerById(@PathVariable String id);

    @GetMapping
    CommonResponse<List<CustomerResponse>> getCustomers();

    @PutMapping
    CommonResponse<CustomerResponse> updateCustomer(@RequestBody CustomerRequest request);

    @DeleteMapping(ApiPathConstant.PARAM_ID)
    CommonResponse<String> deleteCustomer(@PathVariable String id);
}
