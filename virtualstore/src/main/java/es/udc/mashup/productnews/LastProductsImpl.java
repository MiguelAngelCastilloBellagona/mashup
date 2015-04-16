package es.udc.mashup.productnews;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.jdom.Attribute;
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

		Element products = new Element("feed");
		Attribute attr1 = new Attribute("xmlns", "http://www.w3.org/2005/Atom");
        products.setAttribute(attr1);
		Document doc = new Document(products);
		doc.setRootElement(products);
		Element title = new Element("title").setText("Last products");
		doc.getRootElement().addContent(title);
		Element link = new Element("link");
		Attribute attr2 = new Attribute("href", "http://www.acme.com/lastproducts.atom");
        products.setAttribute(attr2);
		doc.getRootElement().addContent(link);
		Element subtitle = new Element("subtitle").setText("Products added in the last 24 hours");
		doc.getRootElement().addContent(subtitle);
		Element updated = new Element("updated").setText(Calendar.getInstance().getTime().toString());
		doc.getRootElement().addContent(updated);
		Element id = new Element("id").setText("PracticaADOO");
		//doc.getRootElement().addContent(id);

		Iterator<ProductTO> nombreIterator = lista.iterator();
		while (nombreIterator.hasNext()) {
			ProductTO elemento = nombreIterator.next();

			if (elemento.getDate().after(timelimit)) 
			{
				Element product = new Element("entry");
				product.addContent(new Element("title").setText(elemento.getName()));
				//product.addContent(new Element("id").setText(elemento.getName()));
				//product.addContent(new Element("link").setAttribute("href", ""));
				String summary = elemento.getDescription() + " - " + elemento.getPrice() + " - " + elemento.getCategory();
				product.addContent(new Element("summary").setText(summary));
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