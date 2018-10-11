package portafolio.gpvh.model.service;

import portafolio.gpvh.model.entity.Funcion;

import java.util.List;

public interface FuncionService {

    public List<Funcion> findAll();
    public void save(Funcion funcion);
    public Funcion findOne(int id);
    public void delete(Funcion funcion);
}
