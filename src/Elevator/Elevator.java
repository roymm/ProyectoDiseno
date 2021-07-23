package Elevator;

public class Elevator {

    private int currentFloor;
    private final int id;

    public Elevator(int id) {
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

}
