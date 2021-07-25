/**
 * @author Carlos Espinoza B92786
 *            Fabiola Jimenez B23452
 *            Sebastián Montero B95016
 *            Kendall Lara B43707
 *            Roy Muñoz B54911
 *            Maria Jesús B98243
 */
package restaurant;

public class Memento {
    
    // The Memento class saves the current and previous state of the order.
    private Order currentOrder;
    private Order previousOrder; 

    public Memento(){
        this.currentOrder = null;
        this.previousOrder = null;
    }

    /**
     * Saves the old current order into previousOrder and the new current order into currentOrder
     * @param order The new current Order
     */
    public void saveOrder(Order order){
        if(this.currentOrder == null){
            this.currentOrder = order;
        }else{
            this.previousOrder = this.currentOrder;
            this.currentOrder = order;
        }
    }

    /**
     * Returns the previous state of an Order saved.
     * @return Order orderToBeReturned which contains the specifications of an order from the past.
     */
    public Order undoOrder(){
        Order orderToBeReturned = null;
        orderToBeReturned = this.previousOrder;
        this.currentOrder = this.previousOrder;
        this.previousOrder = null;
        return orderToBeReturned;
    }


}
