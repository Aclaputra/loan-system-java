package com.enigmacamp.service;

import com.enigmacamp.model.dto.request.customer.CustomerRequest;
import com.enigmacamp.model.dto.response.customer.CustomerResponse;
import com.enigmacamp.model.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    CustomerResponse getById(String id);
    List<CustomerResponse> getAll();
    Customer updateOrSave(Customer request);
    String deleteById(String id);
}
