
package com.dipankar.onlinestore.products.rest.controllers;

import com.dipankar.onlinestore.products.data.entities.Product;
import com.dipankar.onlinestore.products.rest.dto.request.ProductRequest;
import com.dipankar.onlinestore.products.rest.dto.response.ProductResponse;
import com.dipankar.onlinestore.products.services.ProductService;
import com.dipankar.onlinestore.products.util.exception.NoDataFoudException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.dipankar.onlinestore.products.util.CommonUtil.handleOptional;

@Slf4j
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // Create a new product
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        Product createdProduct = productService.save(productRequest.toEntity());
        log.info("Product created successfully: {}", createdProduct.getId());
        return ProductResponse.toResponse(createdProduct);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    ProductResponse updateProduct(@RequestBody ProductRequest productRequest) {
        Product createdProduct = productService.save(productRequest.toEntity());
        log.info("Product updated successfully: {}", createdProduct.getId());
        return ProductResponse.toResponse(createdProduct);
    }

    // Get a product by ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ProductResponse getProductById(@PathVariable Long id) throws NoDataFoudException {
        Optional<Product> productOpt = productService.getProductById(id);
        return ProductResponse.toResponse(handleOptional(productOpt));
    }

    // Get all products
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<ProductResponse> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        log.info("Getting all products");
        return products.stream().map(ProductResponse::toResponse).toList();
    }


    // Delete a product by ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteProduct(@PathVariable Long id) throws NoDataFoudException {
        Optional<Product> productOpt = productService.getProductById(id);
        handleOptional(productOpt);
        productService.deleteProduct(id);
    }
}
