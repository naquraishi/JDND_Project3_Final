package com.udacity.course3.reviews.model;

import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "reviews")
public class ReviewDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String reviewTitle;
    private Product product;
    private List<Comment> comments;

    public ReviewDocument(){

    }
    public ReviewDocument(Review review) {
        this.id = review.getId();
        this.reviewTitle = review.getReviewTitle();
        this.product = review.getProduct();
        this.comments = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Comment> getComments() {
        return this.comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addComments(Comment comment) {
        comments.add(comment);
    }


    @Override
    public String toString() {
        return "ReviewDocument{" +
                "id=" + id +
                ", reviewTitle='" + reviewTitle + '\'' +
                ", product=" + product +
                ", comments=" + comments +
                '}';
    }
}
