package portafolio.gpvh.model.service.IMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portafolio.gpvh.model.dao.ITipoDocumentoDAO;
import portafolio.gpvh.model.entity.TipoDocumento;
import portafolio.gpvh.model.service.TipoDocumentoService;

import java.util.List;

@Service
public class TipoDocumentoServiceIMPL implements TipoDocumentoService {

    @Autowired
    private ITipoDocumentoDAO tipodocDao;

    public List<TipoDocumento> findAll(){

        return (List<TipoDocumento>) tipodocDao.findAll();
    }

    public void save(TipoDocumento tipoDocumento){

        tipodocDao.save(tipoDocumento);
    }

    public TipoDocumento findOne(int id){

        return tipodocDao.findById(id).orElse(null);
    }

    public void delete(TipoDocumento tipoDocumento){

        tipodocDao.delete(tipoDocumento);
    }


}
