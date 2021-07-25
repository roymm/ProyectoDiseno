package elevator;

public class ElevatorRequest {
    public int requestedFloor;
    public int destinationFloor;

    public ElevatorRequest(int requestedFloor, int destinationFloor) {
        this.requestedFloor = requestedFloor;
        this.destinationFloor = destinationFloor;
    }
}
