package portafolio.gpvh.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class EstadoDocumento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ESTADO_DOCUMENTO_ID")
	private Integer estadoDocumentoId;
	private String desc;
	private String grupoEstados;
	
	public EstadoDocumento()
	{
		
	}

	public Integer getEstadoDocumentoId() {
		return estadoDocumentoId;
	}

	public void setEstadoDocumentoId(Integer estadoDocumentoId) {
		this.estadoDocumentoId = estadoDocumentoId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getGrupoEstados() {
		return grupoEstados;
	}

	public void setGrupoEstados(String grupoEstados) {
		this.grupoEstados = grupoEstados;
	}
	
	
}
