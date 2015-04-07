package es.udc.mashup.ebayprovider;

import es.udc.ws.util.configuration.ConfigurationParametersManager;
import es.udc.ws.util.exceptions.ServiceException;

@SuppressWarnings("rawtypes")
public class EbayPrividerServiceFactory {

	private final static String CLASS_NAME_PARAMETER = "EbayProviderService/className";

	private static EbayProviderService instance;

	static {
		try {
			String implClassName = ConfigurationParametersManager
					.getParameter(CLASS_NAME_PARAMETER);
			Class implClass = Class.forName(implClassName);
			instance = (EbayProviderService) implClass.newInstance();
		} catch (Exception e) {
		}
	}

	private EbayPrividerServiceFactory() {
	}

	public static EbayProviderService getEbayProviderService()
			throws ServiceException {

		if (instance == null) {
			throw new ServiceException("Can not create instance of " + EbayProviderService.class);
		} else {
			return instance;
		}

	}

}
