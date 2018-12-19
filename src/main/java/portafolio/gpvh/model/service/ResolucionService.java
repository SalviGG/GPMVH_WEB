package portafolio.gpvh.model.service;

import portafolio.gpvh.model.entity.Funcionario;
import portafolio.gpvh.model.entity.Motivo;
import portafolio.gpvh.model.entity.Resolucion;

import java.util.List;

public interface ResolucionService {

    public List<Resolucion> findAll();
    public void save(Resolucion resolucion);
    public Resolucion findOne(int id);
    public void delete(Resolucion resolucion);
    public int countResoluciones();
    public List<Resolucion> findByMotivoId(Motivo motivo);
    public List<Resolucion> findByFuncionarioId(Funcionario funcionario);

}
