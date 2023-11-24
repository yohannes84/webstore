package com.example.pms.data;

import com.example.pms.domain.Customer;
import com.example.pms.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, Long> {

}
