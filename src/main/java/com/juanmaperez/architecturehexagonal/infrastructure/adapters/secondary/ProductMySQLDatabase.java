package com.juanmaperez.architecturehexagonal.infrastructure.adapters.secondary;

import com.juanmaperez.architecturehexagonal.api.vo.ProductVO;
import com.juanmaperez.architecturehexagonal.infrastructure.domain.Product;
import com.juanmaperez.architecturehexagonal.infrastructure.ports.secondary.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductMySQLDatabase implements ProductRepository {

    public static List<Product> products = new ArrayList<>();

    @Override
    public Product addProduct(Product product) {
        if (products.add(product)) {
            return product;
        }
        return null;
    }

    @Override
    public void deleteProduct(int idToDelete) {
        products = products.stream()
                .filter(product -> product.getId() !=  idToDelete)
                .collect(Collectors.toList());
    }
}
