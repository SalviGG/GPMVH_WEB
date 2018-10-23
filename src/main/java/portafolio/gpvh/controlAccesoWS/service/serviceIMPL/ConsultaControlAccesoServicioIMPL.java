package portafolio.gpvh.controlAccesoWS.service.serviceIMPL;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import portafolio.gpvh.controlAccesoWS.service.ConsultaControlAccesoServicio;
import portafolio.gpvh.controlAccesoWS.mappingWsl.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class ConsultaControlAccesoServicioIMPL implements ConsultaControlAccesoServicio {

    private ConsultaControlAcceso getPort(){

        ConsultaControlAcceso_Service service = new ConsultaControlAcceso_Service();
        return service.getConsultaControlAccesoPort();
    }

    private XMLGregorianCalendar dateToXMLGregorianCalendar(Date date){
        GregorianCalendar gCalendar = new GregorianCalendar();
        gCalendar.setTime(date);
        XMLGregorianCalendar xmlGregorianCalendar = null;

        try {
            xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return xmlGregorianCalendar;
    }

    @Override
    public Persona externalLogin(int rut, String password) {
        password  = DigestUtils.md5Hex(password);
        Persona persona = new Persona();
        persona.setRut(rut);
        persona.setPass(password);
        Persona personaResultado = getPort().externalLogin(persona);
        return personaResultado;
    }

    @Override
    public List<Marcacion> asistenciaPorDia(Persona persona, Date dia) {
        return getPort().asistenciaPorDia(persona,dateToXMLGregorianCalendar(dia));
    }

    @Override
    public List<Marcacion> asistenciaPorDia(int rut, Date dia) {
        Persona persona = new Persona();
        persona.setRut(rut);
        return this.asistenciaPorDia(persona,dia);
    }

    @Override
    public List<Marcacion> asistenciaPorRangoFecha(Persona persona, Date desde, Date hasta) {

        return getPort().asistenciaPorRangoDeFecha(persona,dateToXMLGregorianCalendar(desde),dateToXMLGregorianCalendar(hasta));
    }

    @Override
    public List<Marcacion> asistenciaPorRangoFecha(int rut, Date desde, Date hasta) {
        Persona persona = new Persona();
        persona.setRut(rut);
        return this.asistenciaPorRangoFecha(persona,desde,hasta);
    }

    private List<Persona> busquedaPersonas(int fragmentoRut, String fragmentoNombre ,int cantidad){
        return getPort().busquedaPersonas(fragmentoRut,fragmentoNombre,cantidad);
    }

    @Override
    public List<Persona> busquedaPersonas(int fragmentoRut) {

        return this.busquedaPersonas(fragmentoRut,null,0);
    }

    @Override
    public List<Persona> busquedaPersonas(int fragmentoRut, int cantidad) {

        return this.busquedaPersonas(fragmentoRut,null,cantidad);
    }

    @Override
    public List<Persona> busquedaPersonas(String FragmentoNombre) {
        return this.busquedaPersonas(0,FragmentoNombre,0);
    }

    @Override
    public List<Persona> busquedaPersonas(String FragmentoNombre, int cantidad) {
        return this.busquedaPersonas(0,FragmentoNombre,cantidad);
    }

    @Override
    public Persona consumirHoras(Persona persona, int horas) {
        return getPort().consumirHorasCompesadas(persona,horas);
    }

    @Override
    public Persona consumirHoras(int rut, int horas) {
        Persona persona = new Persona();
        persona.setRut(rut);
        return this.consumirHoras(persona,horas);
    }

    @Override
    public Persona devolverHoras(Persona persona, int horas) {
        return getPort().devolverHorasCompesadas(persona,horas);
    }

    @Override
    public Persona devolverHoras(int rut, int horas) {
        Persona persona = new Persona();
        persona.setRut(rut);
        return this.devolverHoras(persona,horas);
    }

    @Override
    public Persona busquedaPorRut(int rut) {

        return getPort().personaPorRut(rut);
    }

}
