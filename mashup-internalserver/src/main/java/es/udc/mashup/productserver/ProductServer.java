package es.udc.mashup.productserver;

import java.util.Date;
import java.util.List;

import es.udc.mashup.internalserver.InternalProduct;
import es.udc.ws.util.exceptions.ServiceException;


public interface ProductServer {
	public List<InternalProduct> findProducts(String keywords, String category, double minPrice, double maxPrice, int size,
			Date modTimeFrom) throws ServiceException;

}
