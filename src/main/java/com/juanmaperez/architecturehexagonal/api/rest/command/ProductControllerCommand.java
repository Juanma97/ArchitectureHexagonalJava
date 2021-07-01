package com.juanmaperez.architecturehexagonal.api.rest.command;

import com.juanmaperez.architecturehexagonal.api.converters.ProductConverter;
import com.juanmaperez.architecturehexagonal.api.vo.ProductVO;
import com.juanmaperez.architecturehexagonal.infrastructure.domain.Product;
import com.juanmaperez.architecturehexagonal.infrastructure.ports.primary.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductControllerCommand {

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
}
