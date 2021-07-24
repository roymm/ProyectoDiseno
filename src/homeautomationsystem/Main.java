package homeautomationsystem;

import homeautomationsystem.FactoryMethod.behaviors.BehaviorImplementation;
import homeautomationsystem.FactoryMethod.behaviors.BehaviorInterface;
import homeautomationsystem.FactoryMethod.rooms.Room;
import homeautomationsystem.FactoryMethod.smartdevices.SmartDevice;
import homeautomationsystem.FactoryMethod.smartdevices.SmartDeviceFactory;
import homeautomationsystem.FactoryMethod.smartdevices.concretefactories.*;
import homeautomationsystem.FactoryMethod.smartdevices.implementation.actuators.BulbActuator;
import homeautomationsystem.FactoryMethod.smartdevices.implementation.actuators.DoorActuator;
import homeautomationsystem.FactoryMethod.smartdevices.implementation.actuators.SpeakerActuator;
import homeautomationsystem.FactoryMethod.smartdevices.implementation.sensors.LightSensor;
import homeautomationsystem.FactoryMethod.smartdevices.implementation.sensors.MovementSensor;
import homeautomationsystem.FactoryMethod.smartdevices.implementation.sensors.NoiseSensor;
import homeautomationsystem.Mediator.Mediator;

import java.util.*;

public class Main {

    private static final int MAX_SENSORS = 3;
    private static final int MAX_ACTUATORS = 3;

    public static void main(String[] args) {

        //TODO Esto puede ir en un método init en los tests, con las variables globales de clase necesarias.

        SmartDeviceFactory factory;

        // Creation of sensors.
        factory = new LightSensorFactory();
        SmartDevice lightSensor = factory.create();

        factory = new NoiseSensorFactory();
        SmartDevice noiseSensor = factory.create();

        factory = new MovementSensorFactory();
        SmartDevice movementSensor = factory.create();

        // Creation actuators.
        factory = new BulbActuatorFactory();
        SmartDevice bulb = factory.create();

        factory = new DoorActuatorFactory();
        SmartDevice door = factory.create();

        factory = new SpeakerActuatorFactory();
        SmartDevice speaker = factory.create();


        // Creation of behaviors.
        BehaviorInterface lightBehavior = new BehaviorImplementation("luz", lightSensor, bulb, false);
        BehaviorInterface doorBehavior = new BehaviorImplementation("puerta", movementSensor, door, false);
        BehaviorInterface musicBehavior = new BehaviorImplementation("música", noiseSensor, speaker, false);

        // Creation of rooms.
        Room kitchen = new Room(0, "cocina");

        // Creation of mediators.
        Mediator mediator = new Mediator(kitchen, (LightSensor) lightSensor, (NoiseSensor) noiseSensor, (MovementSensor) movementSensor,
                (BulbActuator) bulb, (DoorActuator) door, (SpeakerActuator) speaker, lightBehavior, doorBehavior, musicBehavior);

        // Sets the context for the room sensors.
        lightSensor.setContext(mediator);
        noiseSensor.setContext(mediator);
        movementSensor.setContext(mediator);

        // Sets the context for the room actuators.
        bulb.setContext(mediator);
        door.setContext(mediator);
        speaker.setContext(mediator);

        // Sets the context for the room behaviors.
        lightBehavior.setContext(mediator);
        doorBehavior.setContext(mediator);
        musicBehavior.setContext(mediator);

        // Sets the context for the room we're adding the Smart Devices.
        kitchen.setContext(mediator);


        // TODO.
        // En tests aquí debería de haber uno para mostrar que el bombillo está apagado.
        // Podría haber otro para mostrar que el comportamiento está desactivao.

        // Encendemos el sensor.
        lightSensor.turnOff();
        movementSensor.turnOn();

        // Y hacemos tests para mostrar que el bombillo y el comportamiento ya están activos.


        // TODO El profesor quería:
        // Crear método anadir comportamiento, debería tener la lista de comportamientos previos, para que no este duplicado,
        // deberia recibir el sensor y su respectivo actuador, en caso de que no exista manejar el error.
        // Este set no permite comportamientos con sensores y actuadores repetidos 1-1. Pero falta mejorar.
        Set<BehaviorInterface> behaviorSet = new HashSet<>();

        lightSensor.turnOn();

        behaviorSet.add(lightBehavior);
        behaviorSet.add(musicBehavior);
        behaviorSet.add(doorBehavior);

        behaviorSet.forEach(BehaviorInterface::displayBehavior);
    }
}
