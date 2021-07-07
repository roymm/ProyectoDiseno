package Security_System;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SecurityCenterTest {
    SecurityCenter securityCenter;
    DeviceCollection evenCamerasCollection;
    DeviceCollection oddCamerasCollection;

    @BeforeEach
    void init(){
        securityCenter = new SecurityCenter();
        Person person1 = new Person(1);
        Person person2 = new Person(2);
        Person person3 = new Person(3);
        Person person4 = new Person(4);

        List<Person> listEvenPerson = new ArrayList<>();
        List<Person> listOddPerson = new ArrayList<>();

        listEvenPerson.add(person2);
        listEvenPerson.add(person4);
        listOddPerson.add(person1);
        listOddPerson.add(person3);

        SecurityComponent camera1 = new Camera(1,listOddPerson);
        SecurityComponent camera2 = new Camera(2,listEvenPerson);
        SecurityComponent camera3 = new Camera(3,listOddPerson);
        SecurityComponent camera4 = new Camera(4,listEvenPerson);

        evenCamerasCollection = new DeviceCollection(10);
        oddCamerasCollection = new DeviceCollection(11);

        List<SecurityComponent> evenCamerasList = new LinkedList<>();
        evenCamerasList.add(camera2);
        evenCamerasList.add(camera4);
        evenCamerasCollection.setChildren(evenCamerasList);

        List<SecurityComponent> oddCamerasList = new LinkedList<>();
        evenCamerasList.add(camera1);
        evenCamerasList.add(camera3);
        oddCamerasCollection.setChildren(oddCamerasList);

    }

    @Test
    void registerComponent() {
        securityCenter.registerComponent(evenCamerasCollection);
        securityCenter.registerComponent(oddCamerasCollection);

        assertTrue(securityCenter.getSubscribers().contains(evenCamerasCollection));
        assertTrue(securityCenter.getSubscribers().contains(oddCamerasCollection));

    }

    @Test
    void deleteComponent() {
        SecurityCenter securityCenter = new SecurityCenter();
        securityCenter.registerComponent(evenCamerasCollection);
        securityCenter.registerComponent(oddCamerasCollection);

        securityCenter.deleteComponent(oddCamerasCollection);

        assertTrue(securityCenter.getSubscribers().contains(evenCamerasCollection));
        assertEquals(1, securityCenter.getSubscribers().size());
    }

    @Test
    void identifyPerson() {
        securityCenter.registerComponent(evenCamerasCollection);
        assertNotNull(securityCenter.identifyPerson(2));
    }

    @Test
    void changePosition() {
        ISecurityDevice camera5 = new Camera(5,null);
        securityCenter.registerComponent(camera5);
        securityCenter.changePosition(Position.CENTER,5);
        assertEquals(Position.CENTER,camera5.getPosition());

    }
}