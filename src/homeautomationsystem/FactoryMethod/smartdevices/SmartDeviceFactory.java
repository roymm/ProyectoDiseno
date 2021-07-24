package homeautomationsystem.FactoryMethod.smartdevices;

public abstract class SmartDeviceFactory {

    /**
     * This method is a Factory Method.
     * @return The SmartDevice we want to create.
     */
    public SmartDevice create() {
        return createSmartDevice();
    }

    /**
     * This methods is overrided by each concrete factory.
     * @return The created Smart Device.
     */
    public abstract SmartDevice createSmartDevice();
}
