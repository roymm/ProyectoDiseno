package homeautomationsystem.FactoryMethod.rooms;

import homeautomationsystem.Mediator.Mediator;

public class Room {
    int id;
    String nombre;
    Mediator context;

    public Room(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public void setContext(Mediator context) {
        this.context = context;
    }

    public void turnRoomLight() throws Exception {
        context.turnLightActuator(id);
        context.turnLightSensor(id);
    }
}
