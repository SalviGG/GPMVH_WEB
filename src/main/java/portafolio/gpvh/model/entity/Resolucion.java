package portafolio.gpvh.model.entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "Resolucion")
public class Resolucion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RESOLUCION_ID")
	private int resolucionId;
	
	@Column(name = "FUNCIONARIO_ID")
	private int funcionarioId;
	
	@Column(name = "MOTIVO_ID")
	private int motivoId;
	
	@Column(name = "FECHA_EMICION")
	private Date fecha;
	private String titulo;
	
	public Resolucion() 
	{
		
	}

	public int getResolucionId() {
		return resolucionId;
	}

	public void setResolucionId(int resolucionId) {
		this.resolucionId = resolucionId;
	}

	public int getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(int funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public int getMotivoId() {
		return motivoId;
	}

	public void setMotivoId(int motivoId) {
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
