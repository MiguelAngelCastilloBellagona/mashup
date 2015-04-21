
package es.udc.ws.jaxwstutorial.wsdl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the es.udc.ws.jaxwstutorial.wsdl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetLastTradePrices_QNAME = new QName("http://ws.adoo.udc.es/", "getLastTradePrices");
    private final static QName _IncorrectInternalSearchException_QNAME = new QName("http://ws.adoo.udc.es/", "IncorrectInternalSearchException");
    private final static QName _GetLastTradePricesResponse_QNAME = new QName("http://ws.adoo.udc.es/", "getLastTradePricesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: es.udc.ws.jaxwstutorial.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetLastTradePrices }
     * 
     */
    public GetLastTradePrices createGetLastTradePrices() {
        return new GetLastTradePrices();
    }

    /**
     * Create an instance of {@link GetLastTradePricesResponse }
     * 
     */
    public GetLastTradePricesResponse createGetLastTradePricesResponse() {
        return new GetLastTradePricesResponse();
    }

    /**
     * Create an instance of {@link InternalProduct }
     * 
     */
    public InternalProduct createInternalProduct() {
        return new InternalProduct();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastTradePrices }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.adoo.udc.es/", name = "getLastTradePrices")
    public JAXBElement<GetLastTradePrices> createGetLastTradePrices(GetLastTradePrices value) {
        return new JAXBElement<GetLastTradePrices>(_GetLastTradePrices_QNAME, GetLastTradePrices.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.adoo.udc.es/", name = "IncorrectInternalSearchException")
    public JAXBElement<String> createIncorrectInternalSearchException(String value) {
        return new JAXBElement<String>(_IncorrectInternalSearchException_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastTradePricesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.adoo.udc.es/", name = "getLastTradePricesResponse")
    public JAXBElement<GetLastTradePricesResponse> createGetLastTradePricesResponse(GetLastTradePricesResponse value) {
        return new JAXBElement<GetLastTradePricesResponse>(_GetLastTradePricesResponse_QNAME, GetLastTradePricesResponse.class, null, value);
    }

}
