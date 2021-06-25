package com.juanmaperez.architecturehexagonal.infrastructure.ports.secondary;

import com.juanmaperez.architecturehexagonal.infrastructure.domain.Product;

import java.util.List;

public interface ProductRepository {
    Product addProduct(final Product product);

    void deleteProduct(final int idToDelete);

    Product findProductById(final int idToSearch);

    List<Product> getProducts();
}
