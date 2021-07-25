/**
 * @author Carlos Espinoza B92786
 *            Fabiola Jimenez B23452
 *            Sebastián Montero B95016
 *            Kendall Lara B43707
 *            Roy Muñoz B54911
 *            Maria Jesús B98243
 */

package elevator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ElevatorController {

    private Queue<ElevatorRequest> elevatorRequestQueue;
    private final List<FloorControlDisplay> floorControlDisplays;
    private List<Elevator> elevators;
    private final int firstFloor;   //First floor might be negative
    private final int lastFloor;

    /**
     * Constructor of controller.
     * The controller handles all the requests and its elevators.
     * @param firstFloor sets the first floor of the building.
     * @param lastFloor sets the last floor of the building.
     */
    public ElevatorController(int firstFloor, int lastFloor){
        this.elevatorRequestQueue = new LinkedList<>();
        this.floorControlDisplays = new ArrayList<>();
        this.elevators = new ArrayList<>();
        this.firstFloor = firstFloor;
        this.lastFloor = lastFloor;
    }

    /**
     * Constructor of controller.
     * The controller handles all the requests and its elevators.
     * @param firstFloor sets the first floor of the building.
     * @param lastFloor sets the last floor of the building.
     */
    public void addFloor(FloorControlDisplay floorControlDisplay){
        floorControlDisplays.add(floorControlDisplay);
    }

    /**
     * Adds a new elevator to the building.
     * @param elevator is the elevator to be added.
     */
    public void addElevator(Elevator elevator){
        elevators.add(elevator);
    }

    /**
     * Lists the elevators.
     */
    public List<Elevator> getElevators() {
        return elevators;
    }

    /**
     * Adds a new request for the elevators to take
     * @param requestedFloor is the floor where the person is
     * @param destinationFloor is the floor to which the person wants to go
     */
    public void addElevatorRequest(int requestedFloor, int destinationFloor){
        ElevatorRequest elevatorRequest = new ElevatorRequest(requestedFloor,destinationFloor);
        elevatorRequestQueue.add(elevatorRequest);
        processRequest(); //This could be replaced by a timer that checks constantly for new requests on the queue
    }

    /**
     * Processes a request.
     */
    private void processRequest(){
        ElevatorRequest currentElevatorRequest = elevatorRequestQueue.remove(); //Pops a request from the queue
        Elevator elevator = getNearestElevator(currentElevatorRequest.requestedFloor);  //Gets the nearest available elevator
        int floorIndex = Math.abs(this.firstFloor) + currentElevatorRequest.requestedFloor;
        FloorControlDisplay floorControlDisplay = floorControlDisplays.get(floorIndex);
        String messageToDisplay;

        if(elevator != null){
            elevator.setCurrentFloor(currentElevatorRequest.destinationFloor);
            messageToDisplay = "Elevator " + elevator.getId() + " is taking the request to go from floor " +
                    currentElevatorRequest.requestedFloor + " to floor " + currentElevatorRequest.destinationFloor;
        }
        else{
            messageToDisplay = "Couldn't process the request";
        }

        floorControlDisplay.updateFromController(messageToDisplay); //Update the screen
    }

    /**
     * Returns the nearest elevator to the floor requested.
     * @param startingFloor is the floor to which the elevator has to go.
     */
    private Elevator getNearestElevator(int startingFloor){
        int nearestElevatorDistance = this.lastFloor + Math.abs(this.firstFloor) + 1; //Maximum distance +1 to simulate infinity
        Elevator nearestElevator = null;    //Variable to store the elevator with the minimum distance

        for(Elevator currentElevator : elevators){
            int distance = Math.abs(currentElevator.getCurrentFloor() - startingFloor);

            if(distance < nearestElevatorDistance){ //If this is the nearest elevator found until now
                nearestElevatorDistance = distance;
                nearestElevator = currentElevator;
            }
        }
        return nearestElevator;
    }

}
