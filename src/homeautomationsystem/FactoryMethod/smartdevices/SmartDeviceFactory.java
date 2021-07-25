/**
 * @author
 * Carlos Espinoza B92786
 * Fabiola Jimenez B23452
 * Sebastián Montero B95016
 * Kendall Lara B43707
 * Roy Muñoz B54911
 * Maria Jesús B98243
 */

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
