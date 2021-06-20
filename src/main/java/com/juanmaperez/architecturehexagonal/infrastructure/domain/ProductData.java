package com.juanmaperez.architecturehexagonal.infrastructure.domain;

import lombok.*;

@Getter
@Setter
@Builder
public class ProductData {
    private String name;
    private double price;
    private String company;
}
