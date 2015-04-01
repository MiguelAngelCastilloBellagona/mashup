package es.udc.mashup.ebayprovider;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import es.udc.mashup.virtualstore.service.ProductTO;
import es.udc.ws.util.exceptions.ServiceException;

public interface EbayProviderService extends Serializable{

	public List<ProductTO> findProducts(String keywords, String category,
			double minPrice, double maxPrice, int size, Date modTimeFrom) throws ServiceException;

}
