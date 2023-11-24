package com.example.pms;

import com.example.pms.data.ProductRepository;
import com.example.pms.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class PmsApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(PmsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product product1 =
				new Product(85465, "IPhone", 120.5, "IPhone I7 Newest Gen",
						20, new ArrayList<>() );

		Product product2 =
				new Product(52532536, "Samsung", 180.5, "S6 Gu Model ",
						30, new ArrayList<>() );

		Product product3 =
				new Product(4596553, "Nokia", 50.7, "N Latest release",
						10, new ArrayList<>() );

		repository.save(product1);
		repository.save(product2);
		repository.save(product3);

	}
}
