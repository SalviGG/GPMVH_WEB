package portafolio.gpvh.model.service;
import java.util.List;


import portafolio.gpvh.model.entity.Departamento;

public interface DepartamentoService {
	public List<Departamento> findAll();
    public void save(Departamento departamento);
    public Departamento findOne(int id);
    public void delete(Departamento departamento);
}
