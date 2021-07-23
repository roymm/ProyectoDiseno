package Security_System;

/*Base class for all the decorators.
Wraps an IAccessCard so the concrete decorators add additional functionalities.
 */
public abstract class AccessCardDecorator implements IAccessCard{
    protected IAccessCard wrappedAccessCard;

    public AccessCardDecorator(IAccessCard wrappedAccessCard) {
        this.wrappedAccessCard = wrappedAccessCard;
    }

    @Override
    public boolean canAccess(Place place) {
        return wrappedAccessCard.canAccess(place);
    }
}
