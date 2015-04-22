package es.udc.mashup.productprovider.internalprovider;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;

import es.udc.mashup.internalservice.wsdl.IncorrectInternalSearchException;
import es.udc.mashup.internalservice.wsdl.InternalProduct;
import es.udc.mashup.internalservice.wsdl.InternalServerProvider;
import es.udc.mashup.internalservice.wsdl.InternalServerService;
import es.udc.mashup.productprovider.Product;
import es.udc.mashup.productprovider.ProductProviderService;
import es.udc.ws.util.exceptions.ServiceException;

public class InternalProviderServiceImplementation implements ProductProviderService {

	private final String URL = "http://localhost:8081/mashup-internaserver/services/InternalServer";

	private InternalServerService internalServerService;

	public InternalProviderServiceImplementation() {
		this.internalServerService = new InternalServerService();
	}

	public void addProducts(String productName, String category, double price, String imageURL) {

	}

	@Override
	public List<Product> findProducts(String keywords, String category, double minPrice, double maxPrice, int size) throws ServiceException {

		InternalServerProvider internalServerProvider = internalServerService.getInternalServerProviderPort();

		((BindingProvider) internalServerProvider).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, URL);

		List<InternalProduct> internalList = null;

		try {
			internalList = internalServerProvider.searchProducts(keywords, category, minPrice, maxPrice);
		} catch (IncorrectInternalSearchException e) {
			System.out.println("Fallo en busqueda");
		}

		return TypeConversor.toProductsTO(internalList);

	}

	@Override
	public List<Product> findProductsBetweenDates(String keywords, String category, double minPrice, double maxPrice, int size,
			Date minDate, Date maxDate) throws ServiceException {
		InternalServerProvider internalServerProvider = internalServerService.getInternalServerProviderPort();

		((BindingProvider) internalServerProvider).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, URL);

		List<InternalProduct> internalList = null;

		GregorianCalendar minDateCalendar = new GregorianCalendar();
		minDateCalendar.setTime(minDate);
		XMLGregorianCalendar minXMLGreg = null;
		GregorianCalendar maxDateCalendar = new GregorianCalendar();
		minDateCalendar.setTime(maxDate);
		XMLGregorianCalendar maxXMLGreg = null;
		
		try {
			minXMLGreg = DatatypeFactory.newInstance().newXMLGregorianCalendar(minDateCalendar);
			maxXMLGreg = DatatypeFactory.newInstance().newXMLGregorianCalendar(maxDateCalendar);
		} catch (DatatypeConfigurationException e1) {
			System.out.println("Error con las fechas");
			return null;
		}
		try {
			internalList = internalServerProvider.searchProductsBetweenDates(keywords, category, minPrice, maxPrice, minXMLGreg, maxXMLGreg);
		} catch (IncorrectInternalSearchException e) {
			System.out.println("Fallo en busqueda");
		}

		return TypeConversor.toProductsTO(internalList);

	}

}
