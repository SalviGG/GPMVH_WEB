package portafolio.gpvh.model.dao;

import org.springframework.data.repository.CrudRepository;

import portafolio.gpvh.model.entity.Funcionario;

public interface IFuncionario extends CrudRepository <Funcionario, Integer> {

}
