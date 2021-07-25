/**
 * @author Carlos Espinoza B92786
 * Fabiola Jimenez B23452
 * Sebastián Montero B95016
 * Kendall Lara B43707
 * Roy Muñoz B54911
 * Maria Jesús B98243
 */

package homeautomationsystem.factorymethod.smartdevices.implementation.sensors;

import homeautomationsystem.factorymethod.smartdevices.SmartDevice;

public class NoiseSensor extends SmartDevice {

    /**
     * Constructor, sets the type of the smart device
     */
    public NoiseSensor() {
        this.type = "Noise Sensor";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void turnOn() {
        super.turnOn();
        this.smartDeviceOn = true;
        this.context.activateSpeakerBehavior();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void turnOff() {
        super.turnOff();
        this.smartDeviceOn = false;
        this.context.deactivateSpeakerBehavior();
    }

}
