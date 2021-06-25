package com.juanmaperez.architecturehexagonal.api.rest;

import com.juanmaperez.architecturehexagonal.api.converters.ProductConverter;
import com.juanmaperez.architecturehexagonal.api.vo.ProductVO;
import com.juanmaperez.architecturehexagonal.infrastructure.domain.Product;
import com.juanmaperez.architecturehexagonal.infrastructure.ports.primary.ProductService;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ProductControllerTest {

    private final ProductService productService = mock(ProductService.class);
    private final ProductConverter productConverter = mock(ProductConverter.class);

    private final ProductController sut = new ProductController(productConverter, productService);

    @Test
    public void shouldCallServiceToAddProduct() {
        ProductVO productVO = ProductVO.builder().build();
        Product product = Product.builder().build();

        when(productConverter.convertToVO(any())).thenReturn(productVO);
        when(productConverter.converToDomain(productVO)).thenReturn(product);
        sut.addProduct(productVO);

        verify(productService).addProduct(product);
    }

    @Test
    public void shouldCallServiceToDeleteProduct() throws Exception {
        final int idToDelete = 1;

        sut.deleteProduct(idToDelete);

        verify(productService).deleteProduct(idToDelete);
    }

    @Test
    public void shouldCallServiceToFindProduct() {
        ProductVO productVO = ProductVO.builder().build();
        final int idToSearch = 1;

        when(productConverter.convertToVO(any())).thenReturn(productVO);
        sut.findProductById(idToSearch);

        verify(productService).findProductById(idToSearch);
    }

    @Test
    public void shouldCallServiceToListProducts() {
        sut.getProducts();

        verify(productService).getProducts();
    }
}
