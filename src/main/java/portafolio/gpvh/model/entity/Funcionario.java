package portafolio.gpvh.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "Funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FUNCIONARIO_ID")
	private int funcionarioId;
	private int rut;
	
	@Column(name = "ROL_ID")
	private int rolId;
	
	@Column(name = "DEPARTAMENTO_ID")
	private int departamentoId;
	private String firmaUrl;
	
	public Funcionario()
	{
		
		
	}

	public int getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(int funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public int getRut() {
		return rut;
	}

	public void setRut(int rut) {
		this.rut = rut;
	}

	public int getRolId() {
		return rolId;
	}

	public void setRolId(int rolId) {
		this.rolId = rolId;
	}

	public int getDepartamentoId() {
		return departamentoId;
	}

	public void setDepartamentoId(int departamentoId) {
		this.departamentoId = departamentoId;
	}

	public String getFirmaUrl() {
		return firmaUrl;
	}

	public void setFirmaUrl(String firmaUrl) {
		this.firmaUrl = firmaUrl;
	}
	
	
}
