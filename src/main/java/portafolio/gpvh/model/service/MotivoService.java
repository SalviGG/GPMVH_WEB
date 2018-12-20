package portafolio.gpvh.model.service;

import portafolio.gpvh.model.entity.Motivo;

import java.util.List;

public interface MotivoService {

    public List<Motivo> findAllActivo();
    public List<Motivo> findAllActivoAnulacion();
    public List<Motivo> findAllInactivo();
    List<Motivo> findAllAnulacion();
    public List<Motivo> findAll();
    public void save(Motivo motivo);
    public Motivo findOne(int id);
    public void delete(Motivo motivo);
    public List<Motivo> findAllOtros(List<Integer> list);
}
