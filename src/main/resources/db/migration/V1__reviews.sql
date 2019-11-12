CREATE TABLE products_table(
    product_id INT NOT NULL AUTO_INCREMENT,
    product_name VARCHAR(100) NOT NULL,
    PRIMARY KEY (product_id)
);

CREATE TABLE reviews_table(
    review_id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(200),
    product_id INT NOT NULL,
    PRIMARY KEY (review_id),
    FOREIGN KEY(product_id) REFERENCES products_table(product_id)
);

CREATE TABLE comments_table(
    comment_id INT NOT NULL AUTO_INCREMENT,
    comment_content VARCHAR(1000),
    review_id INT NOT NULL,
    PRIMARY KEY (comment_id),
    FOREIGN KEY (review_id) REFERENCES reviews_table (review_id)
);




