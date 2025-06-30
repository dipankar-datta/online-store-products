package com.dipankar.onlinestore.products.rest.dto.request;

import com.dipankar.onlinestore.products.data.entities.Product;
import lombok.*;

import static org.springframework.beans.BeanUtils.copyProperties;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    private Long id;
    private String name;
    private String description;
    private String group;
    private String image;

    public Product toEntity() {
        Product product = new Product();
        copyProperties(this, product);
        return product;
    }

}
