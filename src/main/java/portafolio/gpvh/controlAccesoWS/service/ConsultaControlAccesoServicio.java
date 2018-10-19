package portafolio.gpvh.controlAccesoWS.service;

import portafolio.gpvh.controlAccesoWS.mappingWsl.Marcacion;
import portafolio.gpvh.controlAccesoWS.mappingWsl.Persona;

import java.util.Date;
import java.util.List;

public interface ConsultaControlAccesoServicio {

    public Persona externalLogin(int rut, String password);
    public List<Marcacion> asistenciaPorDia(Persona persona, Date dia);
    public List<Marcacion> asistenciaPorDia(int rut, Date dia);
    public List<Marcacion> asistenciaPorRangoFecha(Persona persona, Date desde , Date hasta);
    public List<Marcacion> asistenciaPorRangoFecha(int rut, Date desde , Date hasta);
    public List<Persona> busquedaPersona(int fragmentoRut);
    public List<Persona> busquedaPersona(String FragmentoNombre);
    public Persona busquedaPorRut(int rut);
}
