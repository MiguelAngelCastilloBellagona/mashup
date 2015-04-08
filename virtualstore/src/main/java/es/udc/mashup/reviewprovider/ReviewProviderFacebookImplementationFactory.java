package es.udc.mashup.reviewprovider;

import es.udc.ws.util.configuration.ConfigurationParametersManager;
import es.udc.ws.util.exceptions.ServiceException;

@SuppressWarnings("rawtypes")
public class ReviewProviderFacebookImplementationFactory {

	private final static String CLASS_NAME_PARAMETER = "ReviewProvicerService/className";

	private static ReviewProvider instance;

	static {
		try {
			String implClassName = ConfigurationParametersManager
					.getParameter(CLASS_NAME_PARAMETER);
			Class implClass = Class.forName(implClassName);
			instance = (ReviewProvider) implClass.newInstance();
		} catch (Exception e) {
		}
	}

	private ReviewProviderFacebookImplementationFactory() {
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
