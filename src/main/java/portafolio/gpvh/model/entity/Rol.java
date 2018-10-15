package portafolio.gpvh.model.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Rol")
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rol_id")
	private int rolId;

	@Column(name = "nombre")
	private String nombre;

	@OneToMany(mappedBy = "rolId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Funcionario> rolIdFuncionario;

	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Funcion> funciones = new HashSet<>();

	public Rol()
	{

		this.rolIdFuncionario = new ArrayList<Funcionario>();
		this.funciones = new Set<Funcion>() {
			@Override
			public int size() {
				return 0;
			}

			@Override
			public boolean isEmpty() {
				return false;
			}

			@Override
			public boolean contains(Object o) {
				return false;
			}

			@Override
			public Iterator<Funcion> iterator() {
				return null;
			}

			@Override
			public Object[] toArray() {
				return new Object[0];
			}

			@Override
			public <T> T[] toArray(T[] a) {
				return null;
			}

			@Override
			public boolean add(Funcion funcion) {
				return false;
			}

			@Override
			public boolean remove(Object o) {
				return false;
			}

			@Override
			public boolean containsAll(Collection<?> c) {
				return false;
			}

			@Override
			public boolean addAll(Collection<? extends Funcion> c) {
				return false;
			}

			@Override
			public boolean retainAll(Collection<?> c) {
				return false;
			}

			@Override
			public boolean removeAll(Collection<?> c) {
				return false;
			}

			@Override
			public void clear() {

			}
		};
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

	public List<Funcionario> getRolIdFuncionario() {
		return rolIdFuncionario;
	}

	public void setRolIdFuncionario(List<Funcionario> rolIdFuncionario) {
		this.rolIdFuncionario = rolIdFuncionario;
	}

	public Set<Funcion> getFunciones() {
		return funciones;
	}

	public void setFunciones(Set<Funcion> funciones) {
		this.funciones = funciones;
	}
}
