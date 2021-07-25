/**
 * @author
 * Carlos Espinoza B92786
 * Fabiola Jimenez B23452
 * Sebastián Montero B95016
 * Kendall Lara B43707
 * Roy Muñoz B54911
 * Maria Jesús B98243
 */

package homeautomationsystemTest;

import homeautomationsystem.factorymethod.behaviors.BehaviorImplementation;
import homeautomationsystem.factorymethod.behaviors.BehaviorInterface;
import homeautomationsystem.factorymethod.rooms.Room;
import homeautomationsystem.factorymethod.smartdevices.SmartDevice;
import homeautomationsystem.factorymethod.smartdevices.SmartDeviceFactory;
import homeautomationsystem.factorymethod.smartdevices.concretefactories.*;
import homeautomationsystem.factorymethod.smartdevices.implementation.actuators.BulbActuator;
import homeautomationsystem.factorymethod.smartdevices.implementation.actuators.DoorActuator;
import homeautomationsystem.factorymethod.smartdevices.implementation.actuators.SpeakerActuator;
import homeautomationsystem.factorymethod.smartdevices.implementation.sensors.LightSensor;
import homeautomationsystem.factorymethod.smartdevices.implementation.sensors.MovementSensor;
import homeautomationsystem.factorymethod.smartdevices.implementation.sensors.NoiseSensor;
import homeautomationsystem.mediator.Mediator;
import homeautomationsystem.factorymethod.rooms.Room;
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

        lightBehavior = new BehaviorImplementation("light", lightSensor, bulb, false);
        doorBehavior = new BehaviorImplementation("door", movementSensor, door, false);
        musicBehavior = new BehaviorImplementation("music", noiseSensor, speaker, false);

        mediator = new Mediator(kitchen, (LightSensor) lightSensor, (NoiseSensor) noiseSensor, (MovementSensor) movementSensor,
                (BulbActuator) bulb, (DoorActuator) door, (SpeakerActuator) speaker, lightBehavior, doorBehavior, musicBehavior);

        lightSensor.setContext(mediator);
        noiseSensor.setContext(mediator);
        movementSensor.setContext(mediator);

        bulb.setContext(mediator);
        door.setContext(mediator);
        speaker.setContext(mediator);

        lightBehavior.setContext(mediator);
        doorBehavior.setContext(mediator);
        musicBehavior.setContext(mediator);

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