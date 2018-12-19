package portafolio.gpvh.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import portafolio.gpvh.model.entity.Resolucion;

public interface IResolucionDao extends CrudRepository <Resolucion, Integer> {

    @Query("SELECT COUNT(r) FROM Resolucion r")
    int countResoluciones();

}
