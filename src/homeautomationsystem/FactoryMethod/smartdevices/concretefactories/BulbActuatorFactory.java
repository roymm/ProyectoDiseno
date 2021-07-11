package homeautomationsystem.FactoryMethod.smartdevices.concretefactories;

import homeautomationsystem.FactoryMethod.smartdevices.SmartDevice;
import homeautomationsystem.FactoryMethod.smartdevices.SmartDeviceFactory;
import homeautomationsystem.FactoryMethod.smartdevices.implementation.actuators.BulbActuator;

public class BulbActuatorFactory extends SmartDeviceFactory {
    @Override
    public SmartDevice createSmartDevice() {
        return new BulbActuator();
    }
}
