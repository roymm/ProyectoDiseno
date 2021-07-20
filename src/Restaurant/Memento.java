package Restaurant;

public class Memento {
    
    private Order currentOrder;
    private Order previousOrder; 

    public Memento(){
        this.currentOrder = null;
        this.previousOrder = null;
    }

    public void saveOrder(Order order){
        if(this.currentOrder == null){
            this.currentOrder = order;
        }else{
            this.previousOrder = this.currentOrder;
            this.currentOrder = order;
        }
    }

    public Order undoOrder(){
        Order orderToBeReturned = null;
        orderToBeReturned = this.previousOrder;
        this.currentOrder = this.previousOrder;
        this.previousOrder = null;
        return orderToBeReturned;
    }


}
