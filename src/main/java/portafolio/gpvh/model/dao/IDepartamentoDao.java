package portafolio.gpvh.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import portafolio.gpvh.model.entity.Departamento;

import java.util.List;

public interface IDepartamentoDao extends CrudRepository<Departamento, Integer> {

	@Query("SELECT d FROM Departamento d WHERE d.jefeDepartamentoId > ?1")
    List<Departamento> findDepartamentoByDepartamentoId();

	@Query("SELECT d FROM Departamento d WHERE d.nombre >?1")
    List<Departamento> findDepartamentoByNombre();
}
