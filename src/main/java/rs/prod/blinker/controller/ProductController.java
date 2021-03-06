package rs.prod.blinker.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.prod.blinker.entity.Product;
import rs.prod.blinker.service.ProductService;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    @ApiOperation(value = "", nickname = "getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required = false) String code) {
        if (code != null) return ResponseEntity.ok(Collections.singletonList(productService.findByCode(code)));
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{productId}")
    @ApiOperation(value = "", nickname = "getProductById")
    public ResponseEntity<Product> getProductById(@PathVariable Integer productId) {
        return ResponseEntity.ok(productService.findById(productId));
    }


    @PostMapping
    @ApiOperation(value = "", nickname = "saveProduct")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

    @PutMapping
    @ApiOperation(value = "", nickname = "updateProduct")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.update(product));
    }

    @DeleteMapping("/{productId}")
    @ApiOperation(value = "", nickname = "deleteProductById")
    public void deleteProductById(@PathVariable Integer productId) {
        productService.deleteById(productId);
    }

    @GetMapping("/code")
    @ApiOperation(value = "", nickname = "findByCode")
    public ResponseEntity<Product> findProductByCode(@RequestParam String code) {
        return ResponseEntity.ok(productService.findByCode(code));
    }

}

