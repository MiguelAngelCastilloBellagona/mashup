package es.udc.mashup.productprovider;

import es.udc.ws.util.configuration.ConfigurationParametersManager;
import es.udc.ws.util.exceptions.ServiceException;

@SuppressWarnings("rawtypes")
public class ProductProviderServiceFactory {

	private final static String CLASS_NAME_PARAMETER = "ProductProviderService/className";

	private static ProductProviderService instance;

	static {
		try {
			String implClassName = ConfigurationParametersManager.getParameter(CLASS_NAME_PARAMETER);
			Class implClass = Class.forName(implClassName);
			instance = (ProductProviderService) implClass.newInstance();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private ProductProviderServiceFactory() {
	}

	public static ProductProviderService getInternalProviderService() throws ServiceException {

		if (instance == null) {
			throw new ServiceException("Can not create instance of " + ProductProviderService.class);
		} else {
			return instance;
		}

	}
}
