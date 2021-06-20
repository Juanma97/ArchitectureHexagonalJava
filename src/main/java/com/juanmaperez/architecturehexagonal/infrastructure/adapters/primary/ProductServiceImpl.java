package com.juanmaperez.architecturehexagonal.infrastructure.adapters.primary;

import com.juanmaperez.architecturehexagonal.api.vo.ProductVO;
import com.juanmaperez.architecturehexagonal.infrastructure.domain.Product;
import com.juanmaperez.architecturehexagonal.infrastructure.ports.primary.ProductService;
import com.juanmaperez.architecturehexagonal.infrastructure.ports.secondary.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.addProduct(product);
    }
}
