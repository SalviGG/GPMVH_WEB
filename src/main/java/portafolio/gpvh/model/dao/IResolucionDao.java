package portafolio.gpvh.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import portafolio.gpvh.model.entity.Funcionario;
import portafolio.gpvh.model.entity.Motivo;
import portafolio.gpvh.model.entity.Resolucion;

import java.util.List;

public interface IResolucionDao extends CrudRepository <Resolucion, Integer> {

    @Query("SELECT COUNT(r) FROM Resolucion r")
    int countResoluciones();

    @Query("SELECT r FROM Resolucion r WHERE r.motivoId = ?1")
    List<Resolucion> findByMotivoId(Motivo motivo);

    @Query("SELECT r FROM Resolucion r WHERE r.funcionarioId = ?1")
    List<Resolucion> findByFuncionarioId(Funcionario funcionario);


}
