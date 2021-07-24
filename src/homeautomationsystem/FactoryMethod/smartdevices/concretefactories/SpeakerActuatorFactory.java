package homeautomationsystem.FactoryMethod.smartdevices.concretefactories;

import homeautomationsystem.FactoryMethod.smartdevices.SmartDevice;
import homeautomationsystem.FactoryMethod.smartdevices.SmartDeviceFactory;
import homeautomationsystem.FactoryMethod.smartdevices.implementation.actuators.SpeakerActuator;

public class SpeakerActuatorFactory extends SmartDeviceFactory {
    /**
     * {@inheritDoc}
     */
    @Override
    public SmartDevice createSmartDevice() {
        return new SpeakerActuator();
    }
}
