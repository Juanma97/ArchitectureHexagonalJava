package com.juanmaperez.architecturehexagonal.api.rest;

import com.juanmaperez.architecturehexagonal.api.converters.ProductConverter;
import com.juanmaperez.architecturehexagonal.api.vo.ProductVO;
import com.juanmaperez.architecturehexagonal.infrastructure.ports.primary.ProductService;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductControllerTest {

    private final ProductService productService = mock(ProductService.class);
    private final ProductConverter productConverter = mock(ProductConverter.class);

    private final ProductController sut = new ProductController(productConverter, productService);

    @Test
    public void shouldCallServiceToAddProduct() {
        ProductVO productVO = ProductVO.builder().build();

        when(productConverter.convertToVO(any())).thenReturn(productVO);
        sut.addProduct(productVO);
    }
}
