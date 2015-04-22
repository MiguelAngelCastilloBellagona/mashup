package es.udc.mashup.productprovider.internalprovider;

import java.util.ArrayList;
import java.util.List;

import es.udc.mashup.internalservice.wsdl.InternalProduct;
import es.udc.mashup.productprovider.Product;

public class TypeConversor {

	public static List<Product> toProductsTO(List<InternalProduct> internlaProducts) {
		List<Product> product = new ArrayList<Product>();
		if (internlaProducts!=null) for (InternalProduct l : internlaProducts) {
			product.add(toProduct(l));
		}
		return product;
	}
	
	public static Product toProduct(InternalProduct internlaProduct) {
		if (internlaProduct != null) {
			Product product = new Product();
			product.setCategory(internlaProduct.getCategory());
			product.setDate(internlaProduct.getDate().toGregorianCalendar().getTime());
			product.setDescription(internlaProduct.getDescription());
			product.setImageURL(internlaProduct.getImageURL());
			product.setName(internlaProduct.getName());
			product.setPrice(internlaProduct.getPrice());
			return product;
		} else {
			return null;
		}
	}
	
}
