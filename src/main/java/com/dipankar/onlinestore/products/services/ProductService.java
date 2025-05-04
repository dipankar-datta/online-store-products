
package com.dipankar.onlinestore.products.services;

import com.dipankar.onlinestore.products.data.entities.Product;
import com.dipankar.onlinestore.products.data.repositories.ProductRepository;
import com.dipankar.onlinestore.products.rest.dto.request.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    // Create a new product
    public Product save(ProductRequest productRequest) {
        Product product = new Product();
        copyProperties(productRequest, product);
        return productRepository.save(product);
    }

    // Get a product by ID
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Get all products
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    // Delete a product by ID
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
