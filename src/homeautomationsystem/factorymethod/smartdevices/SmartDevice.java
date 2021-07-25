/**
 * @author Carlos Espinoza B92786
 * Fabiola Jimenez B23452
 * Sebastián Montero B95016
 * Kendall Lara B43707
 * Roy Muñoz B54911
 * Maria Jesús B98243
 */
package homeautomationsystem.factorymethod.smartdevices;

import homeautomationsystem.mediator.Mediator;

public abstract class SmartDevice {

    public boolean smartDeviceOn = false;
    public String type;
    public Mediator context;

    /**
     * This method gives the mediator context to the class.
     *
     * @param context This context is the one given by the mediator.
     */
    public void setContext(Mediator context) {
        this.context = context;
    }

    /**
     * Turns on the SmartDevice.
     */
    public void turnOn() {
        this.smartDeviceOn = true;
    }

    /**
     * Turns off the SmartDevice.
     */
    public void turnOff() {
        this.smartDeviceOn = false;
    }

    /**
     * Turns off the SmartDevice.
     *
     * @return The SmartDevice type.
     */
    public String getType() {
        return type;
    }
}
