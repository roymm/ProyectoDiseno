package homeautomationsystem.FactoryMethod.smartdevices.concretefactories;

import homeautomationsystem.FactoryMethod.smartdevices.SmartDevice;
import homeautomationsystem.FactoryMethod.smartdevices.SmartDeviceFactory;
import homeautomationsystem.FactoryMethod.smartdevices.implementation.sensors.NoiseSensor;

public class NoiseSensorFactory extends SmartDeviceFactory {
    @Override
    public SmartDevice createSmartDevice() {
        return new NoiseSensor();
    }
}
