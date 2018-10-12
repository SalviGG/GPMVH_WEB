package portafolio.gpvh.model.service.IMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import portafolio.gpvh.model.dao.IMotivoDao;
import portafolio.gpvh.model.entity.Motivo;
import portafolio.gpvh.model.service.MotivoService;

import java.util.List;

@Service
public class MotivoServiceIMPL implements MotivoService {

    @Autowired
    private IMotivoDao motiDao;

    public List<Motivo> findAll(){

        return (List<Motivo>) motiDao.findAll();
    }

    public void save (Motivo motivo){

        motiDao.save(motivo);
    }
    public Motivo findOne(int id){
        return motiDao.findById(id).orElse(null);

    }
    public void delete (Motivo motivo){

        motiDao.delete(motivo);

    }
}
