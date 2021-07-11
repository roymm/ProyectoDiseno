package homeautomationsystem.FactoryMethod.smartdevices.concretefactories;

import homeautomationsystem.FactoryMethod.smartdevices.SmartDevice;
import homeautomationsystem.FactoryMethod.smartdevices.SmartDeviceFactory;
import homeautomationsystem.FactoryMethod.smartdevices.implementation.actuators.DoorActuator;

public class DoorActuatorFactory extends SmartDeviceFactory {
    @Override
    public SmartDevice createSmartDevice() {
        return new DoorActuator();
    }
}
