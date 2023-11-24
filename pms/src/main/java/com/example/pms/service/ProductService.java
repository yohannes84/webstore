package com.example.pms.service;

import com.example.pms.data.ProductRepository;
import com.example.pms.domain.Product;
import com.example.pms.web.ProductDTO;
import com.example.pms.web.ProductMapper;
import com.example.pms.web.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductMapper::getProductDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(long productId) {
        Product product = getProductOrThrow(productId);
        return ProductMapper.getProductDTO(product);
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = ProductMapper.getProduct(productDTO);
        Product createdProduct = productRepository.save(product);
        return ProductMapper.getProductDTO(createdProduct);
    }

    public ProductDTO updateProduct(long productId, ProductDTO productDTO) {
        Product existingProduct = getProductOrThrow(productId);

        existingProduct.setName(productDTO.getName());
        existingProduct.setPrice(productDTO.getPrice());
        existingProduct.setDescription(productDTO.getDescription());
        existingProduct.setNoInStock(productDTO.getNoInStock());

        Product updatedProduct = productRepository.save(existingProduct);
        return ProductMapper.getProductDTO(updatedProduct);
    }

    public void deleteProduct(long productId) {
        Product product = getProductOrThrow(productId);
        productRepository.delete(product);
    }

    private Product getProductOrThrow(long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + productId));
    }
}
