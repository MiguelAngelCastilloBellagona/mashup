package es.udc.mashup.virtualstore.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import es.udc.mashup.productprovider.ProductProviderServiceFactory;
import es.udc.mashup.reviewprovider.Review;
import es.udc.mashup.reviewprovider.ReviewProviderFacebookFactory;
import es.udc.mashup.virtualstore.service.ProductTO;
import es.udc.mashup.virtualstore.service.VirtualProductProviderService;
import es.udc.ws.util.exceptions.ServiceException;

public class CustomVirtualProductProviderService implements VirtualProductProviderService {

	private static final long serialVersionUID = 1L;

	@Override
	public List<ProductTO> findProducts(String productName, String category, double minPrice, double maxPrice) throws ServiceException {

		int size = 100;

		List<ProductTO> productos = TypeConversor.toProductsTO(ProductProviderServiceFactory.getProductProviderService().findProducts(
				productName, category, minPrice, maxPrice, size));

		List<String> names = new ArrayList<String>();

		for (ProductTO p : productos)
			names.add(p.getName());

		Hashtable<String, List<Review>> reviews = ReviewProviderFacebookFactory.getReviewProviderService().searchReviews(names);
		
		for (ProductTO p : productos) {
			p.setReviews(TypeConversor.toProductReviewTOs(reviews.get(p.getName())));
		}

		return productos;
	}

	@Override
	public List<ProductTO> findProductsBetweenDates(String productName, String category, double minPrice, double maxPrice, Date minDate,
			Date maxDate) throws ServiceException {

		int size = 100;

		List<ProductTO> productos = TypeConversor.toProductsTO(ProductProviderServiceFactory.getProductProviderService()
				.findProductsBetweenDates(productName, category, minPrice, maxPrice, size, minDate, maxDate));

		List<String> names = new ArrayList<String>();

		for (ProductTO p : productos)
			names.add(p.getName());

		Hashtable<String, List<Review>> reviews = ReviewProviderFacebookFactory.getReviewProviderService().searchReviews(names);

		for (ProductTO p : productos) {
			p.setReviews(TypeConversor.toProductReviewTOs(reviews.get(p.getName())));
		}

		return productos;
	}
}
