
package webservice.filtermail;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice.filtermail package. 
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

    private final static QName _EnableFilterResponse_QNAME = new QName("http://filtermail.webservice/", "enableFilterResponse");
    private final static QName _EnableMonthFilterResponse_QNAME = new QName("http://filtermail.webservice/", "enableMonthFilterResponse");
    private final static QName _Exception_QNAME = new QName("http://filtermail.webservice/", "Exception");
    private final static QName _EnableFilter_QNAME = new QName("http://filtermail.webservice/", "enableFilter");
    private final static QName _EnableDomainFilter_QNAME = new QName("http://filtermail.webservice/", "enableDomainFilter");
    private final static QName _EnableMonthFilter_QNAME = new QName("http://filtermail.webservice/", "enableMonthFilter");
    private final static QName _EnableSubjectFilterResponse_QNAME = new QName("http://filtermail.webservice/", "enableSubjectFilterResponse");
    private final static QName _EnableDomainFilterResponse_QNAME = new QName("http://filtermail.webservice/", "enableDomainFilterResponse");
    private final static QName _EnableSubjectFilter_QNAME = new QName("http://filtermail.webservice/", "enableSubjectFilter");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice.filtermail
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EnableDomainFilterResponse }
     * 
     */
    public EnableDomainFilterResponse createEnableDomainFilterResponse() {
        return new EnableDomainFilterResponse();
    }

    /**
     * Create an instance of {@link EnableSubjectFilter }
     * 
     */
    public EnableSubjectFilter createEnableSubjectFilter() {
        return new EnableSubjectFilter();
    }

    /**
     * Create an instance of {@link EnableMonthFilter }
     * 
     */
    public EnableMonthFilter createEnableMonthFilter() {
        return new EnableMonthFilter();
    }

    /**
     * Create an instance of {@link EnableSubjectFilterResponse }
     * 
     */
    public EnableSubjectFilterResponse createEnableSubjectFilterResponse() {
        return new EnableSubjectFilterResponse();
    }

    /**
     * Create an instance of {@link EnableFilter }
     * 
     */
    public EnableFilter createEnableFilter() {
        return new EnableFilter();
    }

    /**
     * Create an instance of {@link EnableDomainFilter }
     * 
     */
    public EnableDomainFilter createEnableDomainFilter() {
        return new EnableDomainFilter();
    }

    /**
     * Create an instance of {@link EnableFilterResponse }
     * 
     */
    public EnableFilterResponse createEnableFilterResponse() {
        return new EnableFilterResponse();
    }

    /**
     * Create an instance of {@link EnableMonthFilterResponse }
     * 
     */
    public EnableMonthFilterResponse createEnableMonthFilterResponse() {
        return new EnableMonthFilterResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnableFilterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://filtermail.webservice/", name = "enableFilterResponse")
    public JAXBElement<EnableFilterResponse> createEnableFilterResponse(EnableFilterResponse value) {
        return new JAXBElement<EnableFilterResponse>(_EnableFilterResponse_QNAME, EnableFilterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnableMonthFilterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://filtermail.webservice/", name = "enableMonthFilterResponse")
    public JAXBElement<EnableMonthFilterResponse> createEnableMonthFilterResponse(EnableMonthFilterResponse value) {
        return new JAXBElement<EnableMonthFilterResponse>(_EnableMonthFilterResponse_QNAME, EnableMonthFilterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://filtermail.webservice/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnableFilter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://filtermail.webservice/", name = "enableFilter")
    public JAXBElement<EnableFilter> createEnableFilter(EnableFilter value) {
        return new JAXBElement<EnableFilter>(_EnableFilter_QNAME, EnableFilter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnableDomainFilter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://filtermail.webservice/", name = "enableDomainFilter")
    public JAXBElement<EnableDomainFilter> createEnableDomainFilter(EnableDomainFilter value) {
        return new JAXBElement<EnableDomainFilter>(_EnableDomainFilter_QNAME, EnableDomainFilter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnableMonthFilter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://filtermail.webservice/", name = "enableMonthFilter")
    public JAXBElement<EnableMonthFilter> createEnableMonthFilter(EnableMonthFilter value) {
        return new JAXBElement<EnableMonthFilter>(_EnableMonthFilter_QNAME, EnableMonthFilter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnableSubjectFilterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://filtermail.webservice/", name = "enableSubjectFilterResponse")
    public JAXBElement<EnableSubjectFilterResponse> createEnableSubjectFilterResponse(EnableSubjectFilterResponse value) {
        return new JAXBElement<EnableSubjectFilterResponse>(_EnableSubjectFilterResponse_QNAME, EnableSubjectFilterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnableDomainFilterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://filtermail.webservice/", name = "enableDomainFilterResponse")
    public JAXBElement<EnableDomainFilterResponse> createEnableDomainFilterResponse(EnableDomainFilterResponse value) {
        return new JAXBElement<EnableDomainFilterResponse>(_EnableDomainFilterResponse_QNAME, EnableDomainFilterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnableSubjectFilter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://filtermail.webservice/", name = "enableSubjectFilter")
    public JAXBElement<EnableSubjectFilter> createEnableSubjectFilter(EnableSubjectFilter value) {
        return new JAXBElement<EnableSubjectFilter>(_EnableSubjectFilter_QNAME, EnableSubjectFilter.class, null, value);
    }

}
