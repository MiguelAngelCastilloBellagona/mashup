package es.udc.mashup.ui.client.virtualstore;

import com.google.gwt.user.client.rpc.RemoteService;
import java.util.List;

public interface VirtualStoreService extends RemoteService {

    public List<ProductJTO> findProducts(String productName,
                                         String category,
                                         double minPrice,
                                         double maxPrice)
            throws InvalidSearchException;

    public List<String> findCategories()
            throws InvalidSearchException;

}
