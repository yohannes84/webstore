package com.example.pms.web;

import com.example.pms.domain.Customer;
import com.example.pms.domain.CustomerDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer getCustomer(CustomerDTO customerDTO){
        return Customer.builder()
                .customerId(customerDTO.getCustomerId())
                .name(customerDTO.getName())
                .email(customerDTO.getEmail())
                .street(customerDTO.getStreet())
                .city(customerDTO.getCity())
                .phone(customerDTO.getPhone())
                .zip(customerDTO.getZip()).build();

    }


    public CustomerDTO getCustomerDTO(Customer customer){
        return CustomerDTO.builder()
                .customerId(customer.getCustomerId())
                .name(customer.getName())
                .email(customer.getEmail())
                .street(customer.getStreet())
                .city(customer.getCity())
                .phone(customer.getPhone())
                .zip(customer.getZip()).build();

    }
}
