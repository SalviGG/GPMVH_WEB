
package portafolio.gpvh.controlAccesoWS.mappingWsl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para personaPorRut complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="personaPorRut">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rut" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "personaPorRut", propOrder = {
    "rut"
})
public class PersonaPorRut {

    protected int rut;

    /**
     * Obtiene el valor de la propiedad rut.
     * 
     */
    public int getRut() {
        return rut;
    }

    /**
     * Define el valor de la propiedad rut.
     * 
     */
    public void setRut(int value) {
        this.rut = value;
    }

}
