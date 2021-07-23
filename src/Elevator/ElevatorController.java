package Elevator;

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

    public ElevatorController(int firstFloor, int lastFloor){
        this.elevatorRequestQueue = new LinkedList<>();
        this.floorControlDisplays = new ArrayList<>();
        this.elevators = new ArrayList<>();
        this.firstFloor = firstFloor;
        this.lastFloor = lastFloor;
    }

    public void addFloor(FloorControlDisplay floorControlDisplay){
        floorControlDisplays.add(floorControlDisplay);
    }

    public void addElevator(Elevator elevator){
        elevators.add(elevator);
    }

    public void addElevatorRequest(int requestedFloor, int destinationFloor){
        ElevatorRequest elevatorRequest = new ElevatorRequest(requestedFloor,destinationFloor);
        elevatorRequestQueue.add(elevatorRequest);
        processRequest(); //This could be replaced by a timer that checks constantly for new requests on the queue
    }

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
