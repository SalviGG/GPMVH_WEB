package portafolio.gpvh.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class TipoDocumento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TIPO_DOCUMENTO_ID")
	private Integer TipoDocumentoId;
	private String desc;
	
	public TipoDocumento() {
		
	}

	public Integer getTipoDocumentoId() {
		return TipoDocumentoId;
	}

	public void setTipoDocumentoId(Integer tipoDocumentoId) {
		TipoDocumentoId = tipoDocumentoId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
