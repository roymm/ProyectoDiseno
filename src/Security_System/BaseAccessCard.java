package Security_System;

/**
 * @author Carlos Espinoza B92786
 *            Fabiola Jimenez B23452
 *            Sebastián Montero B95016
 *            Kendall Lara B43707
 *            Roy Muñoz B54911
 *            Maria Jesús B98243
 */

public class BaseAccessCard implements IAccessCard{

    @Override
    public boolean canAccess(Place place) {
        return place.getAccessLevel() == AccessLevel.Room;
    }
}
