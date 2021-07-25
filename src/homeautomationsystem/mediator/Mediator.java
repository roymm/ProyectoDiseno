/**
 * @author
 * Carlos Espinoza B92786
 * Fabiola Jimenez B23452
 * Sebastián Montero B95016
 * Kendall Lara B43707
 * Roy Muñoz B54911
 * Maria Jesús B98243
 */

package homeautomationsystem.Mediator;

import homeautomationsystem.FactoryMethod.behaviors.BehaviorInterface;
import homeautomationsystem.FactoryMethod.rooms.Room;
import homeautomationsystem.FactoryMethod.smartdevices.implementation.actuators.BulbActuator;
import homeautomationsystem.FactoryMethod.smartdevices.implementation.actuators.DoorActuator;
import homeautomationsystem.FactoryMethod.smartdevices.implementation.actuators.SpeakerActuator;
import homeautomationsystem.FactoryMethod.smartdevices.implementation.sensors.LightSensor;
import homeautomationsystem.FactoryMethod.smartdevices.implementation.sensors.MovementSensor;
import homeautomationsystem.FactoryMethod.smartdevices.implementation.sensors.NoiseSensor;

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

    //TODO Los nombres de los métodos son self explanatory, por lo que hay que considerar si son necesarios o no.

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
