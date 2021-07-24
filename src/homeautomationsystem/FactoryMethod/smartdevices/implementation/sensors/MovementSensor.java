package homeautomationsystem.FactoryMethod.smartdevices.implementation.sensors;

import homeautomationsystem.FactoryMethod.smartdevices.SmartDevice;

public class MovementSensor extends SmartDevice {

    /**
     * {@inheritDoc}
     */
    @Override
    public void turnOn() {
        super.turnOn();
        this.smartDeviceOn = true;
        this.context.activateDoorBehavior();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void turnOff() {
        super.turnOff();
        this.smartDeviceOn = false;
        this.context.deactivateDoorBehavior();
    }
}
