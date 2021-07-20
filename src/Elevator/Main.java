package Elevator;

import java.util.ArrayList;

public class Main {
    

    public static void main(String[] args){
        
        final int FLOORS = 10;
        final int ELEVATORS = 4;
        
        Controller controller = new Controller(0,10, ELEVATORS);
        ArrayList<FloorControlDisplay> floors = new ArrayList<>();
        for(int i = 1; i <= FLOORS; i++){
            FloorControlDisplay floorControlDisplay = new FloorControlDisplay(i, controller);
            controller.addFloor(floorControlDisplay);
            floors.add(floorControlDisplay);
        }

        for(int i = 1; i <= ELEVATORS; i++){
            Elevator elevator = new Elevator(i);
            controller.addElevator(elevator);
        }


        controller.makeRequest(1, 3);
        controller.makeRequest(1, 7);
        floors.get(2).sendRequestToController(5);

    }

}
