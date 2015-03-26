package es.udc.mashup.virtualstore.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductTO {
    
    private String name = null;
    private String description = null;
    private String category = null;
    private double price = 0;
    private String imageURL = null;
    private List<ProductReviewTO> reviews = null;
    private Date date = null;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<ProductReviewTO> getReviews() {
        return reviews;
    }

    public void setReviews(List<ProductReviewTO> reviews) {
        this.reviews = reviews;
    }

    public void addReview(ProductReviewTO review) {
        if(reviews == null) {
            reviews = new ArrayList<ProductReviewTO>();
        }
        reviews.add(review);
    }

}
