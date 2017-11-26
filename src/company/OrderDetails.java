/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

/**
 *
 * @author ASUSPC
 */
public class OrderDetails {
    private Meal meal;
    private int quantity=0;
    private double price;

    public OrderDetails(Meal meal,int quantity) {
        this.meal = meal;
        this.quantity=quantity;
        calculatePrice();
    }

    public Meal getMeal() {
        return meal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void calculatePrice(){
        price=((Meal)meal).getUnitPrice()*quantity;
    
    }
    
    
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        String str="";
               
              str  += String.format("%-20s%-10dRM%-10.2fRM%5.2f\n",((Meal)meal).getName(),getQuantity(),((Meal)meal).getUnitPrice(),getPrice());
              return str;
    }
    
    
    
    
}