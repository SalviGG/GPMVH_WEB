package portafolio.gpvh.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "Estado_documento")
public class EstadoDocumento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ESTADO_DOCUMENTO_ID")
	private int estadoDocumentoId;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "GRUPO_ESTADOS")
	private String grupoEstados;

	@OneToMany(mappedBy = "estadoDocumentoId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Documento> estadoDocIds;
	
	public EstadoDocumento()
	{
		this.estadoDocIds = new ArrayList<Documento>();
	}

	public int getEstadoDocumentoId() {
		return estadoDocumentoId;
	}

	public void setEstadoDocumentoId(int estadoDocumentoId) {
		this.estadoDocumentoId = estadoDocumentoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setDesc(String nombre) {
		this.nombre = nombre;
	}

	public String getGrupoEstados() {
		return grupoEstados;
	}

	public void setGrupoEstados(String grupoEstados) {
		this.grupoEstados = grupoEstados;
	}
	
	
}
