/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author MacBook
 */
public class Order {



    /**
     * @param args the command line arguments
     */
    
    private String orderID;
    private User user;
    private Restaurant restaurant;
    private List<Item> orderItem;
    private List<Integer> quantity;
    private Double total;
    private static Integer count = 1;
    
    Order()
    {
        
    }

    public String getOrderID() {
        return orderID;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
        public User getUser() {
        return user;
    }
        
    Order(User user, Restaurant restaurant,List<Item> orderItem, List<Integer> quantity, Double total)
    {
        this.orderID = "OD" + count;
        this.user = user;
        this.restaurant = restaurant;
        this.orderItem =new ArrayList<>(orderItem);
        this.quantity=new ArrayList<>(quantity);
        this.total = total;
        count++;
    }
    public String deliveries(){
    String str="";
    for(int i =0;i<orderItem.size();i++){
        str+=String.format("%-25s%-4s%-20s%-20s%-20s\n",orderItem.get(i).getFoodName(),quantity.get(i).toString(),restaurant.getRestaurantName(),getUser().getUsername(),getUser().getAddress());
    }
    
    return str;
        
    }

    @Override
    public String toString() {
        
        return "Order{" + "orderID=" + orderID + ", user=" + user + ", restaurant=" + restaurant + ", orderItem=" + orderItem + ", quantity=" + quantity + ", total=" + total + '}';
    }
    
   
}
