package Elevator;

public class FloorControlDisplay {
    
    private final int floor;
    private final ElevatorController elevatorController;

    public FloorControlDisplay(int floor, ElevatorController elevatorController){
        this.floor = floor;
        this.elevatorController = elevatorController;
    }

    //User press a button to request an elevator
    public void sendRequestToController(int destinationFloor){
        elevatorController.addElevatorRequest(this.floor, destinationFloor);
    }

    //Shows a response from the elevator control center
    public void updateFromController(String message){
        System.out.println(message);
    }
}
