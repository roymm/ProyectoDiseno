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

public class MovementSensor extends SmartDevice {

    /**
     * Constructor, sets the type of the smart device
     */
    public MovementSensor() {
        this.type = "Movement Sensor";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void turnOn() {
        super.turnOn();
        this.smartDeviceOn = true;
        this.context.activateDoorBehavior();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void turnOff() {
        super.turnOff();
        this.smartDeviceOn = false;
        this.context.deactivateDoorBehavior();
    }
}
