/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

/**
 *
 * @author MacBook
 */
public class Item {
    
    private String foodID;
    private String foodName;
    private Double foodPrice;
    private String desc;
    private static Integer count = 1;
    
    Item(String name, Double price, String desc)
    {
        this.foodID = "F" + count;
        this.foodName = name;
        this.foodPrice = price;
        this.desc = desc;
        count++;
    }
    
    public String getFoodName() {
        return foodName;
    }

    public Double getFoodPrice() {
        return foodPrice;
    }

    public String getDesc() {
        return desc;
    }
    
    public String toString()
    {
        return (foodName + "            " + "RM " + foodPrice + "       "+desc);
    }
    
    public String itemDetail()
    {
         return (foodName + "            " + "RM " + foodPrice);
    }
    
    public double getPrice()
    {
        return foodPrice;
    }
    
}
