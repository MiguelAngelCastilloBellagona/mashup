package es.udc.mashup.virtualstore.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

import com.ebay.marketplace.search.v1.services.FindItemsAdvancedRequest;
import com.ebay.marketplace.search.v1.services.FindItemsAdvancedResponse;
import com.ebay.marketplace.search.v1.services.FindingService;
import com.ebay.marketplace.search.v1.services.FindingServicePortType;
import com.ebay.marketplace.search.v1.services.ItemFilter;
import com.ebay.marketplace.search.v1.services.ItemFilterType;
import com.ebay.marketplace.search.v1.services.OutputSelectorType;
import com.ebay.marketplace.search.v1.services.PaginationInput;
import com.ebay.marketplace.search.v1.services.SearchItem;
import com.ebay.marketplace.search.v1.services.SearchResult;
import com.ebay.marketplace.search.v1.services.SortOrderType;

import es.udc.mashup.virtualstore.service.ProductReviewTO;
import es.udc.mashup.virtualstore.service.ProductTO;
import es.udc.mashup.virtualstore.service.VirtualProductProviderService;
import es.udc.ws.util.exceptions.ServiceException;

public class MockVirtualProductProviderService implements
		VirtualProductProviderService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String APPID = "esudc4081-73b1-4e54-b06f-8a1f9221949";
	private static final String SERVICE_END_POINT = "http://svcs.ebay.com/services/search/FindingService/v1";
	private static final int TOTAL_EBAY_SEARCHS = 100;

	@Override
	public List<ProductTO> findProducts(String productName, String category,
			double minPrice, double maxPrice) throws ServiceException {
		
		/*
		String keywords2 = "Harry Potter";
		String category2 = "279";
		double minPrice2 = 10;
		double maxPrice2 = 20;
		Calendar c = Calendar.getInstance();
		c.add(Calendar.HOUR, -100000);
		@SuppressWarnings("unused")
		Date modTimeFrom = c.getTime();
		*/
		System.out.println(category);
		System.out.println(minPrice);
		System.out.println(maxPrice);
		String keywords2 = productName;
		//String category2 = "279";
		String category2 = "58058";
		double minPrice2 = minPrice;
		double maxPrice2 = maxPrice;
		Date modTimeFrom = null;
		
		return ebaySupplier(keywords2,category2,minPrice2,maxPrice2,modTimeFrom,25);

	}

	@Override
	public List<ProductTO> findProductsInternalSupplier(String productName,
			String category, double minPrice, double maxPrice) {
		// TODO Auto-generated method stub
		
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
	}

	@Override
	public List<ProductTO> findProductsEbaySupplier(String productName,
			String category, double minPrice, double maxPrice)
			throws ServiceException {

		return null;
		
	}

	public List<ProductTO> ebaySupplier(String keywords,String category,double minPrice, double maxPrice, Date modTimeFrom, int results) {
		
		int pagenumber = 1;
		int pageentries = results;
		
		List<ProductTO> products = new ArrayList<ProductTO>();
		
		String strBaseURL = SERVICE_END_POINT;
		FindingService service = new FindingService();
		FindingServicePortType port = service.getFindingServiceSOAPPort();

		BindingProvider bp = (BindingProvider) port;
		Map<String, Object> requestProperties = bp.getRequestContext();
		Map<String, List<String>> httpHeaders = new HashMap<String, List<String>>();
		// Set the headers
		httpHeaders.put("X-EBAY-SOA-MESSAGE-PROTOCOL",Collections.singletonList("SOAP12"));
		httpHeaders.put("X-EBAY-SOA-OPERATION-NAME",Collections.singletonList("findItemsAdvanced"));
		httpHeaders.put("X-EBAY-SOA-SECURITY-APPNAME",Collections.singletonList(APPID));
		httpHeaders.put("X-EBAY-SOA-GLOBAL-ID",Collections.singletonList("EBAY-ES"));

		requestProperties.put(MessageContext.HTTP_REQUEST_HEADERS, httpHeaders);
		requestProperties.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,strBaseURL);

		FindItemsAdvancedRequest req = new FindItemsAdvancedRequest();
		List<OutputSelectorType> opSelector = req.getOutputSelector();
		opSelector.add(OutputSelectorType.SELLER_INFO);

		List<ItemFilter> itemFilter = req.getItemFilter();
		
		ItemFilter objFilter1 = new ItemFilter();
		objFilter1.setName(ItemFilterType.AVAILABLE_TO);
		objFilter1.getValue().add("ES");
		itemFilter.add(objFilter1);
		
		ItemFilter objFilter2 = new ItemFilter();
		objFilter2.setName(ItemFilterType.LISTING_TYPE);
		objFilter2.getValue().add("AuctionWithBIN");
		objFilter2.getValue().add("FixedPrice");
		objFilter2.getValue().add("StoreInventory");
		itemFilter.add(objFilter2);
		
		ItemFilter objFilter3 = new ItemFilter();
		objFilter3.setName(ItemFilterType.HIDE_DUPLICATE_ITEMS);
		objFilter3.getValue().add("true");
		itemFilter.add(objFilter3);
		
		ItemFilter objFilter4 = new ItemFilter();
		objFilter4.setName(ItemFilterType.CURRENCY);
		objFilter4.getValue().add("EUR");
		itemFilter.add(objFilter4);
		
		if (minPrice > 0) {
			ItemFilter minPriceFilter = new ItemFilter();
			minPriceFilter.setName(ItemFilterType.MIN_PRICE);
			minPriceFilter.getValue().add(Double.toString(minPrice));
			itemFilter.add(minPriceFilter);
		}
		
		if (maxPrice > 0 && maxPrice < Integer.MAX_VALUE) {
			ItemFilter maxPriceFilter = new ItemFilter();
			maxPriceFilter.setName(ItemFilterType.MAX_PRICE);
			maxPriceFilter.getValue().add(Double.toString(maxPrice));
			itemFilter.add(maxPriceFilter);
		}
		
		if (modTimeFrom != null) {	
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSS'Z'");
			ItemFilter modTimeFromFilter = new ItemFilter();
			modTimeFromFilter.setName(ItemFilterType.MOD_TIME_FROM);
			modTimeFromFilter.getValue().add(dateFormat.format(modTimeFrom));
			itemFilter.add(modTimeFromFilter);
		}

		req.setSortOrder(SortOrderType.END_TIME_SOONEST);
		req.setKeywords(keywords);
		
		PaginationInput paginationInput = new PaginationInput();
		paginationInput.setPageNumber(pagenumber);
		paginationInput.setEntriesPerPage(pageentries);
		req.setPaginationInput(paginationInput);
		
		List<String> catID = req.getCategoryId();
		catID.add(category);

		FindItemsAdvancedResponse res = port.findItemsAdvanced(req);
		SearchResult searchResult = res.getSearchResult();
		List<SearchItem> items = searchResult.getItem();

		for (int i = 0; i < items.size(); i++) {
			SearchItem aItem = items.get(i);
			
			ProductTO product = new ProductTO();

			product.setCategory(aItem.getPrimaryCategory().getCategoryName());
			product.setName(aItem.getTitle());
			product.setPrice(aItem.getSellingStatus().getConvertedCurrentPrice().getValue());
			product.setDate(aItem.getListingInfo().getEndTime().toGregorianCalendar().getTime());
			product.setDescription(null); //FIXME
			product.setImageURL(aItem.getGalleryURL());
			
			products.add(product);
			
		}	
		return products;
	}

}
