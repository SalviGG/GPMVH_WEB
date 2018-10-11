package portafolio.gpvh.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FUNCIONARIO_ID")
	private int funcionarioId;

	@Column(name = "rut", unique = true)
	private int rut;

	@Column(name = "ROL_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROL_ID")
	private Rol rolId;

	@Column(name = "DEPARTAMENTO_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPARTAMENTO_ID")
	private Departamento departamentoId;

	@OneToMany(mappedBy = "jefe_departamento_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Departamento> jefeDeptoIds;

	@OneToMany(mappedBy = "funcionario_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Resolucion> funcionarioIdRes;

	@OneToMany(mappedBy = "funcionario_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Documento> funcionarioIdDocs;


	private String firmaUrl;
	
	public Funcionario()
	{
		this.jefeDeptoIds = new ArrayList<Departamento>();
		this.funcionarioIdRes = new ArrayList<Resolucion>();
		this.funcionarioIdDocs = new ArrayList<Documento>();
		
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

	public Rol getRolId() {
		return rolId;
	}

	public void setRolId(Rol rolId) {
		this.rolId = rolId;
	}

	public Departamento getDepartamentoId() {
		return departamentoId;
	}

	public void setDepartamentoId(Departamento departamentoId) {
		this.departamentoId = departamentoId;
	}

	public String getFirmaUrl() {
		return firmaUrl;
	}

	public void setFirmaUrl(String firmaUrl) {
		this.firmaUrl = firmaUrl;
	}
	
	
}
