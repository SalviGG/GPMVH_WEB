package portafolio.gpvh.controlAccesoWS.service.serviceIMPL;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import portafolio.gpvh.controlAccesoWS.service.ConsultaControlAccesoServicio;
import portafolio.gpvh.controlAccesoWS.mappingWsl.*;

import java.util.Date;
import java.util.List;

@Service
public class ConsultaControlAccesoServicioIMPL implements ConsultaControlAccesoServicio {

    @Override
    public Persona externalLogin(int rut, String password) {
        password  = DigestUtils.md5Hex(password);
        Persona persona = new Persona();
        persona.setRut(rut);
        persona.setPass(password);
        ConsultaControlAcceso_Service service = new ConsultaControlAcceso_Service();
        ConsultaControlAcceso port = service.getConsultaControlAccesoPort();
        Persona personaResultado = port.externalLogin(persona);

        return personaResultado;
    }

    @Override
    public List<Marcacion> asistenciaPorDia(Persona persona, Date dia) {
        return null;
    }

    @Override
    public List<Marcacion> asistenciaPorDia(int rut, Date dia) {
        return null;
    }

    @Override
    public List<Marcacion> asistenciaPorRangoFecha(Persona persona, Date desde, Date hasta) {
        return null;
    }

    @Override
    public List<Marcacion> asistenciaPorRangoFecha(int rut, Date desde, Date hasta) {
        return null;
    }

    @Override
    public List<Persona> busquedaPersona(int fragmentoRut) {

        return null;
    }

    @Override
    public List<Persona> busquedaPersona(String FragmentoNombre) {
        return null;
    }

    @Override
    public Persona busquedaPorRut(int rut) {
        ConsultaControlAcceso_Service service = new ConsultaControlAcceso_Service();
        ConsultaControlAcceso port = service.getConsultaControlAccesoPort();
        Persona persona = port.personaPorRut(rut);
        return persona;
    }
}
