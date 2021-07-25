/**
 * @author Carlos Espinoza B92786
 * Fabiola Jimenez B23452
 * Sebastián Montero B95016
 * Kendall Lara B43707
 * Roy Muñoz B54911
 * Maria Jesús B98243
 */

package homeautomationsystem.factorymethod.smartdevices.implementation.actuators;

import homeautomationsystem.factorymethod.smartdevices.SmartDevice;

public class DoorActuator extends SmartDevice {

    /**
     * Constructor, sets the type of the smart device
     */
    public DoorActuator() {
        this.type = "Door Actuator";
    }

    public boolean isOpen = false;

    public boolean isOpen() {
        return isOpen;
    }


    public void setOpen(boolean open) {
        isOpen = open;
    }
}
