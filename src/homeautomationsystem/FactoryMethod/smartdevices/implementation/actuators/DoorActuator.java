package homeautomationsystem.FactoryMethod.smartdevices.implementation.actuators;

import homeautomationsystem.FactoryMethod.smartdevices.SmartDevice;

public class DoorActuator extends SmartDevice {

    public boolean isOpen = false;

    public boolean isOpen() {
        return isOpen;
    }


    public void setOpen(boolean open) {
        isOpen = open;
    }
}
