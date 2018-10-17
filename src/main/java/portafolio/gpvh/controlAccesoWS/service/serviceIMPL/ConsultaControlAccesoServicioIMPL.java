package portafolio.gpvh.controlAccesoWS.service.serviceIMPL;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import portafolio.gpvh.controlAccesoWS.service.ConsultaControlAccesoServicio;
import portafolio.gpvh.controlAccesoWS.mappingWsl.*;

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
}
