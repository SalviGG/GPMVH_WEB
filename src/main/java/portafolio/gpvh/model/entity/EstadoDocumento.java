package portafolio.gpvh.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "estado_documento")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EstadoDocumento implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SQ_ESTADO_DOCUMENTO_ID")
	@SequenceGenerator(name = "SQ_ESTADO_DOCUMENTO_ID",allocationSize = 1,sequenceName = "SQ_ESTADO_DOCUMENTO_ID")
	@Column(name = "estado_documento_id")
	private int estadoDocumentoId;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "grupo_estados")
	private String grupoEstados;

	@OneToMany(mappedBy = "estadoDocumentoId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Documento> estadoDocIds;
	
	public EstadoDocumento()
	{

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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Documento> getEstadoDocIds() {
		return estadoDocIds;
	}

	public void setEstadoDocIds(List<Documento> estadoDocIds) {
		this.estadoDocIds = estadoDocIds;
	}
}
