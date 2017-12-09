/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class TaskAssign {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          Scanner choice = new Scanner(System.in);
          int ch;
          int count = 0;
           DeliveryMen D1 = new DeliveryMen ("Hahaha", "D001", "Available");
      DeliveryMen D2 = new DeliveryMen ("Bobo", "D002", "Available");
     DeliveryMen D3 = new DeliveryMen ("Keke", "D003", "Available");
     DeliveryMen D4 = new DeliveryMen ("XDD", "D004", "Delivering");
      ArrayList<DeliveryMen> obj = new ArrayList<DeliveryMen>();
     
      LinkedList<DeliveryMen> available = new LinkedList<DeliveryMen>();
      obj.add(D1);
      obj.add(D2);
      obj.add(D3);
      obj.add(D4);
      for(int k=0; k<obj.size();k++)
            {
                if(obj.get(k).status.equals("Available"))
                {
                    available.add(obj.get(k));
                    ++count;
                }                
            }
      for(int h=0; h<available.size(); h++)
      {
         System.out.println(available.get(h).name);
      }
      
           User user1 = new User("Fiffy","cute88","Jalan Cutie,Klang","011-111111");
           User user2 = new User("Sixty","nocute87","Jalan Ugly,Setapak","012-9487953");
        
        Item item1 = new Item("Chicken Chop", 12.90, "Golden chicken coated with ABC gravy");
        Item item2 = new Item("Spaghetti Bolognese", 10.90, "Tomato sauce spaghetti with meatballs");
        Item item3 = new Item("Mushroom Soup", 6.90, "Forest Mushroom");
        Item item4 = new Item("Pumpkin Soup", 6.90, "Cinderella Pumpkin");

        List<Item> restABCMenu = new ArrayList<>();
        List<Item> restHappyMenu = new ArrayList<>();
   
        
        restABCMenu.add(item1);
        restABCMenu.add(item2);
        restHappyMenu.add(item3);
        restHappyMenu.add(item4);

        
        
        //Restaurant List
        Restaurant restABC = new Restaurant("Restaurant ABC", "Setapak", "012-1111111", restABCMenu);
        Restaurant restHappy = new Restaurant("Restaurant Happy", "Klang", "012-1111111", restHappyMenu);
        List<Restaurant> restaurantList = new ArrayList<>();
        restaurantList.add(restABC);
        restaurantList.add(restHappy);
        
        List<Item> tempOrder=new ArrayList<>();
        tempOrder.add(item1);
        List<Integer> qty1 = new ArrayList<>();
        qty1.add(1);
        
        
        List<Item> tempOrder2=new ArrayList<>();
        tempOrder2.add(item2);
         List<Integer> qty2 = new ArrayList<>();
        qty2.add(1);
        
        List<Item> tempOrder3=new ArrayList<>();
        tempOrder3.add(item3);
        List<Integer> qty3 = new ArrayList<>();
        qty3.add(1);
        
        List<Item> tempOrder4=new ArrayList<>();
        tempOrder4.add(item1);
         List<Integer> qty4 = new ArrayList<>();
        qty4.add(1);

        //Order
        List<Order> order = new ArrayList<>();
        List<Order> orderq;
        Order order1 = new Order(user1,restABC,tempOrder,qty1,12.90);
        
        Order order2 = new Order(user2,restABC,tempOrder2,qty2,10.90);
        
        Order order3 = new Order(user1,restABC,tempOrder3,qty1,6.90);
        Order order4 = new Order(user2,restABC,tempOrder4,qty1,6.90);
        
        
        order.add(order1);
        order.add(order2);
        order.add(order3);
        order.add(order4);
        orderq= new ArrayList<Order>(order);

        Schedule schedule1=new Schedule(order1,1,"0900");
        Schedule schedule2=new Schedule(order2,1,"1000");
        Schedule schedule3=new Schedule(order3,1,"2000");
        Schedule schedule4=new Schedule(order4,1,"1200");
        List<Schedule> schedule = new ArrayList<>();
        schedule.add(schedule1);
        schedule.add(schedule2);
        schedule.add(schedule3);
        schedule.add(schedule4);
          Calendar clndr = Calendar.getInstance();
        int dayOfWeek=clndr.get(Calendar.DAY_OF_WEEK);
        List<Schedule> temp=new ArrayList<>();
        for( int i=0; i<schedule.size();i++){
        if(dayOfWeek==schedule.get(i).getDayOfWeek() && schedule.get(i).getOrder().getRestaurant().getRestAddress().equals("Setapak")){
            temp.add(schedule.get(i));
        }
        }
        
        for(int i=0;i<temp.size();i++){
            for (int j=0;j<temp.size();j++){
        if(Integer.parseInt(temp.get(j).getTime())>Integer.parseInt(temp.get(i).getTime())){
        Schedule tempo=temp.get(i);
        temp.set(i, temp.get(j));
        temp.set(j, tempo);
            }
            
        }
        }
        String str="";
        str+=String.format("%-4s%-6s%-25s%-4s%-20s%-20s%-20s%-10s%-15s\n","No","Time","Food Name","Qty","Restaurant Name","Customer Name","Address","Delivery Man ID", "Delivery Man Name");
        for(int i=0;i<temp.size();i++){
           if(count !=0)
           {
                str+=i+1+".  "+temp.get(i).getTime()+ "  "+temp.get(i).getOrder().deliveries() +" "+ available.get(0).id +" " + available.get(0).name;
                available.remove(0);
                --count;
           }
          
        
        }
        System.out.println(count);
        System.out.println(str);
        
          
         
    }
    
        public static String convertDayOfWeek(int dayOfWeek){
        String str="";
        switch (dayOfWeek) {
            case 1:
                str="Sunday";
                break;
            case 2:
                str="Monday";
                break;
            case 3:
                str="Tuesday";
                break;
            case 4:
                str="Wednesday";
                break;
            case 5:
                str="Thursday";
                break;
            case 6:
                str="Friday";
                break;
            case 7:
                str="Saturday";
                break;
            default:
                break;
        }
    return str;
    
    
    }
        
       
    
}
