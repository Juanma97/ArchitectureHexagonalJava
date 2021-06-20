package com.juanmaperez.architecturehexagonal.infrastructure.domain;

import lombok.*;

@Getter
@Setter
@Builder
public class Product {
    private int id;
    private ProductData productData;
}
