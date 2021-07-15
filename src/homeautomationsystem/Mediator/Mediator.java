package homeautomationsystem.Mediator;

import homeautomationsystem.FactoryMethod.smartdevices.SmartDevice;

import java.util.List;

public class Mediator {

    private List<SmartDevice> lightSensor;
    private List<SmartDevice> noiseSensor;
    private List<SmartDevice> movementSensor;

    private List<SmartDevice> bulbActuator;
    private List<SmartDevice> doorActuator;
    private List<SmartDevice> speakerActuator;

    public Mediator(List<SmartDevice> lightSensor, List<SmartDevice> noiseSensor, List<SmartDevice> movementSensor,
                    List<SmartDevice> bulbActuator, List<SmartDevice> doorActuator, List<SmartDevice> speakerActuator) {
        this.lightSensor = lightSensor;
        this.bulbActuator = bulbActuator;
    }

    public Mediator(List<SmartDevice> lightSensor, List<SmartDevice> bulbActuator) {
        this.lightSensor = lightSensor;
        this.bulbActuator = bulbActuator;
    }

    public void turnLightActuator(int index) throws Exception {
        try{
            this.bulbActuator.get(index).turnOn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void turnLightSensor(int index) {
        this.lightSensor.get(index).turnOn();
    }
}
