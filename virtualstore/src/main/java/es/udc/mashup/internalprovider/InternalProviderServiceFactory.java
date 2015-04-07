package es.udc.mashup.internalprovider;

import es.udc.ws.util.configuration.ConfigurationParametersManager;
import es.udc.ws.util.exceptions.ServiceException;

@SuppressWarnings("rawtypes")
public class InternalProviderServiceFactory {

	private final static String CLASS_NAME_PARAMETER = "InternalProviderService/className";

	private static InternalProviderService instance;

	static {
		try {
			String implClassName = ConfigurationParametersManager
					.getParameter(CLASS_NAME_PARAMETER);
			Class implClass = Class.forName(implClassName);
			instance = (InternalProviderService) implClass.newInstance();
		} catch (Exception e) {
		}
	}

	private InternalProviderServiceFactory() {
	}

	public static InternalProviderService getInternalProviderService()
			throws ServiceException {

		if (instance == null) {
			throw new ServiceException("Can not create instance of "
					+ InternalProviderService.class);
		} else {
			return instance;
		}

	}

}
