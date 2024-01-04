package com.example.customer_api.service.impl;

import com.example.customer_api.entity.Customer;
import com.example.customer_api.repository.CustomerRepository;
import com.example.customer_api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Customer not found with id: "+id));
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer newCustomer) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setName(newCustomer.getName());
                    customer.setAge(newCustomer.getAge());
                    customer.setAddress(newCustomer.getAddress());
                    return customerRepository.save(customer);
                })
                .orElseThrow(()->new RuntimeException("Customer not found with id: "+id));
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
