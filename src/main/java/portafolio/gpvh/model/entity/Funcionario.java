package portafolio.gpvh.model.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FUNCIONARIO_ID")
	private Integer funcionarioId;
	private Integer rut;
	
	@Column(name = "ROL_ID")
	private Integer rolId;
	
	@Column(name = "DEPARTAMENTO_ID")
	private Integer departamentoId;
	private String firmaUrl;
	
	public Funcionario()
	{
		
		
	}

	public Integer getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Integer funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public Integer getRut() {
		return rut;
	}

	public void setRut(Integer rut) {
		this.rut = rut;
	}

	public Integer getRolId() {
		return rolId;
	}

	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}

	public Integer getDepartamentoId() {
		return departamentoId;
	}

	public void setDepartamentoId(Integer departamentoId) {
		this.departamentoId = departamentoId;
	}

	public String getFirmaUrl() {
		return firmaUrl;
	}

	public void setFirmaUrl(String firmaUrl) {
		this.firmaUrl = firmaUrl;
	}
	
	
}
