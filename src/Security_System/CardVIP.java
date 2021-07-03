package Security_System;

/* Represents an access card that can enter the VIP areas and
the areas that the wrapped card can enter
*/
public class CardVIP extends AccessCardDecorator{

    public CardVIP(IAccessCard baseCard) {
        super(baseCard);
    }

    //Decorates the canAccess method of the wrapped AccessCard with access to VIP areas
    @Override
    public boolean canAccess(Place place){
        return this.wrappedAccessCard.canAccess(place) || place.getAccessLevel() == AccessLevel.VIP;
    }
}
