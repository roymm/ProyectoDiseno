package Restaurant;

public class Memento {
    
    //The Memento class saves the current and previous state of the order
    private Order currentOrder;
    private Order previousOrder; 

    public Memento(){
        this.currentOrder = null;
        this.previousOrder = null;
    }

     /*
     * Purpose: Saves the old current order into previousOrder and the new current order into
     * currentOrder
     * Input: The new current Order
     * Output: -
     */
    public void saveOrder(Order order){
        if(this.currentOrder == null){
            this.currentOrder = order;
        }else{
            this.previousOrder = this.currentOrder;
            this.currentOrder = order;
        }
    }

     /*
     * Purpose: Returns the previous state of an Order saved.
     * Input: -
     * Output: Order orderToBeReturned which contains the specifications of an order from the past.
     */
    public Order undoOrder(){
        Order orderToBeReturned = null;
        orderToBeReturned = this.previousOrder;
        this.currentOrder = this.previousOrder;
        this.previousOrder = null;
        return orderToBeReturned;
    }


}
