/**
 * @author Carlos Espinoza B92786
 * Fabiola Jimenez B23452
 * Sebastián Montero B95016
 * Kendall Lara B43707
 * Roy Muñoz B54911
 * Maria Jesús B98243
 */
package restaurant;

import java.util.Arrays;
import java.util.List;

public class Sandwich {
    public enum Bread {CIABATTA, TORTA}

    public enum Meat {CARNITAS, SALAMI}

    public enum Extra {CHEESE, TOMATO}

    private final Bread bread;
    private final Meat meat;
    private final List<Extra> extras;
    private String type;
    private double price;

    public Sandwich(String type, Bread bread, Meat meat, Extra... extras) {
        this.bread = bread;
        this.meat = meat;
        this.extras = Arrays.asList(extras);
        this.type = type;
        this.price = 0.0;
    }

    public Bread getBread() {
        return this.bread;
    }

    public Meat getMeat() {
        return this.meat;
    }

    public List<Extra> getExtras() {
        return this.extras;
    }

    public double getPrice() {
        return this.price;
    }

    public String getType() {
        return this.type;
    }

    public void setPrice(double price) {
        this.price += price;
    }

    @Override
    public String toString() {
        return type + ((extras.size() > 0) ? " con extra de " + extras.toString() : "") + ": " + price;
    }
}