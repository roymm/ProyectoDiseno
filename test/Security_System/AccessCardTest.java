package Security_System;

import Security_System.*;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccessCardTest {
    Place room = new Place(AccessLevel.Room,"Basic Room");
    Place maintenanceArea = new Place(AccessLevel.Maintenance,"Maintenance Area");
    Place reservationArea = new Place(AccessLevel.ReservationArea,"Reservation Area");
    Place commonArea = new Place(AccessLevel.CommonArea, "Common Area");

    @Test
    public void canAccess_BaseAccessCard_NoAccess(){
        IAccessCard baseCard = new BaseAccessCard();

        assertTrue(baseCard.canAccess(room));
        assertFalse(baseCard.canAccess(maintenanceArea));
        assertFalse(baseCard.canAccess(reservationArea));
        assertFalse(baseCard.canAccess(commonArea));
    }

    @Test
    public void canAccess_decoratedCard_FullAccess(){
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