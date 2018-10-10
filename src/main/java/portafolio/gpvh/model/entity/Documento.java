package portafolio.gpvh.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Documento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DOCUMENTO_ID")
	private Integer documentoId;
	
	@Column(name = "FUNCIONARIO_ID")
	private Integer funcionarioId;
	
	@Column(name = "RESOLUCION_ID")
	private Integer resolucionId;
	
	@Column(name = "MOTIVO_ID")
	private Integer motivoId;
	
	@Column(name = "AFECTA_DOCUMENTO_ID")
	private Integer afectaDocumentoId;
	
	@Column(name = "TIPO_DOCUMENTO_ID")
	private Integer tipoDocumentoId;
	
	@Column(name = "ESTADO_DOCUMENTO_ID")
	private Integer estadoDocumentoId;
	
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
	
	public Documento() 
	{
		
	}

	public Integer getDocumentoId() {
		return documentoId;
	}

	public void setDocumentoId(Integer documentoId) {
		this.documentoId = documentoId;
	}

	public Integer getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Integer funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public Integer getResolucionId() {
		return resolucionId;
	}

	public void setResolucionId(Integer resolucionId) {
		this.resolucionId = resolucionId;
	}

	public Integer getMotivoId() {
		return motivoId;
	}

	public void setMotivoId(Integer motivoId) {
		this.motivoId = motivoId;
	}

	public Integer getAfectaDocumentoId() {
		return afectaDocumentoId;
	}

	public void setAfectaDocumentoId(Integer afectaDocumentoId) {
		this.afectaDocumentoId = afectaDocumentoId;
	}

	public Integer getTipoDocumentoId() {
		return tipoDocumentoId;
	}

	public void setTipoDocumentoId(Integer tipoDocumentoId) {
		this.tipoDocumentoId = tipoDocumentoId;
	}

	public Integer getEstadoDocumentoId() {
		return estadoDocumentoId;
	}

	public void setEstadoDocumentoId(Integer estadoDocumentoId) {
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
