package securitysystem;

/**
 * @author Carlos Espinoza B92786
 *            Fabiola Jimenez B23452
 *            Sebastián Montero B95016
 *            Kendall Lara B43707
 *            Roy Muñoz B54911
 *            Maria Jesús B98243
 */

/* Represents an access card that can enter the reservations areas and
the areas that the wrapped card can enter
*/
public class CardReservationArea extends AccessCardDecorator{

    public CardReservationArea(IAccessCard baseCard) {
        super(baseCard);
    }

    //Decorates the canAccess method of the wrapped AccessCard with access to Reservation Areas
    @Override
    public boolean canAccess(Place place){
        return this.wrappedAccessCard.canAccess(place) || place.getAccessLevel() == AccessLevel.ReservationArea;
    }
}
