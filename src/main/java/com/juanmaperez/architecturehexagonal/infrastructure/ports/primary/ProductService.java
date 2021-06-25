package com.juanmaperez.architecturehexagonal.infrastructure.ports.primary;

import com.juanmaperez.architecturehexagonal.infrastructure.domain.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(final Product productVO);

    void deleteProduct(final int idToDelete) throws Exception;

    Product findProductById(final int idToSearch);

    List<Product> getProducts();
}
