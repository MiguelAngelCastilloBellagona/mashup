package es.udc.mashup.productnews.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import es.udc.mashup.productnews.entryprovider.EntryProviderFactory;

public class ProductNewsService extends HttpServlet {


	private static final long serialVersionUID = 2433463494776809410L;

	public ProductNewsService() {
	}

	public Document lastProducts() {

		Element products = new Element("feed");
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
		// doc.getRootElement().addContent(id);

		List<Entry> entrys = EntryProviderFactory.getEntryProvider().getEntrys();

		Iterator<Entry> nombreIterator = entrys.iterator();
		while (nombreIterator.hasNext()) {
			Entry elemento = nombreIterator.next();
			Element entry = new Element("entry");
			entry.addContent(new Element("id").setText(elemento.getId()));
			entry.addContent(new Element("title").setText(elemento.getTitle()));
			// product.addContent(new Element("link").setAttribute("href", ""));
			entry.addContent(new Element("summary").setText(elemento.getSummary()));
			if(elemento.getUpdated()!=null) entry.addContent(new Element("updated").setText(elemento.getUpdated().toString()));
			else entry.addContent(new Element("updated").setText("ERROR"));

			doc.getRootElement().addContent(entry);
		}

		return doc;

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type
		response.setContentType("application/xml");

		// Actual logic goes here.
		PrintWriter out = response.getWriter();
		XMLOutputter xml = new XMLOutputter();
		xml.setFormat(Format.getPrettyFormat());
		out.println(xml.outputString(lastProducts()));
	}

}
