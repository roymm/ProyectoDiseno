package Elevator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ElevatorController {
    private Queue<Request> requestQueue;
    private final List<FloorControlDisplay> floorControlDisplays;
    private List<Elevator> elevators;
    private final int firstFloor;   //First floor might be negative
    private final int lastFloor;

    public ElevatorController(int firstFloor, int lastFloor){
        this.requestQueue = new LinkedList<>();
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
        Request request = new Request(requestedFloor,destinationFloor);
        requestQueue.add(request);
        processRequest(); //This could be replaced by a timer that checks constantly for new requests on the queue
    }

    private void processRequest(){
        Request currentRequest = requestQueue.remove();

        Elevator elevator = getNearestElevator(currentRequest.requestedFloor);

        if(elevator != null){
            int floorIndex = Math.abs(this.firstFloor) + currentRequest.requestedFloor;
            FloorControlDisplay floorControlDisplay = floorControlDisplays.get(floorIndex);
            floorControlDisplay.updateFromController(elevator.getId()); //Update the screen
            elevator.setCurrentFloor(currentRequest.destinationFloor);
        }
        else{
            System.out.println("Couldn't process the request");
        }
    }

    private Elevator getNearestElevator(int startingFloor){

        //Maximum distance +1 to simulate infinity in the algorithm
        int nearestElevatorDistance = this.lastFloor + Math.abs(this.firstFloor) + 1;
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
