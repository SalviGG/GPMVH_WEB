package portafolio.gpvh.model.service;

import portafolio.gpvh.model.entity.Documento;
import portafolio.gpvh.model.entity.Funcionario;
import portafolio.gpvh.model.entity.Motivo;
import portafolio.gpvh.model.entity.EstadoDocumento;

import java.util.List;

public interface DocumentoService {

    public List<Documento> findAll();
    public void save(Documento documento);
    public Documento findOne(int id);
    public void delete(Documento documento);
    public List<Documento> findAllByFuncionarioId(Funcionario funcionario);
    public List<Documento> findAllByFuncionarioIdAndMotivoId(Funcionario funcionario);
    public List<Documento> findAllConDocumento();
    public int countDocumentos();
    public int countDocumentosRevision();
    public int countDocumentosAll();
    public List<Documento> findUltimosConDocumento();
    public List<Documento> findUltimosPermisos();
    public List<Documento>  findByMotivoId(Motivo motivo);
    public List<Documento> findByEstadoDocumentoId( EstadoDocumento estadoDocumento);


}
