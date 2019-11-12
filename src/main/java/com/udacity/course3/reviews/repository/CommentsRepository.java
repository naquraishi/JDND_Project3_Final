package com.udacity.course3.reviews.repository;

import java.util.List;
import com.udacity.course3.reviews.model.Comment;
import com.udacity.course3.reviews.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByReview(Review review);
}
