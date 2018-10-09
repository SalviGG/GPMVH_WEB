
package portafolio.gpvh.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para marcacion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="marcacion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="controlAsistenciaId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="marcacion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="personaID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "marcacion", propOrder = {
    "controlAsistenciaId",
    "marcacion",
    "personaID"
})
public class Marcacion {

    protected int controlAsistenciaId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar marcacion;
    protected int personaID;

    /**
     * Obtiene el valor de la propiedad controlAsistenciaId.
     * 
     */
    public int getControlAsistenciaId() {
        return controlAsistenciaId;
    }

    /**
     * Define el valor de la propiedad controlAsistenciaId.
     * 
     */
    public void setControlAsistenciaId(int value) {
        this.controlAsistenciaId = value;
    }

    /**
     * Obtiene el valor de la propiedad marcacion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMarcacion() {
        return marcacion;
    }

    /**
     * Define el valor de la propiedad marcacion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMarcacion(XMLGregorianCalendar value) {
        this.marcacion = value;
    }

    /**
     * Obtiene el valor de la propiedad personaID.
     * 
     */
    public int getPersonaID() {
        return personaID;
    }

    /**
     * Define el valor de la propiedad personaID.
     * 
     */
    public void setPersonaID(int value) {
        this.personaID = value;
    }

}
