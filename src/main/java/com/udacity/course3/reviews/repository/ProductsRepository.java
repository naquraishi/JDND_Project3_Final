package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Integer> {
}
