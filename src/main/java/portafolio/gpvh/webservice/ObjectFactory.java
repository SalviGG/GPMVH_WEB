
package portafolio.gpvh.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the portafolio.gpvh.webservice package. 
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

    private final static QName _AsistenciaPorDiaResponse_QNAME = new QName("http://controldeacceso.portafolio.com/", "AsistenciaPorDiaResponse");
    private final static QName _GenerarPersonaResponse_QNAME = new QName("http://controldeacceso.portafolio.com/", "generarPersonaResponse");
    private final static QName _ExternalLogin_QNAME = new QName("http://controldeacceso.portafolio.com/", "externalLogin");
    private final static QName _ExternalLoginResponse_QNAME = new QName("http://controldeacceso.portafolio.com/", "externalLoginResponse");
    private final static QName _AsistenciaPorDia_QNAME = new QName("http://controldeacceso.portafolio.com/", "AsistenciaPorDia");
    private final static QName _GenerarPersona_QNAME = new QName("http://controldeacceso.portafolio.com/", "generarPersona");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: portafolio.gpvh.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GenerarPersona }
     * 
     */
    public GenerarPersona createGenerarPersona() {
        return new GenerarPersona();
    }

    /**
     * Create an instance of {@link ExternalLoginResponse }
     * 
     */
    public ExternalLoginResponse createExternalLoginResponse() {
        return new ExternalLoginResponse();
    }

    /**
     * Create an instance of {@link ExternalLogin }
     * 
     */
    public ExternalLogin createExternalLogin() {
        return new ExternalLogin();
    }

    /**
     * Create an instance of {@link AsistenciaPorDia }
     * 
     */
    public AsistenciaPorDia createAsistenciaPorDia() {
        return new AsistenciaPorDia();
    }

    /**
     * Create an instance of {@link AsistenciaPorDiaResponse }
     * 
     */
    public AsistenciaPorDiaResponse createAsistenciaPorDiaResponse() {
        return new AsistenciaPorDiaResponse();
    }

    /**
     * Create an instance of {@link GenerarPersonaResponse }
     * 
     */
    public GenerarPersonaResponse createGenerarPersonaResponse() {
        return new GenerarPersonaResponse();
    }

    /**
     * Create an instance of {@link Marcacion }
     * 
     */
    public Marcacion createMarcacion() {
        return new Marcacion();
    }

    /**
     * Create an instance of {@link Persona }
     * 
     */
    public Persona createPersona() {
        return new Persona();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AsistenciaPorDiaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controldeacceso.portafolio.com/", name = "AsistenciaPorDiaResponse")
    public JAXBElement<AsistenciaPorDiaResponse> createAsistenciaPorDiaResponse(AsistenciaPorDiaResponse value) {
        return new JAXBElement<AsistenciaPorDiaResponse>(_AsistenciaPorDiaResponse_QNAME, AsistenciaPorDiaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarPersonaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controldeacceso.portafolio.com/", name = "generarPersonaResponse")
    public JAXBElement<GenerarPersonaResponse> createGenerarPersonaResponse(GenerarPersonaResponse value) {
        return new JAXBElement<GenerarPersonaResponse>(_GenerarPersonaResponse_QNAME, GenerarPersonaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExternalLogin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controldeacceso.portafolio.com/", name = "externalLogin")
    public JAXBElement<ExternalLogin> createExternalLogin(ExternalLogin value) {
        return new JAXBElement<ExternalLogin>(_ExternalLogin_QNAME, ExternalLogin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExternalLoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controldeacceso.portafolio.com/", name = "externalLoginResponse")
    public JAXBElement<ExternalLoginResponse> createExternalLoginResponse(ExternalLoginResponse value) {
        return new JAXBElement<ExternalLoginResponse>(_ExternalLoginResponse_QNAME, ExternalLoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AsistenciaPorDia }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controldeacceso.portafolio.com/", name = "AsistenciaPorDia")
    public JAXBElement<AsistenciaPorDia> createAsistenciaPorDia(AsistenciaPorDia value) {
        return new JAXBElement<AsistenciaPorDia>(_AsistenciaPorDia_QNAME, AsistenciaPorDia.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarPersona }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controldeacceso.portafolio.com/", name = "generarPersona")
    public JAXBElement<GenerarPersona> createGenerarPersona(GenerarPersona value) {
        return new JAXBElement<GenerarPersona>(_GenerarPersona_QNAME, GenerarPersona.class, null, value);
    }

}
