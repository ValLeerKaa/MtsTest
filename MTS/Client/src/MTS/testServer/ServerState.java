
package MTS.testServer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for serverState complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="serverState">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="active" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="clientRestartRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="paused" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serverState", propOrder = {
    "active",
    "clientRestartRequired",
    "paused"
})
public class ServerState {

    protected boolean active;
    protected boolean clientRestartRequired;
    protected boolean paused;

    /**
     * Gets the value of the active property.
     * 
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     */
    public void setActive(boolean value) {
        this.active = value;
    }

    /**
     * Gets the value of the clientRestartRequired property.
     * 
     */
    public boolean isClientRestartRequired() {
        return clientRestartRequired;
    }

    /**
     * Sets the value of the clientRestartRequired property.
     * 
     */
    public void setClientRestartRequired(boolean value) {
        this.clientRestartRequired = value;
    }

    /**
     * Gets the value of the paused property.
     * 
     */
    public boolean isPaused() {
        return paused;
    }

    /**
     * Sets the value of the paused property.
     * 
     */
    public void setPaused(boolean value) {
        this.paused = value;
    }

}
