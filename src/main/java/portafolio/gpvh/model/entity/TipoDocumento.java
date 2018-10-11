package portafolio.gpvh.model.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tipo_documento")
public class TipoDocumento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TIPO_DOCUMENTO_ID")
	private int tipoDocumentoId;

	@Column(name = "NOMBRE")
	private String nombre;

	@OneToMany(mappedBy = "tipo_documento_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
	
}
