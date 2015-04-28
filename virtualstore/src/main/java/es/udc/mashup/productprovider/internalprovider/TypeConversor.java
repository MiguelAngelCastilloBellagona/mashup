package es.udc.mashup.productprovider.internalprovider;

import java.util.ArrayList;
import java.util.List;

import es.udc.mashup.internalservice.wsdl.InternalProductOutput;
import es.udc.mashup.productprovider.Product;

public class TypeConversor {

	public static List<Product> toProductsTO(List<InternalProductOutput> internalProductOutputs) {
		List<Product> product = new ArrayList<Product>();
		if (internalProductOutputs!=null) for (InternalProductOutput l : internalProductOutputs) {
			product.add(toProduct(l));
		}
		return product;
	}
	
	public static Product toProduct(InternalProductOutput internalProductOutput) {
		if (internalProductOutput != null) {
			Product product = new Product();
			product.setCategory(internalProductOutput.getCategory());
			product.setDate(internalProductOutput.getDate().toGregorianCalendar().getTime());
			product.setDescription(internalProductOutput.getDescription());
			product.setImageURL(internalProductOutput.getImageURL());
			product.setName(internalProductOutput.getName());
			product.setPrice(internalProductOutput.getPrice()-internalProductOutput.getDescuento());
			return product;
		} else {
			return null;
		}
	}
	
}
