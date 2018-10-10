package portafolio.gpvh.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departamento")
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "departamento_Id")
	private int departamentoId;
	
	private String nombre;
	
	@Column(name = "JEFE_DEPARTAMENTO_ID")
	private Integer jefeDepartamentoId;
	
	public Departamento() {
		
	}

	public int getDepartamentoId() {
		return departamentoId;
	}

	public void setDepartamentoId(int departamentoId) {
		this.departamentoId = departamentoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getJefeDepartamentoId() {
		return jefeDepartamentoId;
	}

	public void setJefeDepartamentoId(Integer jefeDepartamentoId) {
		this.jefeDepartamentoId = jefeDepartamentoId;
	}
	
	
}
