package com.udacity.course3.reviews.model;

import javax.persistence.*;

@Entity
@Table(name="comments_table")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int id;

    @Column(name = "comment_content")
    private String commentContent;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", commentContent='" + commentContent + '\'' +
                ", review=" + review +
                '}';
    }
}
