package portafolio.gpvh.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Funcion")
public class Funcion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "funcion_id")
	private int funcionId;

	@Column(name = "url")
	private String url;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "nombre")
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

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}
}
