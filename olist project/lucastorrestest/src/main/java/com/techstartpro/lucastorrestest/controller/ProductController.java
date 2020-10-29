package com.techstartpro.lucastorrestest.controller;

import com.techstartpro.lucastorrestest.model.Product;
import com.techstartpro.lucastorrestest.repository.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Api(value = "Api rest products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    @ApiOperation(value = "Return all products")
    public List<Product> productList() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    @ApiOperation(value = "Return product by id")
    public Optional<Product> findById(@PathVariable("id") long id) {
        return productRepository.findById(id);
    }

    @GetMapping("/products/filter")
    @ApiOperation(value = "Return product by id")
    public List<Product> filterProduct(@Param("name") String name, @Param("description") String description, @Param("price") BigDecimal price) {
        return productRepository.filterProduct(name, description, price);
    }

    @PostMapping("/products/product")
    @ApiOperation(value = "Save product")
    public Product saveProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/products/product")
    @ApiOperation(value = "update product")
    public void updateProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

    @DeleteMapping("/products/product/{id}")
    @ApiOperation(value = "Delete product")
    public void deleteProductById(@PathVariable("id") long id) {
        productRepository.deleteById(id);
    }

}
