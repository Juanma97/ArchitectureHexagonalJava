package com.juanmaperez.architecturehexagonal.infrastructure.adapters.primary;

import com.juanmaperez.architecturehexagonal.api.vo.ProductVO;
import com.juanmaperez.architecturehexagonal.infrastructure.ports.primary.ProductService;
import com.juanmaperez.architecturehexagonal.infrastructure.ports.secondary.ProductRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ProductServiceImplTest {

    private final ProductRepository productRepository = mock(ProductRepository.class);
    private final ProductService sut = new ProductServiceImpl(productRepository);

    @Test
    public void shouldCallRepositoryToSaveProduct() {
        ProductVO productVO = ProductVO.builder().build();
        sut.addProduct(productVO);

        verify(productRepository).addProduct(productVO);
    }
}