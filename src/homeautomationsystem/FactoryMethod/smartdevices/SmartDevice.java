package homeautomationsystem.FactoryMethod.smartdevices;

import homeautomationsystem.Mediator.Mediator;

public abstract class SmartDevice {

    public boolean smartDeviceOn = false;
    public String type;
    public Mediator context;

    /**
     * This method gives the mediator context to the class.
     *
     * @param context This context is the one given by the mediator.
     */
    public void setContext(Mediator context) {
        this.context = context;
    }

    /**
     * Turns on the SmartDevice.
     */
    public void turnOn() {
        this.smartDeviceOn = true;
    }

    /**
     * Turns off the SmartDevice.
     */
    public void turnOff() {
        this.smartDeviceOn = false;
    }

    /**
     * Turns off the SmartDevice.
     *
     * @return The SmartDevice type.
     */
    public String getType() {
        return type;
    }
}
