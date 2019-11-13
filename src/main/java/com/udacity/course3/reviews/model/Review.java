package com.udacity.course3.reviews.model;

import javax.persistence.*;

@Entity
@Table(name = "reviews_table")

public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Integer id;

    @Column(name = "title")
    private String reviewTitle;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Review(){

    }
    public Review(Integer id){
        this.id = id;
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

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", reviewTitle='" + reviewTitle + '\'' +
                ", product=" + product +
                '}';
    }
}
