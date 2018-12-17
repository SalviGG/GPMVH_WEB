package portafolio.gpvh.model.service.IMPL;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import portafolio.gpvh.model.dao.IDocumentoDao;
import portafolio.gpvh.model.entity.Documento;
import portafolio.gpvh.model.entity.Funcionario;
import portafolio.gpvh.model.service.DocumentoService;

import java.util.List;

@Service
public class DocumentoServiceIMPL implements DocumentoService {

    @Autowired
    private IDocumentoDao docuDAO;

    public List<Documento> findAll() {

        return (List<Documento>) docuDAO.findAll();
    }

    public void save(Documento documento) {

        docuDAO.save(documento);
    }

    public Documento findOne(int id) {

        return docuDAO.findById(id).orElse(null);
    }

    public void delete(Documento documento) {

        docuDAO.delete(documento);
    }

    public List<Documento> findAllByFuncionarioId(Funcionario funcionarioId) {

       return (List<Documento> )docuDAO.findAllByFuncionarioId(funcionarioId);
    }

    public List<Documento> findAllByFuncionarioIdAndMotivoId(Funcionario funcionario){
        return (List<Documento> )docuDAO.findAllByFuncionarioIdAndMotivoId(funcionario);
    }

    public List<Documento> findAllConDocumento(){
        return (List<Documento>)docuDAO.findAllConDocumento();
    }

}
