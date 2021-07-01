package Restaurant;

import java.util.Arrays;
import java.util.List;

public class Sandwich{
    public enum Bread { CIABATTA, TORTA };
    public enum Meat { CARNITAS, SALAMI };
    public enum Extra { CHEESE, TOMATO };

    private final Bread bread;
    private final Meat meat;
    private final List<Extra> extras;

    public Sandwich(Bread bread, Meat meat, Extra ... extras){
        this.bread = bread;
        this.meat = meat;
        this.extras = Arrays.asList(extras);
    };

    public Bread getBread(){
        return this.bread;
    }

    public Meat getMeat(){
        return this.meat;
    }

    public List<Extra> getExtras(){
        return this.extras;
    }
}