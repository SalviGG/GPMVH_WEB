package portafolio.gpvh.model.entity;

import java.sql.Date;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Resolucion")
public class Resolucion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RESOLUCION_ID")
	private int resolucionId;
	
	@Column(name = "FUNCIONARIO_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "FUNCIONARIO_ID")
	private Funcionario funcionarioId;
	
	@Column(name = "MOTIVO_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "motivo_id")
	private Motivo motivoId;
	
	@Column(name = "FECHA_EMISION")
	private Date fecha;

	@Column(name = "TITULO")
	private String titulo;

	@OneToMany(mappedBy = "resolucion_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Documento> resolucionIdDocs;
	
	public Resolucion() 
	{
		this.resolucionIdDocs = new ArrayList<Documento>();
	}

	public int getResolucionId() {
		return resolucionId;
	}

	public void setResolucionId(int resolucionId) {
		this.resolucionId = resolucionId;
	}

	public Funcionario getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Funcionario funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public Motivo getMotivoId() {
		return motivoId;
	}

	public void setMotivoId(Motivo motivoId) {
		this.motivoId = motivoId;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setDate(Date fecha) {
		this.fecha = fecha;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}
