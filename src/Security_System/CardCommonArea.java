package Security_System;

public class CardCommonArea extends AccessCardDecorator{
    public CardCommonArea(IAccessCard baseCard) {
        super(baseCard);
    }

    //Decorates the canAccess method of the wrapped AccessCard with access to common areas
    @Override
    public boolean canAccess(Place place){
        return this.wrappedAccessCard.canAccess(place) || place.getAccessLevel() == AccessLevel.CommonArea;
    }
}
