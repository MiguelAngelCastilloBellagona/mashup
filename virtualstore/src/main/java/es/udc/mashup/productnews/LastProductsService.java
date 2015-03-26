package es.udc.mashup.productnews;

import java.io.Serializable;
import java.util.List;

import org.jdom.Document;

import es.udc.mashup.virtualstore.service.ProductTO;

public interface LastProductsService extends Serializable {
	
	public Document lastProducts(List<ProductTO> lista);

}
