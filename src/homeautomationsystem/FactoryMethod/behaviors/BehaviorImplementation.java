package homeautomationsystem.FactoryMethod.behaviors;

import homeautomationsystem.FactoryMethod.smartdevices.SmartDevice;
import homeautomationsystem.Mediator.Mediator;

import java.util.Objects;

public class BehaviorImplementation implements BehaviorInterface {
    Mediator context;
    SmartDevice sensor;
    SmartDevice actuator;
    String name;
    Boolean active;

    public BehaviorImplementation(String name, SmartDevice sensor, SmartDevice actuator, boolean active) {
        this.name = name;
        this.sensor = sensor;
        this.actuator = actuator;
        this.active = active;
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
    public void displayBehavior() {
        String state = this.isActive() ? "activo" : "desactivado";
        System.out.println("El comportamiento " + this.getName() + " está " + state);
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



