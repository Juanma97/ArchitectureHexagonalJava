package com.juanmaperez.architecturehexagonal.api.vo;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO {
    private int id;
    private String name;
    private double price;
    private String company;
}
