
package portafolio.gpvh.webservice;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "consultaControlAcceso", targetNamespace = "http://controldeacceso.portafolio.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ConsultaControlAcceso {


    /**
     * 
     * @param persona
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "generarPersona", targetNamespace = "http://controldeacceso.portafolio.com/", className = "portafolio.gpvh.webservice.GenerarPersona")
    @ResponseWrapper(localName = "generarPersonaResponse", targetNamespace = "http://controldeacceso.portafolio.com/", className = "portafolio.gpvh.webservice.GenerarPersonaResponse")
    @Action(input = "http://controldeacceso.portafolio.com/consultaControlAcceso/generarPersonaRequest", output = "http://controldeacceso.portafolio.com/consultaControlAcceso/generarPersonaResponse")
    public String generarPersona(
        @WebParam(name = "persona", targetNamespace = "")
        Persona persona);

    /**
     * 
     * @param persona
     * @param dia
     * @return
     *     returns java.util.List<portafolio.gpvh.webservice.Marcacion>
     */
    @WebMethod(operationName = "AsistenciaPorDia")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "AsistenciaPorDia", targetNamespace = "http://controldeacceso.portafolio.com/", className = "portafolio.gpvh.webservice.AsistenciaPorDia")
    @ResponseWrapper(localName = "AsistenciaPorDiaResponse", targetNamespace = "http://controldeacceso.portafolio.com/", className = "portafolio.gpvh.webservice.AsistenciaPorDiaResponse")
    @Action(input = "http://controldeacceso.portafolio.com/consultaControlAcceso/AsistenciaPorDiaRequest", output = "http://controldeacceso.portafolio.com/consultaControlAcceso/AsistenciaPorDiaResponse")
    public List<Marcacion> asistenciaPorDia(
        @WebParam(name = "persona", targetNamespace = "")
        Persona persona,
        @WebParam(name = "dia", targetNamespace = "")
        XMLGregorianCalendar dia);

    /**
     * 
     * @param persona
     * @return
     *     returns portafolio.gpvh.webservice.Persona
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "externalLogin", targetNamespace = "http://controldeacceso.portafolio.com/", className = "portafolio.gpvh.webservice.ExternalLogin")
    @ResponseWrapper(localName = "externalLoginResponse", targetNamespace = "http://controldeacceso.portafolio.com/", className = "portafolio.gpvh.webservice.ExternalLoginResponse")
    @Action(input = "http://controldeacceso.portafolio.com/consultaControlAcceso/externalLoginRequest", output = "http://controldeacceso.portafolio.com/consultaControlAcceso/externalLoginResponse")
    public Persona externalLogin(
        @WebParam(name = "persona", targetNamespace = "")
        Persona persona);

}