package portafolio.gpvh.model.entity;

import java.sql.Date;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "resolucion")
public class Resolucion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resolucion_id")
	private int resolucionId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionarioId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "motivo_id")
	private Motivo motivoId;
	
	@Column(name = "fecha_emision")
	private Date fecha;

	@Column(name = "titulo")
	private String titulo;

	@OneToMany(mappedBy = "resolucionId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Documento> getResolucionIdDocs() {
		return resolucionIdDocs;
	}

	public void setResolucionIdDocs(List<Documento> resolucionIdDocs) {
		this.resolucionIdDocs = resolucionIdDocs;
	}
}
