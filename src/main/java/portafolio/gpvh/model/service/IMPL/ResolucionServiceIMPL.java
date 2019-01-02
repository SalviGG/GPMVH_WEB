package portafolio.gpvh.model.service.IMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portafolio.gpvh.model.dao.IResolucionDao;
import portafolio.gpvh.model.entity.Funcionario;
import portafolio.gpvh.model.entity.Motivo;
import portafolio.gpvh.model.entity.Resolucion;
import portafolio.gpvh.model.service.ResolucionService;

import java.util.List;

@Service
public class ResolucionServiceIMPL implements ResolucionService {

    @Autowired
    private IResolucionDao resuDao;

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

    public int countResoluciones(){
        return resuDao.countResoluciones();
    }

    public List<Resolucion> findByMotivoId(Motivo motivo){
        return resuDao.findByMotivoId(motivo);
    }

    public List<Resolucion> findByFuncionarioId(Funcionario funcionario){
        return resuDao.findByFuncionarioId(funcionario);
    }


}
