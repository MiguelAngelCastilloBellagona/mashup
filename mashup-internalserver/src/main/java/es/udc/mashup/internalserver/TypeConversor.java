package es.udc.mashup.internalserver;

import java.util.ArrayList;
import java.util.List;

import es.udc.mashup.productserver.InternalProduct;

public class TypeConversor {

	public static List<InternalProductOutput> toInternalProductOutputs(List<InternalProduct> products) {
		List<InternalProductOutput> productTOs = new ArrayList<InternalProductOutput>();
		if (products!=null) for (InternalProduct l : products) {
			productTOs.add(toInternalProductOutput(l));
		}
		return productTOs;
	}
	
	public static InternalProductOutput toInternalProductOutput(InternalProduct product) {
		if (product != null) {
			InternalProductOutput internalProductOutput = new InternalProductOutput();
			internalProductOutput.setCategory(product.getCategory());
			internalProductOutput.setDate(product.getDate());
			internalProductOutput.setDescription(product.getDescription());
			internalProductOutput.setImageURL(product.getImageURL());
			internalProductOutput.setName(product.getName());
			internalProductOutput.setPrice(product.getPrice());
			return internalProductOutput;
		} else {
			return null;
		}
	}

}
