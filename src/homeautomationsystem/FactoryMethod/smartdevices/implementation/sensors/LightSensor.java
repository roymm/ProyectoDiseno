package homeautomationsystem.FactoryMethod.smartdevices.implementation.sensors;

import homeautomationsystem.FactoryMethod.smartdevices.SmartDevice;

public class LightSensor extends SmartDevice {


    boolean isTurnedOn;

    public void turnOff() {}

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    @Override
    public boolean turnOn() {
        super.turnOn();

        return true;
    }
}
