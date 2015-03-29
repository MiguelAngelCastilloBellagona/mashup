package es.udc.mashup.ui.server.virtualstore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import es.udc.mashup.ui.client.virtualstore.DateJTO;
import es.udc.mashup.ui.client.virtualstore.ProductReviewJTO;
import es.udc.mashup.ui.client.virtualstore.ProductJTO;
import es.udc.mashup.virtualstore.service.ProductReviewTO;
import es.udc.mashup.virtualstore.service.ProductTO;

public class TypeConversor {

	public static List<ProductJTO> toProductJTOs(List<ProductTO> productTOs) {
		List<ProductJTO> leadJTOs = new ArrayList<ProductJTO>();
		for (ProductTO l : productTOs) {
			leadJTOs.add(toProductJTO(l));
		}
		return leadJTOs;
	}

	public static ProductJTO toProductJTO(ProductTO aProductTO) {
		ProductJTO aProductJTO = new ProductJTO();
		aProductJTO.setCategory(aProductTO.getCategory());
		aProductJTO.setDescription(aProductTO.getDescription());
		aProductJTO.setImageURL(aProductTO.getImageURL());
		aProductJTO.setPrice(aProductTO.getPrice());
		aProductJTO.setName(aProductTO.getName());
		List<ProductReviewJTO> reviewJTOs = new ArrayList<ProductReviewJTO>();
		aProductJTO.setReviews(reviewJTOs);
		List<ProductReviewTO> aProductReviews = aProductTO.getReviews();
		if (aProductReviews != null) {
			for (int i = 0; i < aProductReviews.size(); i++) {
				ProductReviewTO productReviewTO = (ProductReviewTO) aProductReviews
						.get(i);
				reviewJTOs.add(toReviewJTO(productReviewTO));
			}
		}
		return aProductJTO;
	}

	public static DateJTO toDateJTO(Calendar date) {
		return new DateJTO(date.get(Calendar.DAY_OF_MONTH),
				date.get(Calendar.MONTH) - Calendar.JANUARY + 1,
				date.get(Calendar.YEAR));
	}

	public static ProductReviewJTO toReviewJTO(ProductReviewTO reviewTO) {
		if (reviewTO != null) {
			ProductReviewJTO aReviewJTO = new ProductReviewJTO();
			aReviewJTO.setDescription(reviewTO.getDescription());
			aReviewJTO.setReviewer(reviewTO.getReviewer());
			aReviewJTO.setScore(reviewTO.getScore());
			return aReviewJTO;
		} else {
			return null;
		}
	}
}
