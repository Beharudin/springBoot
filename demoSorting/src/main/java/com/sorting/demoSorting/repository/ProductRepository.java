package com.sorting.demoSorting.repository;

import com.sorting.demoSorting.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
