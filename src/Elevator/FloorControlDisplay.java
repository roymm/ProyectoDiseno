package Elevator;

import java.util.ArrayList;

public class FloorControlDisplay {
    
    private int floor;
    private ArrayList<Integer> requestedFloors;
    private String givenElevator;
    private Controller controller;

    public FloorControlDisplay(int floor, Controller controller){
        this.floor = floor;
        this.requestedFloors = new ArrayList<Integer>();
        this.givenElevator = "";
        this.controller = controller;
    }

    public void sendRequestToController(int destinationFloor){
        controller.makeRequest(this.floor, destinationFloor);
    }

    public void updateFromController(int elevatorId){
        System.out.println("Elevator " + elevatorId + " is taking the request");
    }
}
