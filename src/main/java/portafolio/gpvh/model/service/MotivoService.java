package portafolio.gpvh.model.service;

import portafolio.gpvh.model.entity.Motivo;

import java.util.List;

public interface MotivoService {

    public List<Motivo> findAll();
    public void save(Motivo motivo);
    public Motivo findOne(int id);
    public void delete(Motivo motivo);
}
