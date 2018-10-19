package portafolio.gpvh.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import portafolio.gpvh.model.entity.Funcionario;

public interface IFuncionarioDao extends CrudRepository <Funcionario, Integer> {

    @Query("select f from Funcionario f where f.rut = ?1")
    public Funcionario countFuncionarioByRut(int rut) ;
}
