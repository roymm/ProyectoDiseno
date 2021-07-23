package Security_System;

/* Represents an access card that can enter the reservations areas and
the areas that the wrapped card can enter
*/
public class CardMaintenanceArea extends AccessCardDecorator{

    public CardMaintenanceArea(IAccessCard baseCard) {
        super(baseCard);
    }

    //Decorates the canAccess method of the wrapped AccessCard with access to maintenance Areas
    @Override
    public boolean canAccess(Place place){
        return this.wrappedAccessCard.canAccess(place) || place.getAccessLevel() == AccessLevel.Maintenance;
    }
}