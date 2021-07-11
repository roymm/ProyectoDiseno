package homeautomationsystem;

import homeautomationsystem.FactoryMethod.rooms.Room;
import homeautomationsystem.FactoryMethod.smartdevices.SmartDevice;
import homeautomationsystem.FactoryMethod.smartdevices.SmartDeviceFactory;
import homeautomationsystem.FactoryMethod.smartdevices.concretefactories.LightSensorFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {

//    SmartDevice lightSensor;
//    SmartDevice noiseSensor;
//    SmartDevice movementSensor;
//
//    SmartDevice bulbActuator;
//    SmartDevice doorActuator;
//    SmartDevice speakerActuator;

    private static final int MAX_SENSORS = 3;
    private static final int MAX_ACTUATORS = 3;

    private static final List<SmartDevice> sensors = new ArrayList<>();
    private static final List<SmartDevice> actuators = new ArrayList<>();


    public static void main(String[] args) {

        SmartDeviceFactory factory = new LightSensorFactory();
        SmartDevice lightSensor = factory.create();

        boolean x = lightSensor.ponerMandos();


        Room kitchen = new Room(1, "kitchen 1", sensors, actuators);

        System.out.println(kitchen.getSensors().size());

    }
}
