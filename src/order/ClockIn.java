/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class ClockIn {
    public static void main(String[] args) { 
       enter();
    
    
    }
    public static void enter(){
        
    Scanner input = new Scanner (System.in);
        System.out.println("Please Enter your ID (leave blank to exit): ");
        String wID = input.nextLine();
        if(wID.equals(""))
        {
           System.exit(0); 
           
        }
        else
        information(wID);
    
    }
    
    public static void information(String wID){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
Date date = new Date();
    boolean check = false;
    boolean check2 = false;
    int count = 0;
    DeliveryMen D1 = new DeliveryMen ("Hahaha", "D001", "Delivering");
    DeliveryMen D2 = new DeliveryMen ("Bobo", "D002", "Available");
    DeliveryMen D3 = new DeliveryMen ("Keke", "D003", "Break");
    DeliveryMen D4 = new DeliveryMen ("XDD", "D004", "Delivering");
    ArrayList<DeliveryMen> obj = new ArrayList<DeliveryMen>();
      obj.add(D1);
      obj.add(D2);
      obj.add(D3);
      obj.add(D4);
   
     for(int i = 0; i < obj.size(); i++)
     {
         if(obj.get(i).id.equals(wID))
         {
          System.out.println(obj.get(i).name +" "+obj.get(i).id);
          count = i;
          check = true;
          break;
         }
         else
         {
             check = false;
         }
     }
     if(check == false)
     {
         System.out.println("Wrong ID");
        enter();
     }
     else if(check == true)
     {
         do{
         System.out.println("Is This your Profile?(Y/N)");
         Scanner input2 = new Scanner(System.in);
          char wCon = input2.next().charAt(0);
          
          if(wCon == 'Y')
          {
              System.out.println(obj.get(count).id + " " + obj.get(count).name + " " + dateFormat.format(date) );
              check2=true;
          }
          else if(wCon == 'N')
          {
            enter();
            break;
          }
          else if(wCon == '0')
          {
             System.exit(0);
          }
          else
          {
              System.out.println("Wrong Input, Please Try Again");
             
              
          }
          }while(check2 == false);
          
          
          
     }
     
          
          
     }
    }
     
    
     
     
    
    



