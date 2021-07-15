package homeautomationsystem.FactoryMethod.smartdevices;

import homeautomationsystem.Mediator.Mediator;

public abstract class SmartDevice  {

    protected boolean smartDeviceOn;
    Mediator context;

    public void setContext(Mediator context) {
        this.context = context;
    }

    public boolean turnOn() {
        smartDeviceOn = true;
        return smartDeviceOn;
    }
}
