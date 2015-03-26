package es.udc.mashup.internalprovider;

import java.io.Serializable;
import java.util.List;

import es.udc.mashup.virtualstore.service.ProductTO;
import es.udc.ws.util.exceptions.ServiceException;

public interface InternalProviderService extends Serializable {

	public List<ProductTO> findProducts(String productName, String category,
			double minPrice, double maxPrice) throws ServiceException;

	void addProducts(String productName, String category, double price,
			String imageURL);
}
