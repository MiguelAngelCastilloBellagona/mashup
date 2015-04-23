package es.udc.mashup.productprovider.internalprovider;

import java.util.ArrayList;
import java.util.List;

import es.udc.mashup.internalservice.wsdl.InternalProduct;
import es.udc.mashup.productprovider.Product;

public class TypeConversor {

	public static List<Product> toProductsTO(List<InternalProduct> internalProducts) {
		List<Product> product = new ArrayList<Product>();
		if (internalProducts!=null) for (InternalProduct l : internalProducts) {
			product.add(toProduct(l));
		}
		return product;
	}
	
	public static Product toProduct(InternalProduct internalProduct) {
		if (internalProduct != null) {
			Product product = new Product();
			product.setCategory(internalProduct.getCategory());
			product.setDate(internalProduct.getDate().toGregorianCalendar().getTime());
			product.setDescription(internalProduct.getDescription());
			product.setImageURL(internalProduct.getImageURL());
			product.setName(internalProduct.getName());
			product.setPrice(internalProduct.getPrice()-internalProduct.getDescuento());
			return product;
		} else {
			return null;
		}
	}
	
}
