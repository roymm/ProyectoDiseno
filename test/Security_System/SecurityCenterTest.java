package Security_System;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SecurityCenterTest {
    private final int NUM_CAMERAS = 10;
    private final int NUM_CAMERA_GROUPS = 2;
    private final int NUM_PEOPLE = 100;

    private SecurityCenter securityCenter = new SecurityCenter();
    List<Person> people = new ArrayList<>(NUM_PEOPLE);
    List<Camera> securityComponents = new ArrayList<>(NUM_CAMERAS);
    List<DeviceCollection> deviceCollections = new ArrayList<>(NUM_CAMERA_GROUPS);

    @BeforeEach
    void init(){

        for (int i = 0; i < NUM_CAMERAS; i++){
            Camera testCamera = new Camera(i);
            securityComponents.add(testCamera);
        }

        for (int i = 0; i < NUM_PEOPLE; i++){
            Person person = new Person(i);
            people.add(person);
            securityComponents.get(i % NUM_CAMERAS).addIdentifiedPerson(person);
        }

        for(int i = 0; i < NUM_CAMERA_GROUPS; i++){
            DeviceCollection deviceCollection = new DeviceCollection(NUM_CAMERAS+(i+1));
            deviceCollections.add(deviceCollection);
        }

        for(int i = 0; i < NUM_CAMERAS; i++){
            deviceCollections.get(i % NUM_CAMERA_GROUPS).addChild(securityComponents.get(i));
        }

    }

    @Test
    void registerComponent() {
        for(SecurityComponent securityComponent : deviceCollections){
            securityCenter.registerComponent(securityComponent);
        }

        assertEquals(securityCenter.getSubscribers().size(),NUM_CAMERA_GROUPS);
    }

    @Test
    void deleteComponent() {
        registerComponent();

        securityCenter.deleteComponent(deviceCollections.get(0));
        assertEquals(NUM_CAMERA_GROUPS - 1, securityCenter.getSubscribers().size());
    }

    @Test
    void deleteAllComponent() {
        registerComponent();

        for(SecurityComponent securityComponent : deviceCollections){
            securityCenter.deleteComponent(securityComponent);
        }
        assertEquals(0,securityCenter.getSubscribers().size());
    }

    @Test
    void identifyPerson() {
        registerComponent();
        SecurityComponent cameraSeeingPerson = securityCenter.identifyPerson(people.get(0).getIdNumber());
        SecurityComponent expectedCamera = securityComponents.get(0);
        assertEquals(expectedCamera,cameraSeeingPerson);
    }

    @Test
    void identifyAllPeople() {
        registerComponent();

        for (Person person : people){
            assertNotNull(securityCenter.identifyPerson(person.getIdNumber()));
        }

    }

    @Test
    void changeCameraPosition() {
        registerComponent();

        securityCenter.changePosition(Position.LEFT,securityComponents.get(0).getId());

        assertEquals(securityComponents.get(0).position, Position.LEFT);
    }

    @Test
    void changeCollectionPosition() {
        registerComponent();

        securityCenter.changePosition(Position.CENTER,deviceCollections.get(0).getId());

        for(int i = 0; i < deviceCollections.get(0).getChildren().size(); i++){
            ISecurityDevice camera = (ISecurityDevice) deviceCollections.get(0).getChildren().get(i);
            assertEquals(camera.getPosition(), Position.CENTER);
        }
    }

}