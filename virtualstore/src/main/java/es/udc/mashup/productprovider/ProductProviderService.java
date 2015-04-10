package es.udc.mashup.productprovider;

import java.util.Date;
import java.util.List;

import es.udc.ws.util.exceptions.ServiceException;

public interface ProductProviderService {
	public List<Product> findProducts(String keywords, String category, double minPrice, double maxPrice, int size,
			Date modTimeFrom) throws ServiceException;
}
