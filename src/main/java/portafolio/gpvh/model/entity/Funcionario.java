package portafolio.gpvh.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Entity
@Table(name = "funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SQ_FUNCION_ID")
	@SequenceGenerator(name = "SQ_FUNCION_ID",allocationSize = 1,sequenceName = "SQ_FUNCION_ID")
	@Column(name = "funcionario_id")
	private int funcionarioId;

	@Column(name = "rut", unique = true)
	private int rut;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rol_id")
	private Rol rolId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "departamento_id")
	private Departamento departamentoId;

	@Column(name = "firma_url")
	private String firmaUrl;

	@Column(name = "fecha_contratacion")
	private Date fechaContratacion;

	@Column(name = "dia_vacaciones")
	private Integer diaVacaciones;

	@Column(name = "dia_vacaciones_usadas")
	private Integer diaVacacionesUsadas;

	@Column(name = "dias_administrativo_usados")
	private Integer diasAdministrativoUsados;

	@OneToMany(mappedBy = "jefeDepartamentoId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Departamento> jefeDeptoIds;

	@OneToMany(mappedBy = "funcionarioId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Resolucion> funcionarioIdRes;

	@OneToMany(mappedBy = "funcionarioId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Documento> funcionarioIdDocs;


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

	public int getDiaVacaciones() {
		return diaVacaciones;
	}

	public void setDiaVacaciones(int diaVacaciones) {
		this.diaVacaciones = diaVacaciones;
	}

	public int getDiaVacacionesUsadas() {
		return diaVacacionesUsadas;
	}

	public void setDiaVacacionesUsadas(int diaVacacionesUsadas) {
		this.diaVacacionesUsadas = diaVacacionesUsadas;
	}

	public int getDiasAdministrativoUsados() {
		return diasAdministrativoUsados;
	}

	public void setDiasAdministrativoUsados(int diasAdministrativoUsados) {
		this.diasAdministrativoUsados = diasAdministrativoUsados;
	}

	public List<Departamento> getJefeDeptoIds() {
		return jefeDeptoIds;
	}

	public void setJefeDeptoIds(List<Departamento> jefeDeptoIds) {
		this.jefeDeptoIds = jefeDeptoIds;
	}

	public List<Resolucion> getFuncionarioIdRes() {
		return funcionarioIdRes;
	}

	public void setFuncionarioIdRes(List<Resolucion> funcionarioIdRes) {
		this.funcionarioIdRes = funcionarioIdRes;
	}

	public List<Documento> getFuncionarioIdDocs() {
		return funcionarioIdDocs;
	}

	public void setFuncionarioIdDocs(List<Documento> funcionarioIdDocs) {
		this.funcionarioIdDocs = funcionarioIdDocs;
	}
}
