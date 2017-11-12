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
    private List<Item> orderItem = new ArrayList<>();
    private List<Integer> quantity = new ArrayList<>();
    private Double total;
    private static Integer count = 1;
    
    Order()
    {
        
    }
    
    Order(User user, Restaurant restaurant,List<Item> orderItem, List<Integer> quantity, Double total)
    {
        this.orderID = "OD" + count;
        this.user = user;
        this.restaurant = restaurant;
        this.orderItem = orderItem;
        this.quantity = quantity;
        this.total = total;
        count++;
    }
}
