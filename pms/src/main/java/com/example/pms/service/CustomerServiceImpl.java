package com.example.pms.service;

import com.example.pms.data.CustomerRepository;
import com.example.pms.domain.Customer;
import com.example.pms.domain.CustomerDTO;
import com.example.pms.domain.Product;
import com.example.pms.web.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList.stream()
                .map(customerMapper::getCustomerDTO)
                .collect(Collectors.toList());
    }


    public CustomerDTO getCustomerById(long customerId) {
        Customer customer = getCustomerOrThrow(customerId);
        return customerMapper.getCustomerDTO(customer);
    }

    @Override
    public void addCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.getCustomer(customerDTO);
        customerRepository.save(customer);
    }

    public void deleteCustomer(long customerId) {
        Customer customer = getCustomerOrThrow(customerId);
        customerRepository.delete(customer);
    }

    private Customer getCustomerOrThrow(long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + customerId));
    }
}
