package es.udc.mashup.virtualstore.service.impl;

import java.util.ArrayList;
import java.util.List;

import es.udc.mashup.productprovider.Product;
import es.udc.mashup.reviewprovider.Review;
import es.udc.mashup.virtualstore.service.ProductReviewTO;
import es.udc.mashup.virtualstore.service.ProductTO;

public class TypeConversor {

	public static List<ProductTO> toProductsTO(List<Product> products) {
		List<ProductTO> productTOs = new ArrayList<ProductTO>();
		if (products!=null) for (Product l : products) {
			productTOs.add(toProductTO(l));
		}
		return productTOs;
	}
	
	public static ProductTO toProductTO(Product product) {
		if (product != null) {
			ProductTO productTO = new ProductTO();
			productTO.setCategory(product.getCategory());
			productTO.setDate(product.getDate());
			productTO.setDescription(product.getDescription());
			productTO.setImageURL(product.getImageURL());
			productTO.setName(product.getName());
			productTO.setPrice(product.getPrice());
			return productTO;
		} else {
			return null;
		}
	}
	
	public static List<ProductReviewTO> toProductReviewTOs(List<Review> reviews) {
		List<ProductReviewTO> leadTOs = new ArrayList<ProductReviewTO>();
		if (reviews!=null) for (Review l : reviews) {
			leadTOs.add(toProductReviewTO(l));
		}
		return leadTOs;
	}

	public static ProductReviewTO toProductReviewTO(Review review) {
		if (review != null) {
			ProductReviewTO aReviewJTO = new ProductReviewTO();
			aReviewJTO.setDescription(review.getDescription());
			aReviewJTO.setReviewer(review.getReviewer());
			aReviewJTO.setScore(review.getScore());
			return aReviewJTO;
		} else {
			return null;
		}
	}
}
