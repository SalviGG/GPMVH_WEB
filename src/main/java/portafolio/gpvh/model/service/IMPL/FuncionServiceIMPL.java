package portafolio.gpvh.model.service.IMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portafolio.gpvh.model.dao.IFuncionDAO;
import portafolio.gpvh.model.entity.Funcion;
import portafolio.gpvh.model.service.FuncionService;

import java.util.List;

@Service
public class FuncionServiceIMPL implements FuncionService {

    @Autowired
    private IFuncionDAO funcionDao;

    public List<Funcion> findAll(){

        return (List<Funcion>)funcionDao.findAll();
    }

    public void save(Funcion funcion){

        funcionDao.save(funcion);
    }

    public Funcion findOne(int id){

        return funcionDao.findById(id).orElse(null);
    }

    public void delete(Funcion funcion){

        funcionDao.delete(funcion);
    }
}
