package Restaurant;

import java.util.ArrayList;
import java.util.List;

import Restaurant.Sandwich.Bread;
import Restaurant.Sandwich.Extra;
import Restaurant.Sandwich.Meat;

public class Kitchen{


    private Bread bread;
    private Meat meat;
    private List<Extra> extras = new ArrayList<Extra>();
    private String type;
    private double price;


    public Sandwich create(){
        Sandwich sandwich = new Sandwich(type, bread, meat, extras.toArray(new Extra[extras.size()]));
        sandwich.setPrice(this.price);
        return sandwich;
    }


    public static Kitchen from(Sandwich prototype){
        Kitchen kitchen = new Kitchen();
        kitchen.bread = prototype.getBread();
        kitchen.meat = prototype.getMeat();
        kitchen.extras.addAll(prototype.getExtras());
        kitchen.type = prototype.getType();
        kitchen.price = prototype.getPrice();
        return kitchen;
    }

    public Kitchen setBread(Bread bread){
        this.bread = bread;
        return this;
    }

    public Kitchen removeBread(){
        this.bread = null;
        return this;
    }
    
    public Kitchen setMeat(Meat meat){
        this.meat = meat;
        return this;
    }

    public Kitchen removeMeat(){
        this.meat = null;
        return this;
    }

    public Kitchen addTomato(){
        this.extras.add(Extra.TOMATO);
        this.price += 0.50;
        return this;        
    }

    public Kitchen addCheese(){
        this.extras.add(Extra.CHEESE);
        this.price += 0.75;
        return this;
    }

    public Kitchen removeExtra(Extra extra){
        this.extras.remove(extra);
        return this;
    }


    //Sandwiches on the menu

    public static Sandwich Mexican(){
        Sandwich mexican = new Sandwich("Mexican",Bread.TORTA, Meat.CARNITAS);
        mexican.setPrice(5.00);
        return mexican;
    }

    public static Sandwich Italian(){
        Sandwich italian = new Sandwich("Italian",Bread.CIABATTA, Meat.SALAMI);
        italian.setPrice(6.00);
        return italian;
    }
    
}