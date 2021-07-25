/**
 * @author Carlos Espinoza B92786
 *            Fabiola Jimenez B23452
 *            Sebastián Montero B95016
 *            Kendall Lara B43707
 *            Roy Muñoz B54911
 *            Maria Jesús B98243
 */

package securitysystem.decorators;

import securitysystem.Place;

/**
 * Represents an access card that can enter the VIP areas and
 * the areas that the wrapped card can enter
 */
public class CardVIP extends AccessCardDecorator{

    public CardVIP(IAccessCard baseCard) {
        super(baseCard);
    }

    /**
     * Decorates the canAccess method of the wrapped AccessCard with access to VIP areas.
     * @param place is the place of the access.
     */
    @Override
    public boolean canAccess(Place place){
        return this.wrappedAccessCard.canAccess(place) || place.getAccessLevel() == AccessLevel.VIP;
    }
}
