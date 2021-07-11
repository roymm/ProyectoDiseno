package homeautomationsystem.FactoryMethod.rooms;

import homeautomationsystem.FactoryMethod.smartdevices.SmartDevice;

import java.util.List;

public class Room {
    int id;
    String nombre;
    List<SmartDevice> sensors;
    List<SmartDevice> actuators;

    public Room(int id, String nombre, List<SmartDevice> sensors, List<SmartDevice> actuators) {
        this.id = id;
        this.nombre = nombre;
        this.sensors = sensors;
        this.actuators = actuators;
    }

    public List<SmartDevice> getSensors() {
        return sensors;
    }

    public void setSensors(List<SmartDevice> sensors) {
        this.sensors = sensors;
    }

    public List<SmartDevice> getActuators() {
        return actuators;
    }

    public void setActuators(List<SmartDevice> actuators) {
        this.actuators = actuators;
    }
}
