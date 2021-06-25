package com.juanmaperez.architecturehexagonal.infrastructure.adapters.secondary;

import com.juanmaperez.architecturehexagonal.infrastructure.domain.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    public void shouldFindProductById() {
        final int idToSearch = 1;

        final Product product = Product.builder().id(idToSearch).build();

        sut.addProduct(product);

        Product productSearched = sut.findProductById(idToSearch);

        assertEquals(idToSearch, productSearched.getId());

    }

    @Test
    public void shouldReturnAllProducts() {
        final Product product1 = Product.builder().id(1).build();
        final Product product2 = Product.builder().id(2).build();
        final Product product3 = Product.builder().id(3).build();
        final Product product4 = Product.builder().id(4).build();

        sut.addProduct(product1);
        sut.addProduct(product2);
        sut.addProduct(product3);
        sut.addProduct(product4);

        List<Product> products = sut.getProducts();

        assertEquals(4, products.size());

        int idExpected = 1;

        for(Product product : products) {
            assertEquals(idExpected, product.getId());
            idExpected++;
        }
    }
}
