package com.dipankar.onlinestore.products.rest.dto.response;

import com.dipankar.onlinestore.products.data.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static org.springframework.beans.BeanUtils.copyProperties;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductResponse {

    private Long id;
    private String name;
    private String description;
    private String group;
    private String image;

    public static ProductResponse toResponse(Product product) {
        ProductResponse response = new ProductResponse();
        copyProperties(product, response);
        return response;
    }
}
