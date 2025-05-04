
package com.dipankar.onlinestore.products.rest.controllers;

import com.dipankar.onlinestore.products.data.entities.Product;
import com.dipankar.onlinestore.products.rest.dto.request.ProductRequest;
import com.dipankar.onlinestore.products.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // Create a new product
    @PostMapping
    ResponseEntity<Product> createProduct(@RequestBody ProductRequest productRequest) {
        Product createdProduct = productService.save(productRequest);
        return ResponseEntity.ok(createdProduct);
    }

    // Get a product by ID
    @GetMapping("/{id}")
    ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> productOpt = productService.getProductById(id);
        return productOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all products
    @GetMapping
    ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // Update a product by ID
    @PutMapping("/{id}")
    ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        Product createdProduct = productService.save(productRequest);
        return ResponseEntity.ok(createdProduct);
    }

    // Delete a product by ID
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Optional<Product> productOpt = productService.getProductById(id);
        if (productOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
