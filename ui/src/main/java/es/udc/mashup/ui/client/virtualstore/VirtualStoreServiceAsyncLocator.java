package es.udc.mashup.ui.client.virtualstore;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public class VirtualStoreServiceAsyncLocator {

    private final static String SERVICE_URL_SUFFIX = "VirtualStoreService";

    private VirtualStoreServiceAsyncLocator() {
    }

    public static VirtualStoreServiceAsync getVirtualStoreServiceAsync() {
        VirtualStoreServiceAsync service =
                (VirtualStoreServiceAsync) GWT.create(VirtualStoreService.class);
        ServiceDefTarget endpoint = (ServiceDefTarget) service;
        String serviceURL = GWT.getModuleBaseURL() + SERVICE_URL_SUFFIX;
        endpoint.setServiceEntryPoint(serviceURL);
        return service;
    }
}
