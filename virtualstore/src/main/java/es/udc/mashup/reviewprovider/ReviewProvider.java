package es.udc.mashup.reviewprovider;

import java.io.Serializable;
import java.util.List;

import es.udc.mashup.virtualstore.service.ProductReviewTO;
import es.udc.mashup.virtualstore.service.ProductTO;
import es.udc.ws.util.exceptions.ServiceException;

public interface ReviewProvider extends Serializable{
	
	public List<ProductTO> searchReviews(List<ProductTO> products) throws ServiceException;
	
	public ProductReviewTO searchReview(ProductTO product) throws ServiceException;
	
	void addReview(ProductTO product, ProductReviewTO productReviewTO) throws ServiceException;

}
