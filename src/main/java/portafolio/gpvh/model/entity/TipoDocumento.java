package portafolio.gpvh.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tipo_documentos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TipoDocumento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tipo_documento_id")
	private int tipoDocumentoId;

	@Column(name = "nombre")
	private String nombre;

	@OneToMany(mappedBy = "tipoDocumentoId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Documento> tipoDocumentoIds;
	
	public TipoDocumento() {

		this.tipoDocumentoIds = new ArrayList<Documento>();
	}

	public int getTipoDocumentoId() {
		return tipoDocumentoId;
	}

	public void setTipoDocumentoId(int tipoDocumentoId) {
		this.tipoDocumentoId = tipoDocumentoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Documento> getTipoDocumentoIds() {
		return tipoDocumentoIds;
	}

	public void setTipoDocumentoIds(List<Documento> tipoDocumentoIds) {
		this.tipoDocumentoIds = tipoDocumentoIds;
	}
}
