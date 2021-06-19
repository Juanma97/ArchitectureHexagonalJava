package com.juanmaperez.architecturehexagonal.api.converters;

import com.juanmaperez.architecturehexagonal.api.vo.ProductVO;
import com.juanmaperez.architecturehexagonal.infrastructure.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public ProductVO convertToVO(Product product) {
        return ProductVO.builder()
                .price(product.getProductData().getPrice())
                .company(product.getProductData().getCompany())
                .name(product.getProductData().getName())
                .id(product.getId())
                .build();
    }
}
