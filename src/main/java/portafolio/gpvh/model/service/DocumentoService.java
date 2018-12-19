package portafolio.gpvh.model.service;

import portafolio.gpvh.model.entity.Documento;
import portafolio.gpvh.model.entity.Funcionario;

import java.util.List;

public interface DocumentoService {

    public List<Documento> findAll();
    public void save(Documento documento);
    public Documento findOne(int id);
    public void delete(Documento documento);
    public List<Documento> findAllByFuncionarioId(Funcionario funcionario);
    public List<Documento> findAllByFuncionarioIdAndMotivoId(Funcionario funcionario);
    public List<Documento> findAllConDocumento();

}
