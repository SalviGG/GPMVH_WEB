package portafolio.gpvh.model.service.IMPL;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portafolio.gpvh.model.dao.IDocumentoDao;
import portafolio.gpvh.model.entity.Documento;
import portafolio.gpvh.model.entity.EstadoDocumento;
import portafolio.gpvh.model.service.DocumentoService;

import java.util.List;

@Service
public class DocumentoServiceIMPL implements DocumentoService {

    @Autowired
    private IDocumentoDao docuDAO;

    public List<Documento> findAll()
    {

        return (List<Documento>) docuDAO.findAll();
    }

    public void save (Documento documento){

        docuDAO.save(documento);
    }

    public Documento findOne(int id){

        return docuDAO.findById(id).orElse(null);
    }

    public void delete (Documento documento){

        docuDAO.delete(documento);
    }


}
