package portafolio.gpvh.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class RolFuncion {
	
	@Column(name = "ROL_ID")
	private Integer rolId;
	
	@Column(name = "FUNCION_ID")
	private Integer funcionId;
	
	public RolFuncion()
	{
		
	}

	public Integer getRolId() {
		return rolId;
	}

	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}

	public Integer getFuncionId() {
		return funcionId;
	}

	public void setFuncionId(Integer funcionId) {
		this.funcionId = funcionId;
	}
	
}
