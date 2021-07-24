package Security_System;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Carlos Espinoza B92786
 *            Fabiola Jimenez B23452
 *            Sebastián Montero B95016
 *            Kendall Lara B43707
 *            Roy Muñoz B54911
 *            Maria Jesús B98243
 */

public class DeviceCollection extends SecurityComponent {
    private List<SecurityComponent> children;

    DeviceCollection(int id) {
        super(id);
        children = new LinkedList<>();
    }

    @Override
    public void changePosition(int id, Position position) {
        if(id == super.getId()){
            for (SecurityComponent child : children) {
                child.changePosition(child.getId(),position);
            }
        }
        else {
            for (SecurityComponent child : children) {
                child.changePosition(id, position);
            }
        }
    }

    @Override
    public SecurityComponent identifyUser(int id) {
        for (SecurityComponent child : children) {
            if(child.identifyUser(id) != null){
                return child;
            }
        }
        return null;
    }

    public void addChild(SecurityComponent child){
        children.add(child);
    }

    public void setChildren(List<SecurityComponent> children) {
        this.children = children;
    }

    public List<SecurityComponent> getChildren() {
        return children;
    }
}
