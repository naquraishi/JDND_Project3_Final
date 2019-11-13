package com.udacity.course3.reviews;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.udacity.course3.reviews.model.Comment;
import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.model.Review;
import com.udacity.course3.reviews.repository.CommentsRepository;
import com.udacity.course3.reviews.repository.ProductsRepository;
import com.udacity.course3.reviews.repository.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(properties = "mongo.enabled=false")
public class ReviewsApplicationTests {

	@Autowired
	CommentsRepository commentsRepository;
	@Autowired
	ProductsRepository productsRepository;
	@Autowired
	ReviewsRepository reviewsRepository;

	@Before
	public void setup(){
		Product product = new Product();
		Review review = new Review();
		Comment comment = new Comment();

		product.setProductName("Test Product");
		productsRepository.save(product);
		review.setReviewTitle("Test Review Title");
		review.setProduct(product);
		reviewsRepository.save(review);
		comment.setCommentContent("Test Comment");
		comment.setReview(review);
		commentsRepository.save(comment);

	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void productEntityTest(){
			Product product = productsRepository.findAll().get(0);
			assertEquals("Test Product", product.getProductName());
	}

	@Test
	public void reviewEntityTest(){
		Review review = reviewsRepository.findAll().get(0);
		assertEquals("Test Review Title", review.getReviewTitle());
	}

	@Test
	public void commentEntityTest(){
		Comment comment = commentsRepository.findAll().get(0);
		assertEquals("Test Comment", comment.getCommentContent());
	}

}