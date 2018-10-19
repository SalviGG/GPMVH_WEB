package portafolio.gpvh.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import portafolio.gpvh.model.entity.Motivo;

import java.util.List;

public interface IMotivoDao extends CrudRepository<Motivo, Integer>{

    @Query("select m from Motivo m where m.activo = ?1 ")
    public List<Motivo> findAllForActivo(String activo);
}
