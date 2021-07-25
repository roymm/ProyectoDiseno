/**
 * @author
 * Carlos Espinoza B92786
 * Fabiola Jimenez B23452
 * Sebastián Montero B95016
 * Kendall Lara B43707
 * Roy Muñoz B54911
 * Maria Jesús B98243
 */

package homeautomationsystem.FactoryMethod.smartdevices.concretefactories;

import homeautomationsystem.FactoryMethod.smartdevices.SmartDevice;
import homeautomationsystem.FactoryMethod.smartdevices.SmartDeviceFactory;
import homeautomationsystem.FactoryMethod.smartdevices.implementation.sensors.NoiseSensor;

public class NoiseSensorFactory extends SmartDeviceFactory {
    /**
     * {@inheritDoc}
     */
    @Override
    public SmartDevice createSmartDevice() {
        return new NoiseSensor();
    }
}
