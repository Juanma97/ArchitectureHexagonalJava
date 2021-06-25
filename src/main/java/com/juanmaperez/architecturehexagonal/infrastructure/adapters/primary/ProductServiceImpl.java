package com.juanmaperez.architecturehexagonal.infrastructure.adapters.primary;

import com.juanmaperez.architecturehexagonal.api.vo.ProductVO;
import com.juanmaperez.architecturehexagonal.infrastructure.domain.Product;
import com.juanmaperez.architecturehexagonal.infrastructure.ports.primary.ProductService;
import com.juanmaperez.architecturehexagonal.infrastructure.ports.secondary.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.addProduct(product);
    }

    @Override
    public void deleteProduct(int idToDelete) throws Exception {
        if (idToDelete < 0) {
            throw new Exception("Id not valid");
        }

        productRepository.deleteProduct(idToDelete);
    }

    @Override
    public Product findProductById(int idToSearch) {
        return productRepository.findProductById(idToSearch);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.getProducts();
    }
}
