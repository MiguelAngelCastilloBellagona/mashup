package es.udc.mashup.internalprovider;

import java.util.ArrayList;
import java.util.List;

import es.udc.mashup.virtualstore.service.ProductTO;
import es.udc.ws.util.exceptions.ServiceException;

public class InternalProviderServiceImplementation implements
		InternalProviderService {

	private static final long serialVersionUID = 1L;

	List<ProductTO> lista = new ArrayList<ProductTO>();

	@Override
	public List<ProductTO> findProducts(String productName, String category,
			double minPrice, double maxPrice) throws ServiceException {

		return lista;
	}

	@Override
	public void addProducts(String productName, String category, double price,
			String imageURL) {
		ProductTO product = new ProductTO();
		product.setName(productName);
		product.setCategory(category);
		product.setPrice(price);
		product.setImageURL(imageURL);

		lista.add(product);

	}

}
