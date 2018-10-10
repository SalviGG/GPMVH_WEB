package portafolio.gpvh.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MOTIVO")

public class Motivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOTIVO_ID")
	private Integer motivoId;
	
	private String nombre;
	
	@Column(name = "REQUIERO_DOC_ADJUC")
	private String requiere;
	
	public Motivo()
	{
		
		
	}
	
	public Integer getMotivoId() {
		return motivoId;
	}
	public void setMotivoId(Integer motivoId) {
		this.motivoId = motivoId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRequerimiento() {
		return requiere;
	}
	public void setRequerimiento(String requiere) {
		this.requiere = requiere;
	}
	

}
