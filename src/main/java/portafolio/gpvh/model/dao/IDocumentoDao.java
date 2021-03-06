package portafolio.gpvh.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import portafolio.gpvh.model.entity.Documento;
import portafolio.gpvh.model.entity.Funcionario;
import portafolio.gpvh.model.entity.EstadoDocumento;
import portafolio.gpvh.model.entity.Motivo;

import java.util.List;

public interface IDocumentoDao extends CrudRepository<Documento, Integer>{

    @Query ("SELECT d FROM Documento d WHERE d.funcionarioId = ?1")
    List<Documento> findAllByFuncionarioId(Funcionario funcionario);

    @Query ("SELECT d FROM Documento d WHERE d.documentoId = ?1")
    List<Documento> findAllByDocumentoId(Documento documento);

    @Query ("SELECT d FROM Documento d WHERE d.funcionarioId = ?1 AND d.estadoDocumentoId = 4")
    List<Documento> findAllByFuncionarioIdAndMotivoId(Funcionario funcionario);

    @Query ("SELECT d FROM Documento d WHERE d.urlDocumentoAdjunto IS NOT NULL AND d.estadoDocumentoId = 2")
    List<Documento> findAllConDocumento();

    @Query ("SELECT COUNT(d) FROM Documento d WHERE d.estadoDocumentoId = 2 OR  d.estadoDocumentoId = 4")
    int countDocumentos();

    @Query ("SELECT COUNT(d) FROM Documento d WHERE d.estadoDocumentoId = 2 AND d.urlDocumentoAdjunto IS NOT NULL")
    int countDocumentosRevision();

    @Query ("SELECT COUNT(d) FROM Documento d")
    int countDocumentosAll();

    @Query ("SELECT d FROM Documento d WHERE d.urlDocumentoAdjunto IS NOT NULL AND d.estadoDocumentoId = 2 ORDER BY d.documentoId DESC")
    List<Documento> findUltimosConDocumento();

    @Query ("SELECT d FROM Documento d WHERE d.estadoDocumentoId = 4 ORDER BY d.documentoId DESC")
    List<Documento> findUltimosPermisos();


    @Query ("SELECT d FROM Documento d WHERE d.motivoId = ?1")
    List <Documento> findByMotivoId(Motivo motivo);

    @Query ("SELECT d FROM  Documento d where d.estadoDocumentoId = ?1")
    List <Documento> findByEstadoDocumentoId(EstadoDocumento estadoDocumento);
}
