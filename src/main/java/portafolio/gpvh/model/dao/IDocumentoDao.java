package portafolio.gpvh.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import portafolio.gpvh.model.entity.Documento;
import portafolio.gpvh.model.entity.Funcionario;

import java.util.List;

public interface IDocumentoDao extends CrudRepository<Documento, Integer>{

    @Query ("SELECT d FROM Documento d WHERE d.funcionarioId = ?1")
    List<Documento> findAllByFuncionarioId(Funcionario funcionario);

    @Query ("SELECT d FROM Documento d WHERE d.funcionarioId = ?1 AND d.estadoDocumentoId = 4")
    List<Documento> findAllByFuncionarioIdAndMotivoId(Funcionario funcionario);

    @Query ("SELECT d FROM Documento d WHERE d.urlDocumentoAdjunto IS NOT NULL AND d.estadoDocumentoId = 2")
    List<Documento> findAllConDocumento();
}
