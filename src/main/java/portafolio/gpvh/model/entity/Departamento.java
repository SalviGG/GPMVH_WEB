package portafolio.gpvh.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departamento")
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "departamento_Id")
	private int departamentoId;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	//@Column(name = "JEFE_DEPARTAMENTO_ID")
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinTable(name = "funcionarioId")
	private Funcionario jefeDepartamentoId;

	@OneToMany(mappedBy = "departamentoId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Funcionario> departamentoIdfuncionarios;
	
	public Departamento() {

		this.departamentoIdfuncionarios = new ArrayList<Funcionario>();
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

	public Funcionario getJefeDepartamentoId() {
		return jefeDepartamentoId;
	}

	public void setJefeDepartamentoId(Funcionario jefeDepartamentoId) {
		this.jefeDepartamentoId = jefeDepartamentoId;
	}
	
	
}
