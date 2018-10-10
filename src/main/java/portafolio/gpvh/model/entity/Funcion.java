package portafolio.gpvh.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Funcion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FUNCION_ID")
	private Integer funcionId;
	private String url;
	private String desc;
	private String nombre;
	
	
	public Funcion() {
		
		
	}


	public Integer getFuncionId() {
		return funcionId;
	}


	public void setFuncionId(Integer funcionId) {
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
