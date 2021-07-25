package homeautomationsystemTest;

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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeAutomationSystemTest {

    // We declare all of our used variables.
    Room kitchen;
    SmartDeviceFactory factory;
    SmartDevice lightSensor;
    SmartDevice noiseSensor;
    SmartDevice movementSensor;
    SmartDevice bulb;
    DoorActuator door;
    SmartDevice speaker;
    BehaviorInterface lightBehavior;
    BehaviorInterface doorBehavior;
    BehaviorInterface musicBehavior;
    Mediator mediator;


    /**
     * Handles the creation of all of the sensors and the actuators for this test
     */
    @BeforeEach
    public void init() {
        // Creates sensors and actuators.
        factory = new LightSensorFactory();
        lightSensor = factory.create();
        factory = new NoiseSensorFactory();
        noiseSensor = factory.create();
        factory = new MovementSensorFactory();
        movementSensor = factory.create();
        factory = new BulbActuatorFactory();
        bulb = factory.create();
        factory = new DoorActuatorFactory();
        door = (DoorActuator) factory.create();
        factory = new SpeakerActuatorFactory();
        speaker = factory.create();
        kitchen = new Room(1, "kitchen");

        // Creates behaviors.
        lightBehavior = new BehaviorImplementation("light", lightSensor, bulb, false);
        doorBehavior = new BehaviorImplementation("door", movementSensor, door, false);
        musicBehavior = new BehaviorImplementation("music", noiseSensor, speaker, false);

        // Creates mediator.
        mediator = new Mediator(kitchen, (LightSensor) lightSensor, (NoiseSensor) noiseSensor, (MovementSensor) movementSensor,
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
    }

    /**
     * Tests the creation of sensors using their own concrete factory.
     * Each type should be the sema as their constructor specifies.
     */
    @Test
    public void testSensorCreation() {
        assertEquals(lightSensor.getType(), "Light Sensor");
        assertEquals(noiseSensor.getType(), "Noise Sensor");
        assertEquals(movementSensor.getType(), "Movement Sensor");
    }

    /**
     * Tests the creation of actuators using their own concrete factory.
     * Each type should be the sema as their constructor specifies.
     */
    @Test
    public void testActuatorCreation() {
        assertEquals(bulb.getType(), "Bulb Actuator");
        assertEquals(door.getType(), "Door Actuator");
        assertEquals(speaker.getType(), "Speaker Actuator");
    }

    /**
     * Tests the creation of behaviors.
     * Each behavior should be created deactivated.
     */
    @Test
    public void testBehaviorCreation() {
        BehaviorInterface lightBehavior = new BehaviorImplementation("light", lightSensor, bulb, false);
        BehaviorInterface doorBehavior = new BehaviorImplementation("door", movementSensor, door, false);
        BehaviorInterface musicBehavior = new BehaviorImplementation("music", noiseSensor, speaker, false);

        assertEquals(lightBehavior.displayBehavior(), "Behavior light is deactivated");
        assertEquals(doorBehavior.displayBehavior(), "Behavior door is deactivated");
        assertEquals(musicBehavior.displayBehavior(), "Behavior music is deactivated");
    }

    /**
     * Displays the state of the behaviors
     */
    @Test
    public void displayBehaviors() {
        mediator.behaviorSet.add(lightBehavior);
        mediator.behaviorSet.add(musicBehavior);
        mediator.behaviorSet.add(doorBehavior);
        mediator.behaviorSet.forEach(BehaviorInterface::displayBehavior);
    }

    /**
     * Tests the interactions of a behavior light through the mediator
     */
    @Test
    public void testLightBehavior() {

        lightSensor.turnOn();
        // When the light is on, the bulb is off.
        assertFalse(bulb.smartDeviceOn);
        // When the light is off, the behavior should be deactivated.
        assertFalse(lightBehavior.getActive());

        lightSensor.turnOff();
        // When the light is off, the bulb is on.
        assertTrue(bulb.smartDeviceOn);
        // When the light is off, the behavior should be activated.
        assertTrue(lightBehavior.getActive());
    }

    /**
     * Tests the interactions of behavior movement through the mediator
     */
    @Test
    public void testMovementBehavior() {
        movementSensor.turnOn();
        //When there is movement, open the door.
        assertTrue(door.isOpen());
        //When there is movement, the behavior should be activated.
        assertTrue(doorBehavior.getActive());
    }

}