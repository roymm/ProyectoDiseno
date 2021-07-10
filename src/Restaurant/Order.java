package Restaurant;
import java.util.ArrayList;

public class Order {

    private String receipt;
    private ArrayList<Sandwich> sandwiches;
    private Memento memento;

    public Order(){
        this.receipt = "";
        this.sandwiches = new ArrayList<>();
        this.memento = new Memento();
    }

    //Getters and Setters for all atributtes
    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public ArrayList<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void setSandwiches(ArrayList<Sandwich> sandwiches) {
        this.sandwiches = new ArrayList<>();
        for(Sandwich sandwich: sandwiches){
            this.sandwiches.add(sandwich);
        }
    }

    public void addOrder(Sandwich sandwich){
        //Make a get for the Sandwich's attributes
        this.receipt += sandwich.toString() + "\t\n";
        // System.out.println(receipt);
        this.sandwiches.add(sandwich);
        this.saveOrder();
    }

    //Memento's handling methods
    public void saveOrder(){
        Order orderCopy = new Order();
        orderCopy.setReceipt(this.receipt);
        orderCopy.setSandwiches(this.sandwiches);
        this.memento.saveOrder(orderCopy); //Saves the current state using memento
    }

    public void undoOrder(){
        Order previousOrder = this.memento.undoOrder();
        
        if(previousOrder == null){
            this.receipt = "";
            this.sandwiches = new ArrayList<>();
        }else{
            this.receipt = previousOrder.getReceipt();
            this.sandwiches = previousOrder.getSandwiches();
        }
    }

    @Override
    public String toString(){
        return receipt;
    }
}
