package Security_System;

/**
 * @author Carlos Espinoza B92786
 *            Fabiola Jimenez B23452
 *            Sebastián Montero B95016
 *            Kendall Lara B43707
 *            Roy Muñoz B54911
 *            Maria Jesús B98243
 */

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
