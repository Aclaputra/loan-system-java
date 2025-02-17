package com.enigmacamp.service.impl;

import com.enigmacamp.constant.MessageConstant;
import com.enigmacamp.model.dto.request.customer.CustomerRequest;
import com.enigmacamp.model.dto.response.customer.CustomerResponse;
import com.enigmacamp.model.entity.Customer;
import com.enigmacamp.model.entity.User;
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
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .phone(customer.getPhone())
                .dateOfBirth(String.valueOf(customer.getDateOfBirth()))
                .status(customer.getStatus().toString())
                .build();
    }

    @Override
    public List<CustomerResponse> getAll() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponse> customerResponses = new ArrayList<>();

        customers.forEach(customer -> {
            CustomerResponse customerResponse = CustomerResponse.builder()
                    .id(customer.getId())
                    .firstName(customer.getFirstName())
                    .lastName(customer.getLastName())
                    .phone(customer.getPhone())
                    .dateOfBirth(String.valueOf(customer.getDateOfBirth()))
                    .status(customer.getStatus().toString())
                    .build();
            customerResponses.add(customerResponse);
        });

        return customerResponses;
    }

    @Override
    public Customer update(CustomerRequest request) throws RuntimeException {
        if (customerRepository.findById(request.getId()).isPresent()) {
            Customer customer = Customer.builder()
                    .id(request.getId())
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .phone(request.getPhone())
                    .dateOfBirth(Date.valueOf(request.getDateOfBirth()))
                    .status(Boolean.valueOf(request.getStatus()))
                    .build();

            return customerRepository.save(customer);
        } else {
            throw new RuntimeException("Customer with id " + request.getId() + " not found");
        }
    }

    @Override
    public Customer save(CustomerRequest request, User user) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .status(Boolean.valueOf(request.getStatus()))
                .phone(request.getPhone())
                .user(user)
                .build();

        return customerRepository.save(customer);
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
