package com.juanmaperez.architecturehexagonal.api.rest;

import com.juanmaperez.architecturehexagonal.api.converters.ProductConverter;
import com.juanmaperez.architecturehexagonal.api.vo.ProductVO;
import com.juanmaperez.architecturehexagonal.infrastructure.domain.Product;
import com.juanmaperez.architecturehexagonal.infrastructure.ports.primary.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductConverter productConverter;
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductVO> addProduct(@RequestBody final ProductVO productVO) {

        final Product product = productConverter.converToDomain(productVO);

        return ResponseEntity.of(Optional.of(productConverter.convertToVO(productService.addProduct(product))));
    }

    @DeleteMapping("/{idToDelete}")
    public void deleteProduct(@PathVariable final int idToDelete) throws Exception {
        productService.deleteProduct(idToDelete);
    }


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
