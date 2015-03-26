package es.udc.mashup.ui.client.virtualstore;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface VirtualStoreServiceAsync {

    @SuppressWarnings("rawtypes")
	public void findProducts(String productName,
                             String category,
                             double minPrice,
                             double maxPrice,
                             AsyncCallback callback)
    throws InvalidSearchException;

    @SuppressWarnings("rawtypes")
	public void findCategories(AsyncCallback callback)
    throws InvalidSearchException;

}
