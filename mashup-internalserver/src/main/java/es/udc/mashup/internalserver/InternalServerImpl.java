package es.udc.mashup.internalserver;

import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.udc.mashup.productserver.ProductServerFactory;

@WebService(name = "InternalServerProvider", serviceName = "InternalServerService", targetNamespace = "http://ws.adoo.udc.es/")
public class InternalServerImpl {

	Log logger = LogFactory.getLog(InternalServerImpl.class);

	public InternalServerImpl() {
	}

	@WebMethod(operationName = "searchProducts")
	public List<InternalProductOutput> searchProducts(String keyWords, String category, double minPrice, double maxPrice)
			throws IncorrectInternalSearchException {

		return TypeConversor.toInternalProductOutputs(ProductServerFactory.getInternalProviderService().findProducts(keyWords, category,
				minPrice, maxPrice, 100, null, null));

	}

	@WebMethod(operationName = "searchProductsBetweenDates")
	public List<InternalProductOutput> searchProductsBetweenDates(String keyWords, String category, double minPrice, double maxPrice,
			Date minDate, Date maxDate) throws IncorrectInternalSearchException {

		return TypeConversor.toInternalProductOutputs(ProductServerFactory.getInternalProviderService().findProducts(keyWords, category,
				minPrice, maxPrice, 100, minDate, maxDate));

	}

}
