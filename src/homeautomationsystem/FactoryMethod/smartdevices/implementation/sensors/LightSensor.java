package homeautomationsystem.FactoryMethod.smartdevices.implementation.sensors;

import homeautomationsystem.FactoryMethod.smartdevices.SmartDevice;

public class LightSensor extends SmartDevice {

//    @Override
//    public void setType(String type) {
//        super.setType(type);
//        this.type = "luz";
//    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void turnOn() {
        super.turnOn();
        this.smartDeviceOn = true;
        this.context.deactivateBulbBehavior();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void turnOff() {
        super.turnOff();
        this.smartDeviceOn = false;
        this.context.activateBulbBehavior();
    }
}
