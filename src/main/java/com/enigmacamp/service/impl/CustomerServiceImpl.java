package com.enigmacamp.service.impl;

import com.enigmacamp.constant.MessageConstant;
import com.enigmacamp.model.dto.request.customer.CustomerRequest;
import com.enigmacamp.model.dto.response.customer.CustomerResponse;
import com.enigmacamp.model.entity.Customer;
import com.enigmacamp.repository.CustomerRepository;
import com.enigmacamp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerResponse getById(String id) {
        Customer customer = customerRepository.findById(id).get();

        return CustomerResponse.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .phone(customer.getPhone())
                .dateOfBirth(String.valueOf(customer.getDateOfBirth()))
                .build();
    }

    @Override
    public List<CustomerResponse> getAll() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponse> customerResponses = new ArrayList<>();

        customers.forEach(customer -> {
            CustomerResponse customerResponse = CustomerResponse.builder()
                    .firstName(customer.getFirstName())
                    .lastName(customer.getLastName())
                    .phone(customer.getPhone())
                    .dateOfBirth(String.valueOf(customer.getDateOfBirth()))
                    .build();
            customerResponses.add(customerResponse);
        });

        return customerResponses;
    }

    @Override
    public Customer update(CustomerRequest request) throws RuntimeException {
        if (customerRepository.findById(request.getId()).isPresent()) {
            Customer customer = Customer.builder()
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .phone(request.getPhone())
                    .dateOfBirth(Date.valueOf(request.getDateOfBirth()))
                    .build();

            return customerRepository.save(customer);
        } else {
            throw new RuntimeException("Customer with id " + request.getId() + " not found");
        }
    }

    @Override
    public String deleteById(String id) throws RuntimeException {
        try {
            customerRepository.deleteById(id);
            return String.format(MessageConstant.DELETE_SUCCESS, id);
        } catch (Exception e) {
            throw new RuntimeException(
                    String.format(MessageConstant.DELETE_FAIL, id) +
                            " | with error: " + e.getMessage());
        }
    }
}
