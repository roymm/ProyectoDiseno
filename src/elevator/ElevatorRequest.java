/**
 * @author Carlos Espinoza B92786
 *            Fabiola Jimenez B23452
 *            Sebastián Montero B95016
 *            Kendall Lara B43707
 *            Roy Muñoz B54911
 *            Maria Jesús B98243
 */

package elevator;

public class ElevatorRequest {
    public int requestedFloor;
    public int destinationFloor;

    /**
     * Returns the nearest elevator to the floor requested.
     * @param startingFloor is the floor to which the elevator has to go.
     */
    public ElevatorRequest(int requestedFloor, int destinationFloor) {
        this.requestedFloor = requestedFloor;
        this.destinationFloor = destinationFloor;
    }
}
