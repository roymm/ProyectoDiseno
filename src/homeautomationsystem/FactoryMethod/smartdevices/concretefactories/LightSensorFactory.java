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

import homeautomationsystem.FactoryMethod.smartdevices.SmartDeviceFactory;
import homeautomationsystem.FactoryMethod.smartdevices.implementation.sensors.LightSensor;

public class LightSensorFactory extends SmartDeviceFactory {
    /**
     * {@inheritDoc}
     */
    @Override
    public LightSensor createSmartDevice() {
        return new LightSensor();
    }
}
