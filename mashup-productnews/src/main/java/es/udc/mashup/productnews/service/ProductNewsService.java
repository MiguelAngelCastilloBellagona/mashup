package es.udc.mashup.productnews.service;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;

import es.udc.mashup.productnews.entryprovider.EntryProviderFactory;

@WebService(name = "ProductNewsProvider", serviceName = "ProductNewsService", targetNamespace = "http://ws.adoo.udc.es/")
public class ProductNewsService {
	
	public ProductNewsService() {
	}

	@WebMethod(operationName = "lastProducts")
	public Document lastProducts() {

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
		@SuppressWarnings("unused")
		Element id = new Element("id").setText("PracticaADOO");
		//doc.getRootElement().addContent(id);
		
		List<Entry> entrys = EntryProviderFactory.getEntryProvider().getEntrys();
		
		Iterator<Entry> nombreIterator = entrys.iterator();
		while (nombreIterator.hasNext()) {
			Entry elemento = nombreIterator.next();
			Element entry = new Element("entry");
			entry.addContent(new Element("id").setText(elemento.getId()));
			entry.addContent(new Element("title").setText(elemento.getTitle()));
			//product.addContent(new Element("link").setAttribute("href", ""));
			entry.addContent(new Element("summary").setText(elemento.getSummary()));
			entry.addContent(new Element("updated").setText(elemento.getUpdated().toString()));

			doc.getRootElement().addContent(entry);
		}
		
		return doc;

	}
	

}
