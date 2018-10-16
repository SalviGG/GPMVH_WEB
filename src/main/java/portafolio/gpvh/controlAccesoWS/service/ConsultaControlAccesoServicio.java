package portafolio.gpvh.controlAccesoWS.service;

import portafolio.gpvh.controlAccesoWS.mappingWsl.Persona;

public interface ConsultaControlAccesoServicio {

    public Persona externalLogin(int rut,String password);
}
