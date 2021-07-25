/**
 * @author Carlos Espinoza B92786
 * Fabiola Jimenez B23452
 * Sebastián Montero B95016
 * Kendall Lara B43707
 * Roy Muñoz B54911
 * Maria Jesús B98243
 */
package securitysystem.controlcenter;

import java.util.LinkedList;
import java.util.List;

/**
 * Collection of SecurityDevices. Can contain Cameras or other DeviceCollections
 */
public class DeviceCollection extends SecurityComponent {
    private List<SecurityComponent> children;

    public DeviceCollection(int id) {
        super(id);
        children = new LinkedList<>();
    }

    /**
     * Sets all his children's positions or search for a specific children to move, it depends on the id of the request.
     * @param id is the id of the camera
     * @param position is the position to which the cameras have to move.
     */
    @Override
    public void changePosition(int id, Position position) {
        if (id == super.getId()) {    // If the requested id to move is the collection's id.
            for (SecurityComponent child : children) {
                child.changePosition(child.getId(), position);
            }
        } else {  // If not, searches for a child with the requested id.
            for (SecurityComponent child : children) {
                child.changePosition(id, position);
            }
        }
    }

    /**
     * Pass the request to identify a user to all its children
     * @param id is the id of the user
     */
    @Override
    public SecurityComponent identifyUser(int id) {
        for (SecurityComponent child : children) {
            if (child.identifyUser(id) != null) {
                return child;
            }
        }
        return null;
    }

    public void addChild(SecurityComponent child) {
        children.add(child);
    }

    public void setChildren(List<SecurityComponent> children) {
        this.children = children;
    }

    public List<SecurityComponent> getChildren() {
        return children;
    }
}
