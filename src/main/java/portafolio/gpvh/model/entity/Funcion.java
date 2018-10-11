package portafolio.gpvh.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Funcion")
public class Funcion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FUNCION_ID")
	private int funcionId;

	@Column(name = "URL")
	private String url;

	@Column(name = "DESCRIPCION")
	private String descripcion;

	@Column(name = "NOMBRE")
	private String nombre;

	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(
			name = "rol_funcion",
			joinColumns = {@JoinColumn(name = "funcionId")},
			inverseJoinColumns = {@JoinColumn(name = "rolId")}
	)
	Set<Rol> roles = new HashSet<>();
	
	
	public Funcion() {
		
		
	}


	public int getFuncionId() {
		return funcionId;
	}


	public void setFuncionId(int funcionId) {
		this.funcionId = funcionId;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDesc(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	
}
