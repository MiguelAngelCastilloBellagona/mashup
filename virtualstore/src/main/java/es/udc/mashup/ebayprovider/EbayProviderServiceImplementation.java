package es.udc.mashup.ebayprovider;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

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

import es.udc.mashup.virtualstore.service.ProductTO;
import es.udc.ws.util.exceptions.ServiceException;

public class EbayProviderServiceImplementation implements EbayProviderService {

	private static final long serialVersionUID = 1L;

	private static final String APPID = "esudc4081-73b1-4e54-b06f-8a1f9221949";
	private static final String SERVICE_END_POINT = "http://svcs.ebay.com/services/search/FindingService/v1";
	
	private static Properties properties;
	
	static {
		try {
			properties = new Properties();
			InputStream inputStream = EbayProviderService.class.getClassLoader().getResourceAsStream("CategoryMapper.properties");
			properties.load(inputStream);
		} catch (IOException e) {
			throw new RuntimeException("Could not read config file: " + e.getMessage());
		}
	}
	
	@Override
	public List<ProductTO> findProducts(String keywords, String category,
			double minPrice, double maxPrice, int size, Date modTimeFrom) throws ServiceException {

		int pagenumber = 1;
		int pageentries = size;
		
		category = categoryMapper(category);
		
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
	
	private String categoryMapper(String category) {
		try {
			return properties.getProperty(category);
		}
		catch(NullPointerException e)
		{
			return null;
		}
	}

}
