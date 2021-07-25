package homeautomationsystem;

import homeautomationsystem.FactoryMethod.rooms.Room;
import homeautomationsystem.FactoryMethod.smartdevices.SmartDevice;
import homeautomationsystem.FactoryMethod.smartdevices.SmartDeviceFactory;
import homeautomationsystem.FactoryMethod.smartdevices.concretefactories.BulbActuatorFactory;
import homeautomationsystem.FactoryMethod.smartdevices.concretefactories.LightSensorFactory;
import homeautomationsystem.Mediator.Mediator;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int MAX_SENSORS = 3;
    private static final int MAX_ACTUATORS = 3;

    public static void main(String[] args) throws Exception {

         List<SmartDevice> lightSensorList = new ArrayList<>();
         List<SmartDevice> noiseSensorList = new ArrayList<>();
         List<SmartDevice> movementSensorList = new ArrayList<>();

         List<SmartDevice> bulbActuatorList = new ArrayList<>();
         List<SmartDevice> doorActuatorList = new ArrayList<>();
         List<SmartDevice> speakerActuatorList = new ArrayList<>();

        SmartDeviceFactory factory;

        // Creates light sensor.
        factory = new LightSensorFactory();
        SmartDevice lightSensor = factory.create();

        // Creates bulb actuator.
        factory = new BulbActuatorFactory();
        SmartDevice bulb = factory.create();

        // Creates room.
        Room kitchen = new Room(0, "cocina");

        // Adds smart devices to the respective lists.
        lightSensorList.add(lightSensor);
        bulbActuatorList.add(bulb);

        Mediator mediator = new Mediator(lightSensorList, bulbActuatorList);

        // Sets the context for a room.
        lightSensor.setContext(mediator);
        bulb.setContext(mediator);
        kitchen.setContext(mediator);

        kitchen.turnRoomLight();

        bulbActuatorList.size();

    }
}
