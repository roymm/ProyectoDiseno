/**
 * @author Carlos Espinoza B92786
 *            Fabiola Jimenez B23452
 *            Sebastián Montero B95016
 *            Kendall Lara B43707
 *            Roy Muñoz B54911
 *            Maria Jesús B98243
 */

package elevator;

public class FloorControlDisplay {
    
    private final int floor;
    private final ElevatorController elevatorController;

    /**
     * Constructor for the display.
     * @param floor is the fllor where the display its located.
     * @param elevatorController is the controller to which it is associated.
     */
    public FloorControlDisplay(int floor, ElevatorController elevatorController){
        this.floor = floor;
        this.elevatorController = elevatorController;
    }

    /**
     * Is the equivalent to when a user presses a button to request an elevator
     * @param destinationFloor is the floor to where the user wants to go.
     */
    public void sendRequestToController(int destinationFloor){
        elevatorController.addElevatorRequest(this.floor, destinationFloor);
    }

    /**
     * Shows a response from the elevator control center
     * @param message is the response message from the controller.
     */
    public void updateFromController(String message){
        System.out.println(message);
    }
}
