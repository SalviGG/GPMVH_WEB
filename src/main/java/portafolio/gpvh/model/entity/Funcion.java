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
	private String url;
	private String desc;
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


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	
}
