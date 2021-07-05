package Security_System;

import javax.swing.text.Position;

public abstract class ISecurityDevice implements SecurityComponent{
    protected int deviceID;
    protected Position position;

    @Override
    public void changePosition(Position position){
        this.position = position;
    }

    @Override
    abstract public SecurityComponent identifyUser(int id);
}
