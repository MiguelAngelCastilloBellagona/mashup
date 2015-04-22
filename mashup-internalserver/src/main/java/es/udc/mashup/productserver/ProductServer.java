package es.udc.mashup.productserver;

import java.util.Date;
import java.util.List;

import es.udc.ws.util.exceptions.ServiceException;

public interface ProductServer {

	public List<InternalProduct> findProducts(String keywords, String category,
			double minPrice, double maxPrice, int size, Date minDate,
			Date maxDate) throws ServiceException;

	public void addProducts(String productName, String description, String category, double price, double descuento, String imageURL);
}
