package es.udc.mashup.productserver;

import es.udc.ws.util.configuration.ConfigurationParametersManager;
import es.udc.ws.util.exceptions.ServiceException;

@SuppressWarnings("rawtypes")
public class ProductServerFactory {
	private final static String CLASS_NAME_PARAMETER = "ProductServer/className";

	private static ProductServer instance;

	static {
		try {
			String implClassName = ConfigurationParametersManager.getParameter(CLASS_NAME_PARAMETER);
			Class implClass = Class.forName(implClassName);
			instance = (ProductServer) implClass.newInstance();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private ProductServerFactory() {
	}

	public static ProductServer getInternalProviderService() throws ServiceException {

		if (instance == null) {
			throw new ServiceException("Can not create instance of " + ProductServer.class);
		} else {
			return instance;
		}

	}
}
