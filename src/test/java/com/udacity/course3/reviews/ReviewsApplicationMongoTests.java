package com.udacity.course3.reviews;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import com.udacity.course3.reviews.model.Comment;
import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.model.ReviewDocument;
import com.udacity.course3.reviews.repository.ReviewDocumentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataMongoTest
public class ReviewsApplicationMongoTests {

    @Autowired
    private ReviewDocumentRepository reviewDocumentRepository;

    @Test
    public void testMongoReview() {
        Product product = new Product();
        product.setProductName("Mongo Test Product");

        Comment comment = new Comment();
        comment.setCommentContent("A Mongo Test Comment");
        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);

        ReviewDocument reviewDocument = new ReviewDocument();
        reviewDocument.setId(1);
        reviewDocument.setProduct(product);
        reviewDocument.setReviewTitle("A mongo test review");
        reviewDocument.setComments(commentList);

        reviewDocumentRepository.save(reviewDocument);

        ReviewDocument savedReviewDocument = reviewDocumentRepository.findAllByProduct(product).get(0);

        assertEquals(1, savedReviewDocument.getId().intValue());
        assertEquals("Mongo Test Product", savedReviewDocument.getProduct().getProductName());
        assertEquals("A mongo test review", savedReviewDocument.getReviewTitle());
        assertEquals("A Mongo Test Comment", savedReviewDocument.getComments().get(0).getCommentContent());
    }
}
