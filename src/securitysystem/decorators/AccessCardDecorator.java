/**
 * @author Carlos Espinoza B92786
 * Fabiola Jimenez B23452
 * Sebastián Montero B95016
 * Kendall Lara B43707
 * Roy Muñoz B54911
 * Maria Jesús B98243
 */

package securitysystem.decorators;

import securitysystem.Place;

/**
 * Base class for all the decorators.
 * Wraps an IAccessCard so the concrete decorators add additional functionalities.
 */
public abstract class AccessCardDecorator implements IAccessCard {
    protected IAccessCard wrappedAccessCard;

    public AccessCardDecorator(IAccessCard wrappedAccessCard) {
        this.wrappedAccessCard = wrappedAccessCard;
    }

    @Override
    public boolean canAccess(Place place) {
        return wrappedAccessCard.canAccess(place);
    }
}
