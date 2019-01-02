package portafolio.gpvh.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import portafolio.gpvh.model.entity.Motivo;

import java.util.List;

public interface IMotivoDao extends CrudRepository<Motivo, Integer>{

    @Query("select m from Motivo m where m.activo = ?1 and m.tipoMotivo = ?2 ")
    public List<Motivo> findAllForActivo(String activo, String tipo);

    @Query("select m from Motivo m where m.activo = ?1 and m.motivoId  not in ?2 and m.tipoMotivo = ?3 ")
    public List<Motivo> findAllForActivoOtros(String activo,List<Integer> lista, String tipo);

    @Query("select m from Motivo m where m.tipoMotivo = ?1")
    public List<Motivo> findMotivosByTipoMotivo(String tipo );
}
