package portafolio.gpvh.model.service.IMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portafolio.gpvh.model.dao.IResolucionDAO;
import portafolio.gpvh.model.entity.Resolucion;
import portafolio.gpvh.model.service.ResolucionService;

import java.util.List;

@Service
public class ResolucionServiceIMPL implements ResolucionService {

    @Autowired
    private IResolucionDAO resuDao;

    public List<Resolucion> findAll(){

        return (List<Resolucion>) resuDao.findAll();
    }

    public void save (Resolucion resolucion){

        resuDao.save(resolucion);
    }

    public Resolucion findOne(int id){

        return resuDao.findById(id).orElse(null);
    }

    public void delete(Resolucion resolucion){

        resuDao.delete(resolucion);
    }
}
