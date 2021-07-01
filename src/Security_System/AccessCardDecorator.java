package Security_System;

public abstract class AccessCardDecorator implements IAccessCard{
    protected IAccessCard baseCard;

    public AccessCardDecorator(IAccessCard baseCard) {
        this.baseCard = baseCard;
    }

    public boolean canAccess(Place place) {
        return baseCard.canAccess(place);
    }
}
