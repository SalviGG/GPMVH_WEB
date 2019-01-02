package portafolio.gpvh.model.service.IMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import portafolio.gpvh.model.dao.IFuncionarioDao;
import portafolio.gpvh.model.entity.Funcionario;
import portafolio.gpvh.model.service.FuncionarioService;

import java.util.List;

@Service
public class FuncionarioServiceIMPL implements FuncionarioService {

    @Autowired
    private IFuncionarioDao funciDao;

    public List<Funcionario> findAll(){

        return(List<Funcionario>) funciDao.findAll();
    }

    public void save(Funcionario funcionario){

        funciDao.save(funcionario);
    }

    public Funcionario findOne(int id){

        return funciDao.findById(id).orElse(null);
    }

    public void delete (Funcionario funcionario){

        funciDao.delete(funcionario);
    }

    @Override
    public Funcionario buscarPorRut(int rut) {

        return funciDao.countFuncionarioByRut(rut);
    }
}
