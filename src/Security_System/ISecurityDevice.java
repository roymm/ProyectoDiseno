package Security_System;

/**
 * @author Carlos Espinoza B92786
 *            Fabiola Jimenez B23452
 *            Sebastián Montero B95016
 *            Kendall Lara B43707
 *            Roy Muñoz B54911
 *            Maria Jesús B98243
 */

public abstract class ISecurityDevice extends SecurityComponent{
    protected Position position;

    ISecurityDevice(int id) {
        super(id);
    }

    @Override
    public void changePosition(int id, Position position){
        if(id == super.getId()){
            this.position = position;
        }
    }

    public Position getPosition() {
        return position;
    }

    @Override
    abstract public SecurityComponent identifyUser(int id);
}
