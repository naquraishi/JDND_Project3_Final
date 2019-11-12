package com.udacity.course3.reviews.repository;

import java.util.List;
import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsRepository extends JpaRepository<Review, Integer> {
    List<Review> findAllByProduct(Product product);
}
