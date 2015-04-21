package es.udc.mashup.internalserver;

import javax.xml.ws.WebFault;

@SuppressWarnings("serial")
@WebFault(
    name="IncorrectInternalSearchException",
    targetNamespace="http://ws.adoo.udc.es/"
)
public class IncorrectInternalSearchException extends Exception {

    private String exceptionInfo;

    public IncorrectInternalSearchException(String exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
    }
    
    public String getFaultInfo() {
        return exceptionInfo;
    }
    
}
