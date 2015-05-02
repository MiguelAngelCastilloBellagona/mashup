
package es.udc.mashup.internalservice.wsdl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the es.udc.mashup.internalservice.wsdl package. 
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

    private final static QName _SearchProductsBetweenDatesResponse_QNAME = new QName("http://ws.adoo.udc.es/", "searchProductsBetweenDatesResponse");
    private final static QName _SearchProducts_QNAME = new QName("http://ws.adoo.udc.es/", "searchProducts");
    private final static QName _SearchProductsResponse_QNAME = new QName("http://ws.adoo.udc.es/", "searchProductsResponse");
    private final static QName _IncorrectInternalSearchException_QNAME = new QName("http://ws.adoo.udc.es/", "IncorrectInternalSearchException");
    private final static QName _SearchProductsBetweenDates_QNAME = new QName("http://ws.adoo.udc.es/", "searchProductsBetweenDates");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: es.udc.mashup.internalservice.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SearchProducts }
     * 
     */
    public SearchProducts createSearchProducts() {
        return new SearchProducts();
    }

    /**
     * Create an instance of {@link SearchProductsResponse }
     * 
     */
    public SearchProductsResponse createSearchProductsResponse() {
        return new SearchProductsResponse();
    }

    /**
     * Create an instance of {@link SearchProductsBetweenDates }
     * 
     */
    public SearchProductsBetweenDates createSearchProductsBetweenDates() {
        return new SearchProductsBetweenDates();
    }

    /**
     * Create an instance of {@link SearchProductsBetweenDatesResponse }
     * 
     */
    public SearchProductsBetweenDatesResponse createSearchProductsBetweenDatesResponse() {
        return new SearchProductsBetweenDatesResponse();
    }

    /**
     * Create an instance of {@link InternalProductOutput }
     * 
     */
    public InternalProductOutput createInternalProductOutput() {
        return new InternalProductOutput();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchProductsBetweenDatesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.adoo.udc.es/", name = "searchProductsBetweenDatesResponse")
    public JAXBElement<SearchProductsBetweenDatesResponse> createSearchProductsBetweenDatesResponse(SearchProductsBetweenDatesResponse value) {
        return new JAXBElement<SearchProductsBetweenDatesResponse>(_SearchProductsBetweenDatesResponse_QNAME, SearchProductsBetweenDatesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchProducts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.adoo.udc.es/", name = "searchProducts")
    public JAXBElement<SearchProducts> createSearchProducts(SearchProducts value) {
        return new JAXBElement<SearchProducts>(_SearchProducts_QNAME, SearchProducts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchProductsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.adoo.udc.es/", name = "searchProductsResponse")
    public JAXBElement<SearchProductsResponse> createSearchProductsResponse(SearchProductsResponse value) {
        return new JAXBElement<SearchProductsResponse>(_SearchProductsResponse_QNAME, SearchProductsResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchProductsBetweenDates }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.adoo.udc.es/", name = "searchProductsBetweenDates")
    public JAXBElement<SearchProductsBetweenDates> createSearchProductsBetweenDates(SearchProductsBetweenDates value) {
        return new JAXBElement<SearchProductsBetweenDates>(_SearchProductsBetweenDates_QNAME, SearchProductsBetweenDates.class, null, value);
    }

}
