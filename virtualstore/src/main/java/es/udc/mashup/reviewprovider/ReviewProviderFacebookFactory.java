package es.udc.mashup.reviewprovider;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import es.udc.ws.util.exceptions.ServiceException;

@SuppressWarnings("rawtypes")
public class ReviewProviderFacebookFactory {

	private final static String CLASS_NAME_PARAMETER = "ReviewProvicerService/className";
	private static final String CONFIGURATION_FILE = "Providers.properties";

	private static ReviewProvider instance;

	static {
		
		Properties properties = new Properties();
		InputStream inputStream = ReviewProviderFacebookFactory.class.getClassLoader().getResourceAsStream(CONFIGURATION_FILE);

		try {
			properties.load(inputStream);
		} catch (IOException e1) {
			System.out.println("File not found: " + CONFIGURATION_FILE);
		}
		try {
			String implClassName = properties.getProperty(CLASS_NAME_PARAMETER);
			Class implClass = Class.forName(implClassName);
			instance = (ReviewProvider) implClass.newInstance();
		} catch (Exception e) {
		}
	}

	private ReviewProviderFacebookFactory() {
	}

	public static ReviewProvider getReviewProviderService()
			throws ServiceException {

		if (instance == null) {
			throw new ServiceException("Can not create instance of " + ReviewProvider.class);
		} else {
			return instance;
		}

	}

}
