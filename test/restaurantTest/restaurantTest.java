package restaurantTest;
import static org.junit.jupiter.api.Assertions.*;
import Restaurant.*;
import org.junit.jupiter.api.Test;

class restaurantTest {

	@Test
	public void addOrderTest(){

        Register register = new Register();

        Sandwich italian = Kitchen.from(Kitchen.Italian()).addCheese().addTomato().create();
        Sandwich italian2 = Kitchen.from(Kitchen.Italian()).addCheese().addTomato().addCheese().addCheese().create();
        Sandwich mexican = Kitchen.from(Kitchen.Mexican()).addCheese().create();
        Sandwich mexican2 = Kitchen.from(Kitchen.Mexican()).create();

        //Make an order with the register
        register.makeNewOrder();
        register.addToOrder(italian); // Italian (6) + Cheese (.75) + Tomato (.5) = 7.25
        register.addToOrder(italian2); // Italian (6) + x3 Cheese (2.25) + Tomato (.5) =  8.75
        register.addToOrder(mexican); // Mexican (5) + Cheese (.75) = 5.75
        register.addToOrder(mexican2); // Mexican (5) = 5
        //Total should be 7.25 + 8.75 + 5.75 + 5 = 26.75
        assertEquals(register.getTotalPrice(),26.75);
        register.finishOrder();

    }
	
	@Test
	public void mementoRemoveTest(){

        Register register = new Register();

        Sandwich italian = Kitchen.from(Kitchen.Italian()).addCheese().addTomato().create();
        Sandwich italian2 = Kitchen.from(Kitchen.Italian()).addCheese().addTomato().addCheese().addCheese().create();
        Sandwich mexican = Kitchen.from(Kitchen.Mexican()).addCheese().create();
        Sandwich mexican2 = Kitchen.from(Kitchen.Mexican()).create();

        //Make an order with the register
        register.makeNewOrder();
        register.addToOrder(italian); // Italian (6) + Cheese (.75) + Tomato (.5) = 7.25
        register.addToOrder(italian2); // Italian (6) + x3 Cheese (2.25) + Tomato (.5) =  8.75
        register.addToOrder(mexican); // Mexican (5) + Cheese (.75) = 5.75
        register.addToOrder(mexican2); // Mexican (5) = 5
        register.removeFromOrder();
        //Total should be 7.25 + 8.75 + 5.75 = 21.75 (5$ were removed through memento).
        assertEquals(register.getTotalPrice(),21.75);
        register.finishOrder();

    }

}
