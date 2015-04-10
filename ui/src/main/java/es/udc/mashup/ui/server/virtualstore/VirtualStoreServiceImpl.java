package es.udc.mashup.ui.server.virtualstore;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import es.udc.mashup.ui.client.virtualstore.InvalidSearchException;
import es.udc.mashup.ui.client.virtualstore.ProductJTO;
import es.udc.mashup.virtualstore.service.ProductTO;
import es.udc.mashup.virtualstore.service.VirtualProductProviderService;
import es.udc.mashup.virtualstore.service.VirtualProductProviderServiceFactory;
import es.udc.ws.util.configuration.ConfigurationParametersManager;
import java.util.Arrays;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class VirtualStoreServiceImpl extends RemoteServiceServlet implements
		es.udc.mashup.ui.client.virtualstore.VirtualStoreService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static Log logger = LogFactory.getLog(VirtualStoreServiceImpl.class);

	public final static String CATEGORIES_PARAMETER = "VirtualStoreService/categories";
	public final static String CATEGORIES_PARAMETER_SEPARATOR = ",";

	@Override
	public List<ProductJTO> findProducts(String productName, String category, double minPrice, double maxPrice)
			throws InvalidSearchException {
		validate(productName, category, minPrice, maxPrice);
		List<ProductTO> products = getRealService().findProducts(productName, category, minPrice, maxPrice);
		return TypeConversor.toProductJTOs(products);

	}

	@Override
	public List<String> findCategories() throws InvalidSearchException {
		try {
			String categories = ConfigurationParametersManager.getParameter(CATEGORIES_PARAMETER);
			return Arrays.asList(categories.split(CATEGORIES_PARAMETER_SEPARATOR));
		} catch (Exception e) {
			logger.error(e, e);
		}
		return null;
	}

	private void validate(String productName, String category, double minPrice, double maxPrice)
			throws InvalidSearchException {
	}

	private VirtualProductProviderService getRealService() {
		return VirtualProductProviderServiceFactory.getVirtualProviderService();
	}

}
