package Security_System;

public abstract class ISecurityDevice extends SecurityComponent{
    protected Position position;

    ISecurityDevice(int id) {
        super(id);
    }

    @Override
    public void changePosition(Position position){
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    abstract public SecurityComponent identifyUser(int id);
}
