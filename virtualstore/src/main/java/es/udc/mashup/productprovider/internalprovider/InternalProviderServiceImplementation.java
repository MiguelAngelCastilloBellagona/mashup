package es.udc.mashup.productprovider.internalprovider;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.udc.mashup.productprovider.Product;
import es.udc.mashup.productprovider.ProductProviderService;
import es.udc.ws.util.exceptions.ServiceException;

public class InternalProviderServiceImplementation implements ProductProviderService {

	List<Product> lista = new ArrayList<Product>();

	public InternalProviderServiceImplementation() {
		this.addProducts("Publicacion 1", "Laptops", 200, "");
		this.addProducts("Primera publicación", "Laptops", 200, "");
	}
	
	public void addProducts(String productName, String category, double price, String imageURL) {
		Product product = new Product();
		product.setName(productName);
		product.setCategory(category);
		product.setPrice(price);
		product.setImageURL(imageURL);

		lista.add(product);

	}

	@Override
	public List<Product> findProducts(String keywords, String category, double minPrice, double maxPrice, int size,
			Date modTimeFrom) throws ServiceException {

		return lista;
	}

}
