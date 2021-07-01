package Security_System;

public class CardVIP extends AccessCardDecorator{

    public CardVIP(IAccessCard baseCard) {
        super(baseCard);
    }

    @Override
    public boolean canAccess(Place place){
        return place.getAccessLevel() == AccessLevel.VIP;
    }
}
