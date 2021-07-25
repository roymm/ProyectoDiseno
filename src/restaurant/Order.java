/**
 * @author Carlos Espinoza B92786
 *            Fabiola Jimenez B23452
 *            Sebastián Montero B95016
 *            Kendall Lara B43707
 *            Roy Muñoz B54911
 *            Maria Jesús B98243
 */
package restaurant;
import java.util.ArrayList;

public class Order {

    private String receipt;
    private ArrayList<Sandwich> sandwiches;
    private Memento memento; //Memento attribute allows the order to undo the last sandwich ordered

    public Order(){
        this.receipt = "";
        this.sandwiches = new ArrayList<>();
        this.memento = new Memento();
    }

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

    /**
     * Adds a sandwich to the current order.
     * @param sandwich a Sandwich object that is going to be ordered.
     */
    public void addOrder(Sandwich sandwich){
        this.receipt += sandwich.toString() + "\t\n";
        this.sandwiches.add(sandwich);
        this.saveOrder();
    }

    // Memento's handling methods.

    /**
     * Saves the current state of the order as a copy into the memento object.
     */
    public void saveOrder(){
        Order orderCopy = new Order();
        orderCopy.setReceipt(this.receipt);
        orderCopy.setSandwiches(this.sandwiches);
        this.memento.saveOrder(orderCopy); //Saves the current state using memento
    }

    /**
     * The memento object or 'snapshot' of the order is used to undo the last
     * sandwich placed for this particular order.
     */
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
