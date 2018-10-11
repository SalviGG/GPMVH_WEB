package portafolio.gpvh.model.service;

import portafolio.gpvh.model.entity.Rol;

import java.util.List;

public interface RolService {

    public List<Rol> findAll();
    public void save(Rol rol);
    public Rol findOne(int id);
    public void delete(Rol rol);
}
