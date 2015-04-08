package es.udc.mashup.virtualstore.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.udc.mashup.ebayprovider.EbayPrividerServiceFactory;
import es.udc.mashup.ebayprovider.EbayProviderService;
import es.udc.mashup.ebayprovider.EbayProviderServiceImplementation;
import es.udc.mashup.internalprovider.InternalProviderService;
import es.udc.mashup.internalprovider.InternalProviderServiceFactory;
import es.udc.mashup.internalprovider.InternalProviderServiceImplementation;
import es.udc.mashup.reviewprovider.ReviewProviderFacebookImplementation;
import es.udc.mashup.reviewprovider.ReviewProviderFacebookImplementationFactory;
import es.udc.mashup.virtualstore.service.ProductReviewTO;
import es.udc.mashup.virtualstore.service.ProductTO;
import es.udc.mashup.virtualstore.service.VirtualProductProviderService;
import es.udc.mashup.virtualstore.service.VirtualProductProviderServiceFactory;
import es.udc.ws.util.exceptions.ServiceException;

@SuppressWarnings("unused")
public class CustomVirtualProductProviderService implements VirtualProductProviderService {
	
	private static final long serialVersionUID = 1L;

	@Override
	public List<ProductTO> findProducts(String productName, String category,
			double minPrice, double maxPrice) throws ServiceException {
		
		List<ProductTO> productsInternal = findProductsInternalSupplier(productName,category,minPrice,maxPrice);
		List<ProductTO> productsEbay     = findProductsEbaySupplier(productName,category,minPrice,maxPrice);
		List<ProductTO> products = new ArrayList<ProductTO>();
		products.addAll(productsInternal);
		products.addAll(productsEbay);
		
		ReviewProviderFacebookImplementationFactory.getReviewProviderService().searchReviews(products);
		
		return products;
	}

	public List<ProductTO> findProductsInternalSupplier(String productName,
			String category, double minPrice, double maxPrice) {
	
		return this.getRealInternalProviderService().findProducts(productName, category, minPrice, maxPrice);
		
	}

	public List<ProductTO> findProductsEbaySupplier(String productName,
			String category, double minPrice, double maxPrice)
			throws ServiceException {

		Date modTimeFrom = null;     //Ahora está a nulo para que vengan todos
		int size = 100;              //Falta ver como se obtine
		
		return this.getRealEbayProviderService().findProducts(productName, category, minPrice, maxPrice, size, modTimeFrom);
	}
	
	private EbayProviderService getRealEbayProviderService() {
		return EbayPrividerServiceFactory.getEbayProviderService();
	}

	private InternalProviderService getRealInternalProviderService() {
		return InternalProviderServiceFactory.getInternalProviderService();
	}
}
