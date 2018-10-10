package portafolio.gpvh.model.entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "Documento")
public class Documento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DOCUMENTO_ID")
	private int documentoId;
	
	@Column(name = "FUNCIONARIO_ID")
	private int funcionarioId;
	
	@Column(name = "RESOLUCION_ID")
	private int resolucionId;
	
	@Column(name = "MOTIVO_ID")
	private int motivoId;
	
	@Column(name = "AFECTA_DOCUMENTO_ID")
	private int afectaDocumentoId;
	
	@Column(name = "TIPO_DOCUMENTO_ID")
	private int tipoDocumentoId;
	
	@Column(name = "ESTADO_DOCUMENTO_ID")
	private int estadoDocumentoId;
	
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

	public int getDocumentoId() {
		return documentoId;
	}

	public void setDocumentoId(int documentoId) {
		this.documentoId = documentoId;
	}

	public int getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(int funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public int getResolucionId() {
		return resolucionId;
	}

	public void setResolucionId(int resolucionId) {
		this.resolucionId = resolucionId;
	}

	public int getMotivoId() {
		return motivoId;
	}

	public void setMotivoId(int motivoId) {
		this.motivoId = motivoId;
	}

	public int getAfectaDocumentoId() {
		return afectaDocumentoId;
	}

	public void setAfectaDocumentoId(int afectaDocumentoId) {
		this.afectaDocumentoId = afectaDocumentoId;
	}

	public int getTipoDocumentoId() {
		return tipoDocumentoId;
	}

	public void setTipoDocumentoId(int tipoDocumentoId) {
		this.tipoDocumentoId = tipoDocumentoId;
	}

	public int getEstadoDocumentoId() {
		return estadoDocumentoId;
	}

	public void setEstadoDocumentoId(int estadoDocumentoId) {
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
