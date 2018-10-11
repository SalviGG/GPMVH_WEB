package portafolio.gpvh.model.service.IMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portafolio.gpvh.model.dao.IEstadoDocumentoDAO;
import portafolio.gpvh.model.entity.EstadoDocumento;
import portafolio.gpvh.model.service.EstadoDocumentoService;

import java.util.List;

@Service
public class EstadoDocumentoServiceIMPL implements EstadoDocumentoService {

    @Autowired
    private IEstadoDocumentoDAO estadoDocDao;

    public List<EstadoDocumento> findAll(){

        return (List<EstadoDocumento>) estadoDocDao.findAll();
    }

    public void save(EstadoDocumento estadoDocumento){

        estadoDocDao.save(estadoDocumento);
    }

    public EstadoDocumento findOne(int id){

        return estadoDocDao.findById(id).orElse(null);
    }

    public void delete(EstadoDocumento estadoDocumento){

        estadoDocDao.delete(estadoDocumento);
    }
}
