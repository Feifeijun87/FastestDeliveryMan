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
public class Meal {
    private String name;
    private String id;
    private static int count=1;
    private double unitPrice;
    private  Restaurant restaurant;

    public Meal() {
    
    }
    
    
    
    
    public Meal(String name,double unitPrice,Restaurant restaurant){
    this.name =name;
    this.unitPrice=unitPrice;
    this.id="F"+Integer.toString(this.count);
    this.restaurant=restaurant;
    count++;
    
    }

    /**
     *
     */
    

    public void setUnitPrice(double unitPrice){
    this.unitPrice=unitPrice;
    }
    public double getUnitPrice(){
    return unitPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id ="F"+count;
        count++;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    
    
    
}