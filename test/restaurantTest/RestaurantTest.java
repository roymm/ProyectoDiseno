/**
 * @author
 * Carlos Espinoza B92786
 * Fabiola Jimenez B23452
 * Sebastián Montero B95016
 * Kendall Lara B43707
 * Roy Muñoz B54911
 * Maria Jesús B98243
 */
package restaurantTest;
import restaurant.Sandwich.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import Restaurant.*;
import org.junit.jupiter.api.Test;

class RestaurantTest {
	
	Register register = new Register();

    Sandwich italian = Kitchen.from(Kitchen.Italian()).addCheese().addTomato().create();
    Sandwich italian2 = Kitchen.from(Kitchen.Italian()).addCheese().addTomato().addCheese().addCheese().create();
    Sandwich mexican = Kitchen.from(Kitchen.Mexican()).addCheese().create();
    Sandwich mexican2 = Kitchen.from(Kitchen.Mexican()).create();

    /**
     * Tests adding orders to an account, and that the result is the expected.
     */
	@Test
	public void addOrderTest(){
        register.makeNewOrder();
        register.addToOrder(italian); // Italian (6) + Cheese (.75) + Tomato (.5) = 7.25
        register.addToOrder(italian2); // Italian (6) + x3 Cheese (2.25) + Tomato (.5) =  8.75
        register.addToOrder(mexican); // Mexican (5) + Cheese (.75) = 5.75
        register.addToOrder(mexican2); // Mexican (5) = 5
        //Total should be 7.25 + 8.75 + 5.75 + 5 = 26.75
        assertEquals(register.getTotalPrice(),26.75);
        register.finishOrder();

    }

    /**
     * Tests the removal of a line from an order.
     * Test that the price is the expected.
     */
	@Test
	public void mementoRemoveTest(){
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

    /**
     * Test the creation of sandwiches using the prototype.
     */
    @Test
    public void prototypeTest(){
        Sandwich defaultItalian = Kitchen.from(Kitchen.Italian()).create();
        Sandwich defaultMexican = Kitchen.from(Kitchen.Mexican()).create();

        //Verify that the ingredients obtained from the Italian Prototype match the expected outcome (ciabatta and salami)
        assertEquals(Bread.CIABATTA,defaultItalian.getBread());
        assertEquals(Meat.SALAMI,defaultItalian.getMeat());

        //Verify that the ingredients obtained from the Mexican Prototype match the expected outcome (ciabatta and salami)
        assertEquals(Bread.TORTA,defaultMexican.getBread());
        assertEquals(Meat.CARNITAS,defaultMexican.getMeat());

    }

}
