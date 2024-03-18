package com.enigmacamp.service;

import com.enigmacamp.model.dto.request.customer.CustomerRequest;
import com.enigmacamp.model.dto.response.customer.CustomerResponse;
import com.enigmacamp.model.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    CustomerResponse getCustomerById(String id);
    List<CustomerResponse> getCustomers();
    Customer update(CustomerRequest request);
    String deleteById(String id);
}
