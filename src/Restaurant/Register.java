package Restaurant;

import java.util.ArrayList;

public class Register {

    private Order order;
    private ArrayList<Order> orderLog;

    public Register(){
        this.order = null;
        this.orderLog = new ArrayList<>();
    }

    public Order getOrder(){
        return this.order;
    }

    public void makeNewOrder(){
        this.order = new Order();
    }

    public void addToOrder(Sandwich sandwich){
        this.order.addOrder(sandwich);
    }

    public void removeFromOrder(){
        this.order.undoOrder();
    }

    public void finishOrder(){
        String total = generateReceipt();
        this.order.setReceipt(total);
        
        System.out.println(this.order.getReceipt());
        this.orderLog.add(this.order);
        this.order = null;
    }

    public String generateReceipt(){
        String items = "";
        double totalPrice = 0.0;
        for(Sandwich sandwichTemp: this.order.getSandwiches()){
            items += sandwichTemp.toString() + "\n";
            totalPrice += sandwichTemp.getPrice();
        }
        return items + "Total:\t" + totalPrice + "\n";
    }
    
    public double getTotalPrice(){
    	double totalPrice = 0.0;
        for(Sandwich sandwichTemp: this.order.getSandwiches()){
        	totalPrice += sandwichTemp.getPrice();
        }
        return totalPrice;
    }

}
