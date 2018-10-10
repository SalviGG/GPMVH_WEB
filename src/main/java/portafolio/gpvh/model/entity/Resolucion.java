package portafolio.gpvh.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Resolucion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RESOLUCION_ID")
	private Integer resolucionId;
	
	@Column(name = "FUNCIONARIO_ID")
	private Integer funcionarioId;
	
	@Column(name = "MOTIVO_ID")
	private Integer motivoId;
	
	@Column(name = "FECHA_EMICION")
	private Date fecha;
	private String titulo;
	
	public Resolucion() 
	{
		
	}

	public Integer getResolucionId() {
		return resolucionId;
	}

	public void setResolucionId(Integer resolucionId) {
		this.resolucionId = resolucionId;
	}

	public Integer getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Integer funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public Integer getMotivoId() {
		return motivoId;
	}

	public void setMotivoId(Integer motivoId) {
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
