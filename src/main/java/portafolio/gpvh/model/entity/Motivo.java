package portafolio.gpvh.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="motivo")
public class Motivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOTIVO_ID")
	private int motivoId;

	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "REQUIERO_DOC_ADJUC")
	private String requiere;

	@OneToMany(mappedBy = "motivo_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Resolucion> motivoIdRes;

	@OneToMany(mappedBy = "motivo_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Documento> motivoIdDocs;


	
	public Motivo()
	{
		this.motivoIdRes = new ArrayList<Resolucion>();
		this.motivoIdDocs = new ArrayList<Documento>();
		
	}
	
	public int getMotivoId() {
		return motivoId;
	}
	public void setMotivoId(int motivoId) {
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
