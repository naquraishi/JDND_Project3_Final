package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.model.ReviewDocument;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@ConditionalOnProperty(name = "mongo.enabled", matchIfMissing = true)
public interface ReviewDocumentRepository extends MongoRepository<ReviewDocument, Integer> {
    List<ReviewDocument> findAllByProduct(Product product);
}
