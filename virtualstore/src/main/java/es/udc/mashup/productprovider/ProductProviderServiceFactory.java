package es.udc.mashup.productprovider;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import es.udc.ws.util.exceptions.ServiceException;

@SuppressWarnings("rawtypes")
public class ProductProviderServiceFactory {

	private final static String CLASS_NAME_PARAMETER = "ProductProviderService/className";
	private static final String CONFIGURATION_FILE = "Providers.properties";

	private static ProductProviderService instance;

	static {

		Properties properties = new Properties();
		InputStream inputStream = ProductProviderServiceFactory.class.getClassLoader().getResourceAsStream(CONFIGURATION_FILE);

		try {
			properties.load(inputStream);
		} catch (IOException e1) {
			System.out.println("File not found: " + CONFIGURATION_FILE);
		}
		try {
			String implClassName = properties.getProperty(CLASS_NAME_PARAMETER);
			Class implClass = Class.forName(implClassName);
			instance = (ProductProviderService) implClass.newInstance();
		} catch (Exception e) {
		}
	}

	private ProductProviderServiceFactory() {
	}

	public static ProductProviderService getProductProviderService() throws ServiceException {

		if (instance == null) {
			throw new ServiceException("Can not create instance of " + ProductProviderService.class);
		} else {
			return instance;
		}

	}
}
