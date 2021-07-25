/**
 * @author Carlos Espinoza B92786
 *            Fabiola Jimenez B23452
 *            Sebastián Montero B95016
 *            Kendall Lara B43707
 *            Roy Muñoz B54911
 *            Maria Jesús B98243
 */

package elevator;

public class Elevator {

    private int currentFloor;
    private final int id;

    /**
     * Constructor for the elevator.
     * @param id The id of the elevator.
     */
    public Elevator(int id) {
        this.id = id;
    }

    /**
     * Constructor for the elevator.
     * @param id The id of the elevator.
     * @param currentFloor sets the current floor on which the elevator starts.
     */
    public Elevator(int id, int currentFloor) {
        this.currentFloor = currentFloor;
        this.id = id;
    }

    /**
     * Gets the id of the elevator.
     * @return The id of the elevator.
     */
    public int getId(){
        return this.id;
    }

    /**
     * Gets the current floor of the elevator.
     * @return The current floor of the elevator.
     */
    public int getCurrentFloor() {
        return currentFloor;
    }

    /**
     * Sets the current floor of the elvator
     */
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

}
