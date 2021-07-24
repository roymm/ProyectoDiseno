package homeautomationsystem.FactoryMethod.behaviors;

import homeautomationsystem.Mediator.Mediator;

public interface BehaviorInterface {

    /**
     * This method gives the mediator context to the class.
     *
     * @param mediator This context is the one given by the mediator.
     */
    void setContext(Mediator mediator);

    /**
     * @param active Sets the behavior's state.
     */
    void setActive(boolean active);

    /**
     * This method displays in console the behavior's current state.
     */
    void displayBehavior();
}
