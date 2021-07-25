/**
 * @author
 * Carlos Espinoza B92786
 * Fabiola Jimenez B23452
 * Sebastián Montero B95016
 * Kendall Lara B43707
 * Roy Muñoz B54911
 * Maria Jesús B98243
 */

package homeautomationsystem.factorymethod.behaviors;

import homeautomationsystem.factorymethod.smartdevices.SmartDevice;
import homeautomationsystem.mediator.Mediator;

import java.util.Objects;

public class BehaviorImplementation implements BehaviorInterface {
    private Mediator context;
    private SmartDevice sensor;
    private SmartDevice actuator;
    private String name;
    private Boolean active;

    public BehaviorImplementation(String name, SmartDevice sensor, SmartDevice actuator, boolean active) {
        this.name = name;
        this.sensor = sensor;
        this.actuator = actuator;
        this.active = active;
    }

    /**
     * {@inheritDoc}
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setContext(Mediator context) {
        this.context = context;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String displayBehavior() {
        String state = this.isActive() ? "active" : "deactivated";
        String result = "Behavior " + this.getName() + " is " + state;
        System.out.println(result);
        return result;
    }

    /**
     * This method helps differentiate the objects to avoid repeating them.
     *
     * @param o The object we're going to compare.
     * @return a boolean depending of the outcome.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BehaviorImplementation)) return false;
        BehaviorImplementation behavior = (BehaviorImplementation) o;
        return Objects.equals(sensor, behavior.sensor) && Objects.equals(actuator, behavior.actuator);
    }

    /**
     * This method sets the cache for the object.
     *
     * @return The hash function for that object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(sensor, actuator);
    }

    /**
     * @return The behavior's current state.
     */
    private boolean isActive() {
        return active;
    }

    /**
     * @return The behavior name
     */
    private String getName() {
        return name;
    }
}



