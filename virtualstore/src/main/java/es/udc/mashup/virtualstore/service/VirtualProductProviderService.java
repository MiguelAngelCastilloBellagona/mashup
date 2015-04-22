package es.udc.mashup.virtualstore.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import es.udc.ws.util.exceptions.ServiceException;

public interface VirtualProductProviderService extends Serializable {

	public List<ProductTO> findProducts(String productName, String category, double minPrice, double maxPrice) throws ServiceException;

	public List<ProductTO> findProductsBetweenDates(String productName, String category, double minPrice, double maxPrice, Date minDate,
			Date maxDate) throws ServiceException;
}
