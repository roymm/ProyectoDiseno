/**
 * @author Carlos Espinoza B92786
 *            Fabiola Jimenez B23452
 *            Sebastián Montero B95016
 *            Kendall Lara B43707
 *            Roy Muñoz B54911
 *            Maria Jesús B98243
 */
package securitysystem;

public class CardCommonArea extends AccessCardDecorator{
    public CardCommonArea(IAccessCard baseCard) {
        super(baseCard);
    }

    /**
     * Decorates the canAccess method of the wrapped AccessCard with access to common areas.
     * @param place is the place of the access.
     */
    @Override
    public boolean canAccess(Place place){
        return this.wrappedAccessCard.canAccess(place) || place.getAccessLevel() == AccessLevel.CommonArea;
    }
}
