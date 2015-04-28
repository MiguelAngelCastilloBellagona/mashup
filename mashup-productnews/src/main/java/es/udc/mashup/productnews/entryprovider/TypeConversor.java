package es.udc.mashup.productnews.entryprovider;

import java.util.ArrayList;
import java.util.List;

import es.udc.mashup.productnews.service.Entry;
import es.udc.mashup.virtualstore.service.ProductTO;

public class TypeConversor {
	
	public static List<Entry> toEntrys(List<ProductTO> products) {
		List<Entry> entrys = new ArrayList<Entry>();
		if (products!=null) for (ProductTO l : products) {
			entrys.add(toEntry(l));
		}
		return entrys;
	}
	
	public static Entry toEntry(ProductTO product) {
		if (product != null) {
			Entry entry = new Entry();
			entry.setId(product.getName());
			entry.setTitle(product.getName());
			String summary = product.getPrice() + " - " + product.getCategory() + " - " + product.getDescription();
			entry.setSummary(summary);
			entry.setUpdated(product.getDate());
			return entry;
		} else {
			return null;
		}
	}

}
