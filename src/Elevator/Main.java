package Elevator;

import java.util.ArrayList;

public class Main {
    

    public static void main(String[] args){
        
        final int FLOORS = 100;
        final int ELEVATORS = 4;
        
        ElevatorController elevatorController = new ElevatorController(0,100);
        ArrayList<FloorControlDisplay> floors = new ArrayList<>();
        for(int i = 1; i <= FLOORS; i++){
            FloorControlDisplay floorControlDisplay = new FloorControlDisplay(i, elevatorController);
            elevatorController.addFloor(floorControlDisplay);
            floors.add(floorControlDisplay);
        }

        for(int i = 1; i <= ELEVATORS; i++){
            Elevator elevator = new Elevator(i);
            elevatorController.addElevator(elevator);
        }


        elevatorController.addElevatorRequest(1, 3);
        elevatorController.addElevatorRequest(1, 7);
        floors.get(2).sendRequestToController(5);

    }

}
