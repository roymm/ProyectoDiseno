/**
 * @author Carlos Espinoza B92786
 * Fabiola Jimenez B23452
 * Sebastián Montero B95016
 * Kendall Lara B43707
 * Roy Muñoz B54911
 * Maria Jesús B98243
 */

package homeautomationsystem.mediator;

import homeautomationsystem.factorymethod.behaviors.BehaviorInterface;
import homeautomationsystem.factorymethod.rooms.Room;
import homeautomationsystem.factorymethod.smartdevices.implementation.actuators.BulbActuator;
import homeautomationsystem.factorymethod.smartdevices.implementation.actuators.DoorActuator;
import homeautomationsystem.factorymethod.smartdevices.implementation.actuators.SpeakerActuator;
import homeautomationsystem.factorymethod.smartdevices.implementation.sensors.LightSensor;
import homeautomationsystem.factorymethod.smartdevices.implementation.sensors.MovementSensor;
import homeautomationsystem.factorymethod.smartdevices.implementation.sensors.NoiseSensor;

import java.util.HashSet;
import java.util.Set;

public class Mediator {

    private final Room room;

    private LightSensor lightSensor;
    private NoiseSensor noiseSensor;
    private MovementSensor movementSensor;

    private final BulbActuator bulbActuator;
    private final DoorActuator doorActuator;
    private final SpeakerActuator speakerActuator;

    private final BehaviorInterface turnBulbWhenSensorOn;
    private final BehaviorInterface openDoorWhenMovementOn;
    private final BehaviorInterface turnSpeakerWhenSoundOn;

    public Set<BehaviorInterface> behaviorSet = new HashSet<>();

    public Mediator(Room room, LightSensor lightSensor, NoiseSensor noiseSensor, MovementSensor movementSensor, BulbActuator bulbActuator,
                    DoorActuator doorActuator, SpeakerActuator speakerActuator, BehaviorInterface turnBulbWhenSensorOn,
                    BehaviorInterface openDoorWhenMovementOn, BehaviorInterface turnSpeakerWhenSoundOn) {
        this.room = room;
        this.lightSensor = lightSensor;
        this.noiseSensor = noiseSensor;
        this.movementSensor = movementSensor;
        this.bulbActuator = bulbActuator;
        this.doorActuator = doorActuator;
        this.speakerActuator = speakerActuator;
        this.turnBulbWhenSensorOn = turnBulbWhenSensorOn;
        this.openDoorWhenMovementOn = openDoorWhenMovementOn;
        this.turnSpeakerWhenSoundOn = turnSpeakerWhenSoundOn;
    }

    /**
     * This method activates the bulb's behavior
     */
    public void activateBulbBehavior() {
        this.turnBulbWhenSensorOn.setActive(true);
        this.bulbActuator.turnOn();
    }

    /**
     * This method deactivates the bulb's behavior
     */
    public void deactivateBulbBehavior() {
        this.turnBulbWhenSensorOn.setActive(false);
        this.bulbActuator.turnOff();
    }

    public void activateDoorBehavior() {
        this.openDoorWhenMovementOn.setActive(true);
        this.doorActuator.setOpen(true);
    }

    public void deactivateDoorBehavior() {
        this.openDoorWhenMovementOn.setActive(false);
        this.doorActuator.setOpen(false);
    }

    public void activateSpeakerBehavior() {
        this.turnSpeakerWhenSoundOn.setActive(true);
        this.speakerActuator.turnOn();
    }

    public void deactivateSpeakerBehavior() {
        this.turnSpeakerWhenSoundOn.setActive(false);
        this.speakerActuator.turnOff();
    }
}
