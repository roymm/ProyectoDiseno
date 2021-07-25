package homeautomationsystem.FactoryMethod.smartdevices.implementation.actuators;

import homeautomationsystem.FactoryMethod.smartdevices.SmartDevice;

public class DoorActuator extends SmartDevice {

    /**
     * Constructor, sets the type of the smart device
     */
    public DoorActuator(){
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
