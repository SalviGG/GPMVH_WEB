package portafolio.gpvh.model.service.IMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portafolio.gpvh.model.dao.IRolDAO;
import portafolio.gpvh.model.entity.Rol;
import portafolio.gpvh.model.service.RolService;

import java.util.List;

@Service
public class RolServiceIMPL implements RolService {

    @Autowired
    private IRolDAO rolDAO;

    public List<Rol> findAll(){

        return (List<Rol>) rolDAO.findAll();
    }

    public void save (Rol rol){

        rolDAO.save(rol);
    }

    public Rol findOne(int id){

        return rolDAO.findById(id).orElse(null);
    }

    public void delete(Rol rol){

        rolDAO.delete(rol);
    }
}
