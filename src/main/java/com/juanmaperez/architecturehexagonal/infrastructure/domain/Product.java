package com.juanmaperez.architecturehexagonal.infrastructure.domain;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    private ProductData productData;
}
