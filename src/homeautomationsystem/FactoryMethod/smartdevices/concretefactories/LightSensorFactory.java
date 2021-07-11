package homeautomationsystem.FactoryMethod.smartdevices.concretefactories;

import homeautomationsystem.FactoryMethod.smartdevices.SmartDevice;
import homeautomationsystem.FactoryMethod.smartdevices.SmartDeviceFactory;
import homeautomationsystem.FactoryMethod.smartdevices.implementation.sensors.LightSensor;

public class LightSensorFactory extends SmartDeviceFactory {
    @Override
    public LightSensor createSmartDevice() {
        return new LightSensor();
    }
}
