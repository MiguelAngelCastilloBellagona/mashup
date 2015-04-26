package es.udc.mashup.productnews.entryprovider;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import es.udc.mashup.productnews.service.Entry;
import es.udc.mashup.virtualstore.service.ProductTO;
import es.udc.mashup.virtualstore.service.VirtualProductProviderService;
import es.udc.mashup.virtualstore.service.VirtualProductProviderServiceFactory;

public class EntryProviderImpl implements EntryProvider{
	
	private VirtualProductProviderService getRealService() {
		return VirtualProductProviderServiceFactory.getVirtualProviderService();
	}

	@Override
	public List<Entry> getEntrys() {
		Date minDate = Calendar.getInstance().getTime();
		String category = "Laptops";
		List<ProductTO> products = getRealService().findProductsBetweenDates(null, category, 0, 0, minDate, null);
		return TypeConversor.toEntrys(products);

	}

}
