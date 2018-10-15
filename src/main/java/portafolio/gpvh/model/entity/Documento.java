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
	@Column(name = "documento_id")
	private int documentoId;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionarioId;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resolucion_id")
	private Resolucion resolucionId;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "motivo_id")
	private Motivo motivoId;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "afecta_documento_id")
	private Documento afectaDocumentoId;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_documento_id")
	private TipoDocumento tipoDocumentoId;
	

	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "estado_documento_id")
	private EstadoDocumento estadoDocumentoId;
	
	@Column(name = "fecha_solicitud")
	private Date fechaSolicitud;
	
	@Column(name = "ultima_fecha_modificacion")
	private Date ultimaFechaModificacion;
	
	@Column(name = "url_documento_adjunto")
	private String urlDocumentoAdjunto;
	
	@Column(name = "fecha_inicio")
	private Date fechaInicio;
	
	@Column(name = "fecha_termino")
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

	public List<Documento> getAfectaDocIds() {
		return afectaDocIds;
	}

	public void setAfectaDocIds(List<Documento> afectaDocIds) {
		this.afectaDocIds = afectaDocIds;
	}

}
