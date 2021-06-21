package com.juanmaperez.architecturehexagonal.infrastructure.ports.secondary;

import com.juanmaperez.architecturehexagonal.api.vo.ProductVO;
import com.juanmaperez.architecturehexagonal.infrastructure.domain.Product;
import org.springframework.http.ResponseEntity;

public interface ProductRepository {
    Product addProduct(final Product product);

    void deleteProduct(final int idToDelete);
}
