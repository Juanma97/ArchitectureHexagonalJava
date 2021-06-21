package com.juanmaperez.architecturehexagonal.infrastructure.adapters.secondary;

import com.juanmaperez.architecturehexagonal.infrastructure.domain.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductMySQLDatabaseTest {

    private final ProductMySQLDatabase sut = new ProductMySQLDatabase();

    @Test
    public void shouldAddProductsToDatabase() {
        final Product product = Product.builder().build();

        sut.addProduct(product);

        assertEquals(1, ProductMySQLDatabase.products.size());
    }

    @Test
    public void shouldDeleteProductOfDatabase() {
        final int idToDelete = 1;

        final Product product = Product.builder().id(idToDelete).build();

        sut.addProduct(product);

        sut.deleteProduct(idToDelete);

        assertEquals(0, ProductMySQLDatabase.products.size());
    }
}
