package es.udc.mashup.virtualstore.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.udc.mashup.ebayprovider.EbayProviderService;
import es.udc.mashup.ebayprovider.EbayProviderServiceImplementation;
import es.udc.mashup.internalprovider.InternalProviderService;
import es.udc.mashup.internalprovider.InternalProviderServiceImplementation;
import es.udc.mashup.virtualstore.service.ProductReviewTO;
import es.udc.mashup.virtualstore.service.ProductTO;
import es.udc.mashup.virtualstore.service.VirtualProductProviderService;
import es.udc.mashup.virtualstore.service.VirtualProductProviderServiceFactory;
import es.udc.ws.util.exceptions.ServiceException;

@SuppressWarnings("unused")
public class MockVirtualProductProviderService implements
		VirtualProductProviderService {
	
	private static final long serialVersionUID = 1L;
	
	private InternalProviderService internalProviderService;
	private EbayProviderService ebayProviderService;
	
	public MockVirtualProductProviderService() {
		this.internalProviderService = new InternalProviderServiceImplementation();
		this.ebayProviderService = new EbayProviderServiceImplementation();
	}

	@Override
	public List<ProductTO> findProducts(String productName, String category,
			double minPrice, double maxPrice) throws ServiceException {
		
		List<ProductTO> productsInternal = findProductsInternalSupplier(productName,category,minPrice,maxPrice);
		List<ProductTO> productsEbay     = findProductsEbaySupplier(productName,category,minPrice,maxPrice);
		List<ProductTO> products = new ArrayList<ProductTO>();
		products.addAll(productsEbay);
		products.addAll(productsInternal);
		
		/*
		ProductReviewTO review00 = new ProductReviewTO();
		review00.setScore(0);
		review00.setReviewer("Expert User - 3987");
		review00.setDescription("Graphics performance is slightly worse than last year's 13-inch model; 13-inch screen resolution still low compared with the previous model; limited upgrade options; expensive; no HDMI or Blu-ray.");

		ProductReviewTO review01 = new ProductReviewTO();
		review01.setScore(1);
		review01.setReviewer("Guest User - 9875");
		review01.setDescription("CPU updates offer big leaps in performance; phenomenal battery life; excellent ergonomics, keyboard, and large, smooth, multitouch clickpad are still among the best available; 720p HD Webcam.");

		ProductReviewTO review02 = new ProductReviewTO();
		review02.setScore(1);
		review02.setReviewer("Reviewer User - 8753");
		review02.setDescription("Slim, upscale design; excellent keyboard and touch pad; includes wireless display and built-in 4G wireless; solid value.");

		ProductTO product01 = new ProductTO();
		product01.setName("XZ-2098 Portable Slim");
		product01.setCategory("Laptops");
		product01
				.setDescription("Despite retaining the same price and look as last year's model, XZ2098 Pro has significant CPU updates and fantastic battery life make it one of the top laptops we've reviewed, provided you can live with passable integrated graphics.");
		product01.setPrice(900);
		product01.addReview(review00);
		product01.addReview(review01);
		product01.addReview(review02);
		
		products.add(product01);
		*/
		return products;

		/*
		List<ProductTO> products = new ArrayList<ProductTO>();

		ProductReviewTO review00 = new ProductReviewTO();
		review00.setScore(0);
		review00.setReviewer("Expert User - 3987");
		review00.setDescription("Graphics performance is slightly worse than last year's 13-inch model; 13-inch screen resolution still low compared with the previous model; limited upgrade options; expensive; no HDMI or Blu-ray.");

		ProductReviewTO review01 = new ProductReviewTO();
		review01.setScore(1);
		review01.setReviewer("Guest User - 9875");
		review01.setDescription("CPU updates offer big leaps in performance; phenomenal battery life; excellent ergonomics, keyboard, and large, smooth, multitouch clickpad are still among the best available; 720p HD Webcam.");

		ProductReviewTO review02 = new ProductReviewTO();
		review02.setScore(1);
		review02.setReviewer("Reviewer User - 8753");
		review02.setDescription("Slim, upscale design; excellent keyboard and touch pad; includes wireless display and built-in 4G wireless; solid value.");

		ProductTO product00 = new ProductTO();
		product00.setName("TR-40975 Power");
		product00.setCategory("Laptops");
		product00
				.setDescription("Attractive design; 14.5-inch size offers same resolution as 15.6-inch laptops while saving a bit of size and weight; awesome keyboard; above-average audio.");
		product00.setPrice(1600);
		product00.addReview(review00);
		product00.addReview(review01);
		product00.addReview(review01);
		product00.addReview(review01);
		product00.addReview(review01);
		product00.addReview(review01);
		product00.addReview(review01);
		product00.addReview(review01);

		ProductTO product01 = new ProductTO();
		product01.setName("XZ-2098 Portable Slim");
		product01.setCategory("Laptops");
		product01
				.setDescription("Despite retaining the same price and look as last year's model, XZ2098 Pro has significant CPU updates and fantastic battery life make it one of the top laptops we've reviewed, provided you can live with passable integrated graphics.");
		product01.setPrice(900);
		product01.addReview(review00);
		product01.addReview(review01);
		product01.addReview(review02);
		product01.addReview(review00);
		product01.addReview(review01);
		product01.addReview(review02);
		product01.addReview(review00);
		product01.addReview(review01);
		product01.addReview(review02);
		product01.addReview(review00);
		product01.addReview(review00);
		product01.addReview(review00);
		product01.addReview(review00);
		product01.addReview(review00);

		ProductTO product02 = new ProductTO();
		product02.setName("LP-76388 Notebook");
		product02.setCategory("Laptops");
		product02
				.setDescription("Though it's still in the upper ranges of current laptop prices, LP-76388 offers great hardware at a decent price.");
		product02.setPrice(1250);
		product02.addReview(review00);
		product02.addReview(review01);
		product02.addReview(review02);
		product02.addReview(review00);
		product02.addReview(review01);
		product02.addReview(review00);
		product02.addReview(review01);
		product02.addReview(review01);
		product02.addReview(review00);
		product02.addReview(review01);

		products.add(product00);
		products.add(product00);
		products.add(product01);
		products.add(product01);
		products.add(product02);
		products.add(product00);
		products.add(product01);
		products.add(product00);
		products.add(product02);
		products.add(product01);
		products.add(product00);
		products.add(product02);
		products.add(product02);
		products.add(product01);
		products.add(product00);
		products.add(product01);
		products.add(product00);
		products.add(product01);
		products.add(product00);
		products.add(product01);
		products.add(product00);
		products.add(product01);
		products.add(product00);
		products.add(product00);
		products.add(product01);
		
		return products;
		*/
	}

	@Override
	public List<ProductTO> findProductsInternalSupplier(String productName,
			String category, double minPrice, double maxPrice) {
		return this.internalProviderService.findProducts(productName, category, minPrice, maxPrice);
		
	}

	@Override
	public List<ProductTO> findProductsEbaySupplier(String productName,
			String category, double minPrice, double maxPrice)
			throws ServiceException {

		String category2 = category;
		//String category2 = "175672"; //Ahora estan Laptops (hay que mapear)
		Date modTimeFrom = null;     //Ahora está a nulo para que vengan todos
		int size = 100;               //Falta ver como se obtine
		
		return this.ebayProviderService.findProducts(productName, category2, minPrice, maxPrice, size, modTimeFrom);
		
	}
}
