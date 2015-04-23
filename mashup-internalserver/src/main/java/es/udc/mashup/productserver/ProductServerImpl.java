package es.udc.mashup.productserver;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import es.udc.ws.util.exceptions.ServiceException;

public class ProductServerImpl implements ProductServer {

	List<InternalProduct> list;

	protected ProductServerImpl() {
		this.list = new ArrayList<InternalProduct>();

		this.addProducts("Publicacion 1", "Descripcion 1", "Laptops", 200, 10, null);
		this.addProducts("Primera publicación", "Descripcion 2", "Laptops", 400, 20, null);
	}

	@Override
	public List<InternalProduct> findProducts(String keywords, String category, double minPrice, double maxPrice, int size, Date minDate,
			Date maxDate) throws ServiceException {

		List<InternalProduct> l = new ArrayList<InternalProduct>();
/*
		for (InternalProduct ip : this.list) {
			if (ip.getCategory().equalsIgnoreCase(category)) {
				if (ip.getPrice() <= maxPrice) {
					if (ip.getPrice() >= minPrice) {
						if (minDate == null) {
							if (maxDate == null)
								l.add(ip);
							else if (ip.getDate().before(maxDate))
								l.add(ip);
						}
						if (maxDate == null) {
							if (ip.getDate().after(minDate))
								l.add(ip);
						}
					}
				}
			}
		}
*/

		l = this.list;
		return l;
	}

	@Override
	public void addProducts(String productName, String description, String category, double price, double descuento, String imageURL) {
		InternalProduct ip = new InternalProduct();
		ip.setCategory(category);
		ip.setDate(Calendar.getInstance().getTime());
		ip.setDescription(description);
		ip.setDescuento(descuento);
		ip.setImageURL(imageURL);
		ip.setName(productName);
		ip.setPrice(price);

		this.list.add(ip);

	}

}
