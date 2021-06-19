package com.juanmaperez.architecturehexagonal.api.rest;

import com.juanmaperez.architecturehexagonal.api.converters.ProductConverter;
import com.juanmaperez.architecturehexagonal.api.vo.ProductVO;
import com.juanmaperez.architecturehexagonal.infrastructure.ports.primary.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductConverter productConverter;
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductVO> addProduct(@RequestParam final ProductVO productVO) {

        return ResponseEntity.of(Optional.of(productConverter.convertToVO(productService.addProduct(productVO))));
    }
}
