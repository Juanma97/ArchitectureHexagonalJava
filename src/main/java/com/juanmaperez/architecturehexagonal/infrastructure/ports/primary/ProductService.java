package com.juanmaperez.architecturehexagonal.infrastructure.ports.primary;

import com.juanmaperez.architecturehexagonal.api.vo.ProductVO;
import com.juanmaperez.architecturehexagonal.infrastructure.domain.Product;

public interface ProductService {
    Product addProduct(final Product productVO);

    void deleteProduct(final int idToDelete) throws Exception;
}
