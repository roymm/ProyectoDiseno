package homeautomationsystem.Mediator;

import homeautomationsystem.FactoryMethod.smartdevices.SmartDevice;

public class Mediator {

    private SmartDevice lightSensor;
    private SmartDevice noiseSensor;
    private SmartDevice movementSensor;

    private SmartDevice bulbActuator;
    private SmartDevice doorActuator;
    private SmartDevice speakerActuator;

    public Mediator(SmartDevice lightSensor, SmartDevice noiseSensor, SmartDevice movementSensor,
                    SmartDevice bulbActuator, SmartDevice doorActuator, SmartDevice speakerActuator) {
        this.lightSensor = lightSensor;
        this.noiseSensor = noiseSensor;
        this.movementSensor = movementSensor;
        this.bulbActuator = bulbActuator;
        this.doorActuator = doorActuator;
        this.speakerActuator = speakerActuator;
    }

//    private void openDoor() {
//        doorActuator
//    }
//
//    private void closeDoor() {
//        doorActuator.closeDoor();
//    }


}
