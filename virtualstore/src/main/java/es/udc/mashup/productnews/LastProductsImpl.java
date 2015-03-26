package es.udc.mashup.productnews;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;

import es.udc.mashup.virtualstore.service.ProductTO;

public class LastProductsImpl implements LastProductsService {

	private static final long serialVersionUID = 1L;

	@Override
	public Document lastProducts(List<ProductTO> lista) {

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		
		Date timelimit = cal.getTime();

		Element products = new Element("products");
		Document doc = new Document(products);
		doc.setRootElement(products);

		Iterator<ProductTO> nombreIterator = lista.iterator();
		while (nombreIterator.hasNext()) {
			ProductTO elemento = nombreIterator.next();

			if (elemento.getDate().after(timelimit)) 
			{
				Element product = new Element("product");
				product.addContent(new Element("title").setText(elemento.getName()));
				product.addContent(new Element("summary").setText(elemento.getDescription()));
				product.addContent(new Element("updated").setText(elemento.getDate().toString()));

				doc.getRootElement().addContent(product);
			}
			else
			{
				lista.remove(elemento);
			}
			
		}

		return doc;
	}
}