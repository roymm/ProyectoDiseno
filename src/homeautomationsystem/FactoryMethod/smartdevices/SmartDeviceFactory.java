package homeautomationsystem.FactoryMethod.smartdevices;

public abstract class SmartDeviceFactory {

    public SmartDevice create() {

        SmartDevice sensor = createSmartDevice();


        return sensor;



    }
    public abstract SmartDevice createSmartDevice();
}
