/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Track {

    /**
     *
     * @param user
     */
    public static void statusTrack(DeliveryMen[] user){
      int count =0;
  
    do{
     
        
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the worker ID(Leave blank to exit): ");
        
        String wID = input.nextLine();
        
        for (int i=0; i<user.length; i++)
        {
           if(user[i].id.equals(wID))
           {
               count =1;
               System.out.println(user[i].status);  
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
      DeliveryMen[] user = new DeliveryMen[4];
      user[0] = new DeliveryMen("Hahaha", "D001", "Delivering");
      user[1] = new DeliveryMen("Bobo", "D002", "Available");
      user[2] = new DeliveryMen("Keke", "D003", "Break");
      user[3] = new DeliveryMen("XDD", "D004", "Delivering");
      statusTrack(user);
    }
    
}
