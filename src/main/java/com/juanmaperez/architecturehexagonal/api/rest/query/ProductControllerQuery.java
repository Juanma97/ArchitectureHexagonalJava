package com.juanmaperez.architecturehexagonal.api.rest.query;

import com.juanmaperez.architecturehexagonal.api.converters.ProductConverter;
import com.juanmaperez.architecturehexagonal.api.vo.ProductVO;
import com.juanmaperez.architecturehexagonal.infrastructure.domain.Product;
import com.juanmaperez.architecturehexagonal.infrastructure.ports.primary.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductControllerQuery {

    private final ProductConverter productConverter;
    private final ProductService productService;

    @GetMapping("/{idToSearch}")
    public ResponseEntity<ProductVO> findProductById(@PathVariable final int idToSearch) {
        return ResponseEntity.of(Optional.of(productConverter.convertToVO(productService.findProductById(idToSearch))));
    }

    @GetMapping()
    public ResponseEntity<List<ProductVO>> getProducts() {
        List<Product> products = productService.getProducts();
        List<ProductVO> productsVO = products.stream().map(product -> productConverter.convertToVO(product)).collect(Collectors.toList());
        return ResponseEntity.of(Optional.of(productsVO));
    }
}
