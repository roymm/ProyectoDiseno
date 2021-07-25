/**
 * @author
 * Carlos Espinoza B92786
 * Fabiola Jimenez B23452
 * Sebastián Montero B95016
 * Kendall Lara B43707
 * Roy Muñoz B54911
 * Maria Jesús B98243
 */
package securitysystemTest;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccessCardTest {
    private final Place room = new Place(AccessLevel.Room,"Basic Room");
    private final Place maintenanceArea = new Place(AccessLevel.Maintenance,"Maintenance Area");
    private final Place reservationArea = new Place(AccessLevel.ReservationArea,"Reservation Area");
    private final Place commonArea = new Place(AccessLevel.CommonArea, "Common Area");

    @Test
    public void canAccess_BaseAccessCard_OnlyRoomAccess(){
        IAccessCard baseCard = new BaseAccessCard();

        assertTrue(baseCard.canAccess(room));
        assertFalse(baseCard.canAccess(maintenanceArea));
        assertFalse(baseCard.canAccess(reservationArea));
        assertFalse(baseCard.canAccess(commonArea));
    }

    @Test
    public void canAccess_DecoratedCard_FullAccess(){
        IAccessCard decoratedCard = new BaseAccessCard();
        decoratedCard = new CardMaintenanceArea(decoratedCard);
        decoratedCard = new CardReservationArea(decoratedCard);
        decoratedCard = new CardCommonArea(decoratedCard);

        assertTrue(decoratedCard.canAccess(room));
        assertTrue(decoratedCard.canAccess(maintenanceArea));
        assertTrue(decoratedCard.canAccess(reservationArea));
        assertTrue(decoratedCard.canAccess(commonArea));
    }
}