package com.example.pms.service;

import com.example.pms.domain.CustomerDTO;

import java.util.List;

public interface CustomerService {

        List<CustomerDTO> getAllCustomers();
        void addCustomer(CustomerDTO customerDTO);
        CustomerDTO getCustomerById(long customerId);
        void deleteCustomer (long customerId);

}
