package homeautomationsystem.FactoryMethod.smartdevices.concretefactories;

import homeautomationsystem.FactoryMethod.smartdevices.SmartDevice;
import homeautomationsystem.FactoryMethod.smartdevices.SmartDeviceFactory;
import homeautomationsystem.FactoryMethod.smartdevices.implementation.sensors.MovementSensor;

public class MovementSensorFactory extends SmartDeviceFactory  {
    @Override
    public SmartDevice createSmartDevice() {
        return new MovementSensor();
    }
}
