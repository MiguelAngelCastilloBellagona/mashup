package es.udc.mashup.ui.client.virtualstore;

import java.io.Serializable;
import java.util.List;

public class ProductJTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name = null;
    private String description = null;
    private String category = null;
    private double price = 0;
    private String imageURL = null;
    private List<ProductReviewJTO> reviews = null;

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

    public List<ProductReviewJTO> getReviews() {
        return reviews;
    }

    public void setReviews(List<ProductReviewJTO> reviews) {
        this.reviews = reviews;
    }

}
