package portafolio.gpvh.model.service;

import portafolio.gpvh.model.entity.Funcionario;

import java.util.List;

public interface FuncionarioService {

    public List<Funcionario> findAll();
    public void save(Funcionario funcionario);
    public Funcionario findOne(int id);
    public void delete(Funcionario funcionario);
    public Funcionario buscarPorRut(int rut);
}
