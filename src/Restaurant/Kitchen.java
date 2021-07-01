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


    public Sandwich create(){
        return new Sandwich(bread, meat, extras.toArray(new Extra[extras.size()]));
    }


    public static Kitchen from(Sandwich prototype){
        Kitchen kitchen = new Kitchen();
        kitchen.bread = prototype.getBread();
        kitchen.meat = prototype.getMeat();
        kitchen.extras.addAll(prototype.getExtras());
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

    public Kitchen addExtra(Extra extra){
        this.extra.add(extra);
        return this;
    }

    public Kitchen removeExtra(Extra extra){
        this.extras.remove(extras);
        return this;
    }


    //Sandwiches on the menu

    public static Sandwich Mexican(){
        return new Sandwich(Bread.TORTA, Meat.CARNITAS);
    }

    public static Sandwich Italian(){
        return new Sandwich(Bread.CIABATTA, Meat.SALAMI);
    }
    


}