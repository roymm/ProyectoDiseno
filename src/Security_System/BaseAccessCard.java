package Security_System;

public class BaseAccessCard implements IAccessCard{

    @Override
    public boolean canAccess(Place place) {
        return place.getAccessLevel() == AccessLevel.Room;
    }
}
