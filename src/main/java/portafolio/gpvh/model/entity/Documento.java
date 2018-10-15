package portafolio.gpvh.model.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.print.Doc;

@Entity
@Table(name = "Documento")
public class Documento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DOCUMENTO_ID")
	private int documentoId;
	
	//@Column(name = "FUNCIONARIO_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "funcionarioId")
	private Funcionario funcionarioId;
	
	//@Column(name = "RESOLUCION_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "resolucionId")
	private Resolucion resolucionId;
	
	//@Column(name = "MOTIVO_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "motivoId")
	private Motivo motivoId;
	
	//@Column(name = "AFECTA_DOCUMENTO_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "afectaDocumentoId")
	private Documento afectaDocumentoId;
	
	//@Column(name = "TIPO_DOCUMENTO_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "tipoDocumentoId")
	private TipoDocumento tipoDocumentoId;
	
	//@Column(name = "ESTADO_DOCUMENTO_ID")
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinTable (name = "estadoDocumentoId")
	private EstadoDocumento estadoDocumentoId;
	
	@Column(name = "FECHA_SOLICITUD")
	private Date fechaSolicitud;
	
	@Column(name = "ULTIMA_FECHA_MODIFICACION")
	private Date ultimaFechaModificacion;
	
	@Column(name = "URL_DOCUMENTO_ADJUNTO")
	private String urlDocumentoAdjunto;
	
	@Column(name = "FECHA_INICIO")
	private Date fechaInicio;
	
	@Column(name = "FECHA_TERMINO")
	private Date fechaTermino;

	@OneToMany(mappedBy = "afectaDocumentoId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Documento> afectaDocIds;
	
	public Documento() 
	{
		this.afectaDocIds = new ArrayList<Documento>();
	}

	public int getDocumentoId() {
		return documentoId;
	}

	public void setDocumentoId(int documentoId) {
		this.documentoId = documentoId;
	}

	public Funcionario getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Funcionario funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public Resolucion getResolucionId() {
		return resolucionId;
	}

	public void setResolucionId(Resolucion resolucionId) {
		this.resolucionId = resolucionId;
	}

	public Motivo getMotivoId() {
		return motivoId;
	}

	public void setMotivoId(Motivo motivoId) {
		this.motivoId = motivoId;
	}

	public Documento getAfectaDocumentoId() {
		return afectaDocumentoId;
	}

	public void setAfectaDocumentoId(Documento afectaDocumentoId) {
		this.afectaDocumentoId = afectaDocumentoId;
	}

	public TipoDocumento getTipoDocumentoId() {
		return tipoDocumentoId;
	}

	public void setTipoDocumentoId(TipoDocumento tipoDocumentoId) {
		this.tipoDocumentoId = tipoDocumentoId;
	}

	public EstadoDocumento getEstadoDocumentoId() {
		return estadoDocumentoId;
	}

	public void setEstadoDocumentoId(EstadoDocumento estadoDocumentoId) {
		this.estadoDocumentoId = estadoDocumentoId;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Date getUltimaFechaModificacion() {
		return ultimaFechaModificacion;
	}

	public void setUltimaFechaModificacion(Date ultimaFechaModificacion) {
		this.ultimaFechaModificacion = ultimaFechaModificacion;
	}

	public String getUrlDocumentoAdjunto() {
		return urlDocumentoAdjunto;
	}

	public void setUrlDocumentoAdjunto(String urlDocumentoAdjunto) {
		this.urlDocumentoAdjunto = urlDocumentoAdjunto;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaTermino() {
		return fechaTermino;
	}

	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}
	
	

}
