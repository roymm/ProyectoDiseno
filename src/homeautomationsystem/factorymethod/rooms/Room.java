/**
 * @author Carlos Espinoza B92786
 * Fabiola Jimenez B23452
 * Sebastián Montero B95016
 * Kendall Lara B43707
 * Roy Muñoz B54911
 * Maria Jesús B98243
 */

package homeautomationsystem.factorymethod.rooms;

import homeautomationsystem.mediator.Mediator;

public class Room {
    private int id;
    private Mediator context;
    private String name;

    public Room(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * This method gives the mediator context to the class.
     *
     * @param context This context is the one given by the mediator.
     */
    public void setContext(Mediator context) {
        this.context = context;
    }

    /**
     * @return The room's unique id.
     */
    private int getId() {
        return id;
    }
}
