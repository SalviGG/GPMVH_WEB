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
    public List<Persona> busquedaPersonas(int fragmentoRut);
    public List<Persona> busquedaPersonas(int fragmentoRut,int cantidad);
    public List<Persona> busquedaPersonas(String FragmentoNombre);
    public List<Persona> busquedaPersonas(String FragmentoNombre,int cantidad);
    public Persona consumirHoras(Persona persona,int horas);
    public Persona consumirHoras(int rut,int horas);
    public Persona devolverHoras(Persona persona ,int horas);
    public Persona devolverHoras(int rut ,int horas);
    public Persona busquedaPorRut(int rut);
}
