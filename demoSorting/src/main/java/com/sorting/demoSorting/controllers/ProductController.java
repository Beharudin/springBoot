package com.sorting.demoSorting.controllers;

import com.sorting.demoSorting.dto.ProductDto;
import com.sorting.demoSorting.model.Product;
import com.sorting.demoSorting.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping
    private ProductDto<List<Product>> getProducts() {
        List<Product> allProducts = service.findAllProducts();
        return new ProductDto<>(allProducts.size(), allProducts);
    }

    @GetMapping("/{field}")
    private ProductDto<List<Product>> getProductsWithSort(@PathVariable String field) {
        List<Product> allProducts = service.findProductsWithSorting(field);
        return new ProductDto<>(allProducts.size(), allProducts);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    private ProductDto<Page<Product>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<Product> productsWithPagination = service.findProductsWithPagination(offset, pageSize);
        return new ProductDto<>(productsWithPagination.getSize(), productsWithPagination);
    }

    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
    private ProductDto<Page<Product>> getProductsWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String field) {
        Page<Product> productsWithPagination = service.findProductsWithPaginationAndSorting(offset, pageSize, field);
        return new ProductDto<>(productsWithPagination.getSize(), productsWithPagination);
    }
}
