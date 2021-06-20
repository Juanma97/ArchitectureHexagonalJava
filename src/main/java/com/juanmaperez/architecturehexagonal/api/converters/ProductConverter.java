package com.juanmaperez.architecturehexagonal.api.converters;

import com.juanmaperez.architecturehexagonal.api.vo.ProductVO;
import com.juanmaperez.architecturehexagonal.infrastructure.domain.Product;
import com.juanmaperez.architecturehexagonal.infrastructure.domain.ProductData;
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

    public Product converToDomain(ProductVO productVO) {
        final ProductData productData = ProductData.builder()
                .name(productVO.getName())
                .price(productVO.getPrice())
                .company(productVO.getCompany())
                .build();

        return Product.builder()
                .id(productVO.getId())
                .productData(productData)
                .build();
    }
}
