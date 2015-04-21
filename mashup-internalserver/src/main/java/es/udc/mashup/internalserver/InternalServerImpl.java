package es.udc.mashup.internalserver;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@WebService(name = "InternalServerProvider", serviceName = "InternalServerService", targetNamespace = "http://ws.adoo.udc.es/")
public class InternalServerImpl {

	Log logger = LogFactory.getLog(InternalServerImpl.class);
	
	List<InternalProduct> lista;

	@PostConstruct()
	private void init() {

	}

	public InternalServerImpl() {
	}

	@WebMethod(operationName = "searchProducts")
	public List<InternalProduct> searchProducts(String keyWords,
			String category, double minPrice, double maxPrice)
			throws IncorrectInternalSearchException {

		return lista;

	}

	@WebMethod(operationName = "searchProductsBetweenDates")
	public List<InternalProduct> searchProductsBetweenDates(String keyWords,
			String category, double minPrice, double maxPrice, Date minDate,
			Date maxDate) throws IncorrectInternalSearchException {

		return lista;

	}

}
