package portafolio.gpvh.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

@Entity
@Table(name = "rol")
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROL_ID")
	private int rolId;

	@Column(name = "NOMBRE")
	private String nombre;

	@OneToMany(mappedBy = "rolId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Funcionario> rolIdsFuncionario;

	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Funcion> funciones = new HashSet<>();

	public Rol()
	{
		
		this.rolIdsFuncionario = new ArrayList<Funcionario>();
	}

	public int getRolId() {
		return rolId;
	}

	public void setRolId(int rolId) {
		this.rolId = rolId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
