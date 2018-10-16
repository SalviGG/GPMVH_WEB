
package portafolio.gpvh.controlAccesoWS.mappingWsl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para busquedaPersonas complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="busquedaPersonas">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fragmentoRut" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fragmentoNombres" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cantidadColumnas" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "busquedaPersonas", propOrder = {
    "fragmentoRut",
    "fragmentoNombres",
    "cantidadColumnas"
})
public class BusquedaPersonas {

    protected int fragmentoRut;
    protected String fragmentoNombres;
    protected int cantidadColumnas;

    /**
     * Obtiene el valor de la propiedad fragmentoRut.
     * 
     */
    public int getFragmentoRut() {
        return fragmentoRut;
    }

    /**
     * Define el valor de la propiedad fragmentoRut.
     * 
     */
    public void setFragmentoRut(int value) {
        this.fragmentoRut = value;
    }

    /**
     * Obtiene el valor de la propiedad fragmentoNombres.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFragmentoNombres() {
        return fragmentoNombres;
    }

    /**
     * Define el valor de la propiedad fragmentoNombres.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFragmentoNombres(String value) {
        this.fragmentoNombres = value;
    }

    /**
     * Obtiene el valor de la propiedad cantidadColumnas.
     * 
     */
    public int getCantidadColumnas() {
        return cantidadColumnas;
    }

    /**
     * Define el valor de la propiedad cantidadColumnas.
     * 
     */
    public void setCantidadColumnas(int value) {
        this.cantidadColumnas = value;
    }

}
