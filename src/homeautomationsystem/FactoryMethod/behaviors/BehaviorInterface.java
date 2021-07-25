/**
 * @author
 * Carlos Espinoza B92786
 * Fabiola Jimenez B23452
 * Sebastián Montero B95016
 * Kendall Lara B43707
 * Roy Muñoz B54911
 * Maria Jesús B98243
 */

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
     * Gets the state of the behavior.
     */
    Boolean getActive();

    /**
     * This method displays in console the behavior's current state.
     */
    String displayBehavior();
}
