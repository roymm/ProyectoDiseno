package Security_System;

public abstract class SecurityComponent {
    private final int id;

    public int getId() {
        return id;
    }

    SecurityComponent(int id){
        this.id = id;
    }

    abstract void changePosition(int id, Position position);
    abstract SecurityComponent identifyUser(int id);
}
