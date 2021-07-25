package elevator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElevatorTest {
    final int NUM_FLOORS = 100;
    final int NUM_ELEVATORS = 4;
    final int FIRST_FLOOR = 0;

    final long RANDOM_SEED = 154549512;
    final Random rand = new Random(RANDOM_SEED);

    ElevatorController elevatorController;
    ArrayList<FloorControlDisplay> floorControlDisplayList = new ArrayList<>(NUM_FLOORS);

    @BeforeEach
    public void init(){
        elevatorController = new ElevatorController(FIRST_FLOOR,FIRST_FLOOR+NUM_FLOORS);

        for(int i = 1; i <= NUM_FLOORS; i++){
            FloorControlDisplay floorControlDisplay = new FloorControlDisplay(i, elevatorController);
            elevatorController.addFloor(floorControlDisplay);
            floorControlDisplayList.add(floorControlDisplay);
        }

        for(int i = 1; i <= NUM_ELEVATORS; i++){
            Elevator elevator = new Elevator(i,FIRST_FLOOR);
            elevatorController.addElevator(elevator);
        }
    }

    @Test
    public void AllElevatorsFloorZero_RequestFromFirstFloor(){
        int randomFloorNumber = rand.nextInt((NUM_FLOORS-1) - FIRST_FLOOR);
        floorControlDisplayList.get(0).sendRequestToController(randomFloorNumber);

        //Elevator 1 takes the request and stays at the new floor
        assertEquals(randomFloorNumber,elevatorController.getElevators().get(0).getCurrentFloor());
    }

    @Test
    public void LastElevatorFirstFloor_RequestFromFirstFloor(){
        //Random floor number excluding the first floor
        int randomFloorNumber = rand.nextInt((NUM_FLOORS-1) - FIRST_FLOOR+1);

        //Sets all the Elevators except the last one at the random floor
        for (int i = 0; i < NUM_ELEVATORS-1; i++) {
            elevatorController.getElevators().get(i).setCurrentFloor(randomFloorNumber);
        }

        floorControlDisplayList.get(0).sendRequestToController(randomFloorNumber);

        //Last elevator takes the request and stays at random floor
        assertEquals(randomFloorNumber,elevatorController.getElevators().get(NUM_ELEVATORS-1).getCurrentFloor());
    }

    @Test
    public void AllElevatorsFirstFloor_RequestFromLastFloor(){
        int randomFloorNumber = rand.nextInt((NUM_FLOORS-1) - FIRST_FLOOR);
        floorControlDisplayList.get(NUM_FLOORS-2).sendRequestToController(randomFloorNumber);

        assertEquals(randomFloorNumber,elevatorController.getElevators().get(0).getCurrentFloor());
    }

    @Test
    public void RandomElevatorNear_RequestFromRandomFloor(){
        //Random floor number excluding the first floor
        int randomFloorNumber = rand.nextInt((NUM_FLOORS-1) - FIRST_FLOOR+1);
        int randomElevatorNumber = rand.nextInt(NUM_ELEVATORS);

        //Sets a random elevator at a random floor
        elevatorController.getElevators().get(randomElevatorNumber).setCurrentFloor(randomFloorNumber);
        floorControlDisplayList.get(randomFloorNumber).sendRequestToController(FIRST_FLOOR);

        assertEquals(FIRST_FLOOR,elevatorController.getElevators().get(randomElevatorNumber).getCurrentFloor());
    }
}
