package Elevator;

import java.util.ArrayList;
import java.util.List;
import java.math.*;

public class Controller {
    
    private List<FloorControlDisplay> floors;
    private List<Elevator> elevators;
    private int firstFloor;
    private int lastFloor;
    private int numberElevators;

    public Controller(int firstFloor, int lastFloor, int numberElevators){
        this.floors = new ArrayList<>();
        this.elevators = new ArrayList<>();
        this.firstFloor = firstFloor;
        this.lastFloor = lastFloor;
        this.numberElevators = numberElevators;
    }

    public void addFloor(FloorControlDisplay floorControlDisplay){
        floors.add(floorControlDisplay);
    }

    public void addElevator(Elevator elevator){
        elevators.add(elevator);
    }

    public void makeRequest(int startingFloor, int destinationFloor){
        //Get the nearest Elevator
        Elevator elevator = getNearestElevator(startingFloor);
        if(elevator != null){
            //Get the floor index of the calling floor
            int floorIndex = Math.abs(this.firstFloor) + startingFloor;
            //Get the floorControlDisplay from the list
            FloorControlDisplay floorControlDisplay = floors.get(floorIndex);
            //Update the screen
            floorControlDisplay.updateFromController(elevator.getId());
            //Change the elevator's current floor
            elevator.setCurrentFloor(destinationFloor);
        }else{
            System.out.println("Couldn't process the request");
        }
    }

    public Elevator getNearestElevator(int startingFloor){

        int nearestElevatorDistance = this.lastFloor + Math.abs(this.firstFloor) + 1;
        Elevator nearestElevator = null;
        for(int i = 0; i < this.numberElevators; i++){
            int distance = Math.abs(elevators.get(i).getCurrentFloor() - startingFloor);
            if(distance < nearestElevatorDistance){
                nearestElevatorDistance = distance;
                nearestElevator = elevators.get(i);
            }
        }
        return nearestElevator;
    }

}
