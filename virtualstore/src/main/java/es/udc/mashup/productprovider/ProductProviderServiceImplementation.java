package es.udc.mashup.productprovider;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import es.udc.ws.util.exceptions.ServiceException;

public class ProductProviderServiceImplementation implements ProductProviderService {

	public final static String CONFIGURATION_FILE = "ProductProvider.properties";
	public final static String PROVIDERS_PARAMETER ="ProductsProvider/providers";
	public final static String PROVIDERS_PARAMETER_SEPARATOR = ";";

	List<ProductProviderService> providers;

	private List<String> findProductProviders() {

		Properties properties = new Properties();
		InputStream inputStream = ProductProviderServiceImplementation.class.getClassLoader().getResourceAsStream(CONFIGURATION_FILE);

		try {
			properties.load(inputStream);
		} catch (IOException e1) {
			System.out.println("File not found: " + CONFIGURATION_FILE);
		}
		try {
			String classes = properties.getProperty(PROVIDERS_PARAMETER);
			return Arrays.asList(classes.split(PROVIDERS_PARAMETER_SEPARATOR));
		} catch (Exception e) {
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	public ProductProviderServiceImplementation() {
		providers = new ArrayList<ProductProviderService>();
		for (String implClassName : findProductProviders()) {
			try {
				Class implClass = Class.forName(implClassName);
				ProductProviderService instance = (ProductProviderService) implClass.newInstance();
				providers.add(instance);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				System.out.println("Can't generate class: " + implClassName + " " + e.getMessage());
			}
		}
	}

	@Override
	public List<Product> findProducts(String keywords, String category, double minPrice, double maxPrice, int size,
			Date modTimeFrom) throws ServiceException {
		
		List<Product> products = new ArrayList<Product>();
		for(ProductProviderService pps : this.providers) {
			products.addAll(pps.findProducts(keywords, category, minPrice, maxPrice, size, modTimeFrom));
		}
		return products;
	}

}
