/**
 * @author
 * Carlos Espinoza B92786
 * Fabiola Jimenez B23452
 * Sebastián Montero B95016
 * Kendall Lara B43707
 * Roy Muñoz B54911
 * Maria Jesús B98243
 */

package homeautomationsystem.factorymethod.smartdevices.concretefactories;

import homeautomationsystem.factorymethod.smartdevices.SmartDeviceFactory;
import homeautomationsystem.factorymethod.smartdevices.implementation.sensors.LightSensor;

public class LightSensorFactory extends SmartDeviceFactory {
    /**
     * {@inheritDoc}
     */
    @Override
    public LightSensor createSmartDevice() {
        return new LightSensor();
    }
}
