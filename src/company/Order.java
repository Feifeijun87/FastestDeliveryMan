/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author ASUSPC
 */
public class Order {
    private OrderDetails[] orderDtl;
    private String id;
    private static int  count=1,quantity;
    private double totalPrice;
    private String orderDate,orderTime;
    private String status="Off";
    
    
    
    public Order(OrderDetails[] orderDtl){
    this.orderDtl=orderDtl;
    this.quantity=quantity;
    //this.orderTime=orderTime;
    //this.orderDate=orderDate;
    this.id="OD"+count;
    count++;
    Calendar cal= Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
    orderDate=sdf.format(cal.getTime());
    SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");
      orderTime=sdf2.format(cal.getTime());
    }

    public void setOrderDtl(OrderDetails[] orderDtl) {
        this.orderDtl = orderDtl;
    }

    public Order() {
        
    }

   public void calculateTotal(){
   for(int i=0;i<orderDtl.length;i++){
       if(orderDtl[i]!=null)
           
    totalPrice+=((OrderDetails)orderDtl[i]).getPrice();           
    }
   }
    
    
    public double getTotal(){

    return totalPrice;
    }

    public OrderDetails[] getOrderDetails() {
        return orderDtl;
    }
    
  


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static int getQuantity() {
        return quantity;
    }

    public static void setQuantity(int quantity) {
        Order.quantity = quantity;
    }

    public String getOrderDate() {
        return orderDate;
    }



    public String getOrderTime() {
        return orderTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
            String str="";

  str  += String.format("%-20s%-10s%-12s%-10s\n","Meal Name","Unit ","UnitPrice","Price");
 for(int i=0;i<orderDtl.length;i++){
 if(orderDtl[i]!=null){
 str+=((OrderDetails)orderDtl[i]).toString();

 }
 
 }
     str+="------------------------------------------------\n";
     str+=String.format("%-41s RM%5.2f\n","Total Price",getTotal());
      return str;
    }
    
  
    
    

    

    
    
    
    
}

