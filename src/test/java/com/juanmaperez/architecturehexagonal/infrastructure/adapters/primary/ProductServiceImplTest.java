package com.juanmaperez.architecturehexagonal.infrastructure.adapters.primary;

import com.juanmaperez.architecturehexagonal.api.vo.ProductVO;
import com.juanmaperez.architecturehexagonal.infrastructure.domain.Product;
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
        Product product = Product.builder().build();
        sut.addProduct(product);

        verify(productRepository).addProduct(product);
    }
}