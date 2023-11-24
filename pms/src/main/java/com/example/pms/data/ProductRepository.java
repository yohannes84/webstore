package com.example.pms.data;

import com.example.pms.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {
    Product findByProductNumber(String productNumber);
    List<Product> findAll();
    void deleteByProductNumber(String productNumber);
}
