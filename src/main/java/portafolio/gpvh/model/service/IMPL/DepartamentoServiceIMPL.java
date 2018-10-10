package portafolio.gpvh.model.service.IMPL;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import portafolio.gpvh.model.dao.IDepartamento;
import portafolio.gpvh.model.entity.Departamento;
import portafolio.gpvh.model.service.DepartamentoService;

@Service
public class DepartamentoServiceIMPL implements DepartamentoService {
	@Autowired
	private IDepartamento departDAO;

 
	public List<Departamento> findAll() {
		
		return (List<Departamento>) departDAO.findAll();
	}

	
	public void save(Departamento departamento) {
		departDAO.save(departamento);
		
	}

	
	public Departamento findOne(int id) {
		
		return departDAO.findById(id).orElse(null);
		
	}

	
	public void delete(Departamento departamento) {
		departDAO.delete(departamento);		
	}

}
