package es.udc.mashup.reviewprovider;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.List;

import es.udc.ws.util.exceptions.ServiceException;

public interface ReviewProvider extends Serializable{
	
	public Hashtable<String,List<Review>> searchReviews(List<String> products) throws ServiceException;

}
