/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Track {

    /**
     *
     * @param obj
     * @param user
     */
    public static void statusTrack(ArrayList<DeliveryMen> obj){
      int count =0;
  
    do{
     
        
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the worker ID(Leave blank to exit): ");
        
        String wID = input.nextLine();
        
        for (int i=0; i<obj.size(); i++)
        {
           if(obj.get(i).id.equals(wID))
           {
               count =1;
               System.out.println(obj.get(i).status);  
           }
           else if (wID.equals(""))
           {
              count=2;
           }
        }
       if(count==0)
       {
           System.out.println("Wrong ID");
       }
       else if (count==1)
       {
           count=0;
       }
       else
       {
           count=2;
       }
    }while(count==0 || count ==1);
    }
    
    public static void main(String[] args) {
      DeliveryMen D1 = new DeliveryMen ("Hahaha", "D001", "Delivering");
      DeliveryMen D2 = new DeliveryMen ("Bobo", "D002", "Available");
     DeliveryMen D3 = new DeliveryMen ("Keke", "D003", "Break");
     DeliveryMen D4 = new DeliveryMen ("XDD", "D004", "Delivering");
      ArrayList<DeliveryMen> obj = new ArrayList<DeliveryMen>();
      obj.add(D1);
      obj.add(D2);
      obj.add(D3);
      obj.add(D4);
       System.out.println("Track Delivery Man Status:");
       for(int i = 0; i < obj.size(); i++)
       {
           System.out.println(obj.get(i).name +" "+obj.get(i).id +" " + obj.get(i).status);
       }
      statusTrack(obj);
     
    }
    
}
