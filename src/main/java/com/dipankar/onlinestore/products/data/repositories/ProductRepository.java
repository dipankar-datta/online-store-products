package com.dipankar.onlinestore.products.data.repositories;

import com.dipankar.onlinestore.products.data.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
