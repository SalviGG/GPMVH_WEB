package portafolio.gpvh.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="motivo")
public class Motivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "motivo_id")
	private int motivoId;

	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "requiere_doc_adjuc")
	private String requiere;

	@Column(name = "activo")
	private String activo;

	@OneToMany(mappedBy = "motivoId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Resolucion> motivoIdRes;

	@OneToMany(mappedBy = "motivoId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

	public String getRequiere() {
		return requiere;
	}

	public void setRequiere(String requiere) {
		this.requiere = requiere;
	}

	public List<Resolucion> getMotivoIdRes() {
		return motivoIdRes;
	}

	public void setMotivoIdRes(List<Resolucion> motivoIdRes) {
		this.motivoIdRes = motivoIdRes;
	}

	public List<Documento> getMotivoIdDocs() {
		return motivoIdDocs;
	}

	public void setMotivoIdDocs(List<Documento> motivoIdDocs) {
		this.motivoIdDocs = motivoIdDocs;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}
}
