package com.example.customer_api.service;

import com.example.customer_api.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer();
    Customer getCustomerById(Long id);
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Long id, Customer newCustomer);
    void deleteCustomer(Long id);
}
