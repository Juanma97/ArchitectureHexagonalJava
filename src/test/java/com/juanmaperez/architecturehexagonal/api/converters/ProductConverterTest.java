package com.juanmaperez.architecturehexagonal.api.converters;

import com.juanmaperez.architecturehexagonal.api.vo.ProductVO;
import com.juanmaperez.architecturehexagonal.infrastructure.domain.Product;
import com.juanmaperez.architecturehexagonal.infrastructure.domain.ProductData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductConverterTest {

    private final ProductConverter sut = new ProductConverter();

    @Test
    public void shouldConvertProductToProductVO() {
        final ProductData productData = ProductData.builder()
                .price(20.0)
                .company("Company")
                .name("Name")
                .build();
        final Product product = Product.builder().id(1).productData(productData).build();
        final ProductVO productVO = ProductVO.builder()
                .id(1)
                .name("Name")
                .company("Company")
                .price(20.0)
                .build();

        final ProductVO productVOConverted = sut.convertToVO(product);

        assertAll(() -> {
            assertEquals(productVO.getId(), productVOConverted.getId());
            assertEquals(productVO.getCompany(), productVOConverted.getCompany());
            assertEquals(productVO.getName(), productVOConverted.getName());
            assertEquals(productVO.getPrice(), productVOConverted.getPrice());
        });
    }

}