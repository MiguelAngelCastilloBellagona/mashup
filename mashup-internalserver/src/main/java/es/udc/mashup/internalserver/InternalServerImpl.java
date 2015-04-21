package es.udc.mashup.internalserver;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@WebService(
    name="InternalServerProvider",
    serviceName="InternalServerService",
    targetNamespace="http://ws.adoo.udc.es/"
)
public class InternalServerImpl {

    Log logger = LogFactory.getLog(InternalServerImpl.class);


    @PostConstruct()
    private void init() {

    }
    
    public InternalServerImpl() {
    }

    @WebMethod(
        operationName="getLastTradePrices"
    )
    public List<InternalProduct> getLastTradePrices(List<String> tickerSymbols) throws IncorrectInternalSearchException {

        
        return null;
        
    }

}
