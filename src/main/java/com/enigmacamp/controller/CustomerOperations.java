package com.enigmacamp.controller;

import com.enigmacamp.constant.ApiPathConstant;
import com.enigmacamp.model.dto.response.CommonResponse;
import com.enigmacamp.model.dto.response.customer.CustomerResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(ApiPathConstant.DEFAULT)
public interface CustomerOperations {
    @GetMapping(ApiPathConstant.PARAM_ID)
    CommonResponse<CustomerResponse> getCustomerById(@PathVariable String id);
}
