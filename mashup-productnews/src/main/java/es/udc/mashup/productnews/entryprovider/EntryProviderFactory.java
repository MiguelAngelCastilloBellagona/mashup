package es.udc.mashup.productnews.entryprovider;

import es.udc.ws.util.configuration.ConfigurationParametersManager;
import es.udc.ws.util.exceptions.ServiceException;

@SuppressWarnings("rawtypes")
public class EntryProviderFactory {
	
	private final static String CLASS_NAME_PARAMETER = "EntryProvider/className";

	private static EntryProvider instance;

	static {
		try {
			String implClassName = ConfigurationParametersManager.getParameter(CLASS_NAME_PARAMETER);
			Class implClass = Class.forName(implClassName);
			instance = (EntryProvider) implClass.newInstance();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private EntryProviderFactory() {
	}

	public static EntryProvider getEntryProvider() throws ServiceException {

		if (instance == null) {
			throw new ServiceException("Can not create instance of " + EntryProvider.class);
		} else {
			return instance;
		}

	}

}
