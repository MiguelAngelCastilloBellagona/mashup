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
		Date maxDate = Calendar.getInstance().getTime();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		Date minDate = cal.getTime();
		String category = "Laptops";
		List<ProductTO> products = getRealService().findProductsBetweenDates(null, category, 0, 0, minDate, maxDate);
		return TypeConversor.toEntrys(products);

	}

}
