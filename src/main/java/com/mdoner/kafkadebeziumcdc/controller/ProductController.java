package com.mdoner.kafkadebeziumcdc.controller;


import com.mdoner.kafkadebeziumcdc.model.Product;
import com.mdoner.kafkadebeziumcdc.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(Product product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @PutMapping("updateProduct/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId,
                                                 @RequestBody Product update) {
        return new ResponseEntity<>(productService.updateProduct(productId,update),HttpStatus.OK);

    }

}
