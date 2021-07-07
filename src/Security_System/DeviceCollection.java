package Security_System;

import java.util.List;

public class DeviceCollection extends SecurityComponent {
    private List<SecurityComponent> children;

    DeviceCollection(int id) {
        super(id);
    }

    @Override
    public void changePosition(Position position) {
        for (SecurityComponent child : children) {
            child.changePosition(position);
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

    public void setChildren(List<SecurityComponent> children) {
        this.children = children;
    }

    public List<SecurityComponent> getChildren() {
        return children;
    }
}
