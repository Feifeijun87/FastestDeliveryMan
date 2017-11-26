/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import java.util.*;

/**
 *
 * @author MacBook
 */
public class Restaurant {
    
    private String restID;
    private String restName;
    private String restAddress;
    private String restContactNum;
    private List<Item> menu = new ArrayList<>();
    private static Integer count = 1;
    
    Restaurant(String restName,String restAdd, String restContactNum, List<Item> menu)
    {
        this.restID = "R" + count;
        this.restName = restName;
        this.restAddress = restAdd;
        this.restContactNum = restContactNum;
        this.menu = menu;
        count++;
    }
    
    public String getRestaurantName()
    {
        return restName;
    }
    
    public List<Item> getMenu()
    {
        return menu;
    }

    public String getRestAddress() {
        return restAddress;
    }

    
    
    
}
