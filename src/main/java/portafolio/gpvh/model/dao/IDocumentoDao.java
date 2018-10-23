package portafolio.gpvh.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import portafolio.gpvh.model.entity.Documento;
import portafolio.gpvh.model.entity.Funcionario;

import java.util.List;

public interface IDocumentoDao extends CrudRepository<Documento, Integer>{

    @Query ("SELECT d FROM Documento d WHERE d.funcionarioId = ?1")
    List<Documento> findAllByFuncionarioId(Funcionario funcionario);


}
