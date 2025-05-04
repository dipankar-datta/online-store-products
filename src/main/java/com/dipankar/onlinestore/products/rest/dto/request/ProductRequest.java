package com.dipankar.onlinestore.products.rest.dto.request;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {

    private Long id;
    private String name;
    private String description;
    private String group;
    private String image;
}
