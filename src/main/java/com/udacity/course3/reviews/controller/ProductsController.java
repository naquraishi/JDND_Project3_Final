package com.udacity.course3.reviews.controller;

import java.util.List;
import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Spring REST controller for working with product entity.
 */
@RestController
@RequestMapping("/products")
public class ProductsController {

    // TODO: Wire JPA repositories here

    @Autowired
    ProductsRepository productsRepository;

    /**
     * Creates a product.
     *
     * 1. Accept product as argument. Use {@link RequestBody} annotation.
     * 2. Save product.
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@Valid @RequestBody Product product) {
        productsRepository.save(product);
    }

    /**
     * Finds a product by id.
     *
     * @param id The id of the product.
     * @return The product if found, or a 404 not found.
     */
    @RequestMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.of(productsRepository.findById(id));
    }

    /**
     * Lists all products.
     *
     * @return The list of products.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Product> listProducts() {
        return productsRepository.findAll();
    }
}