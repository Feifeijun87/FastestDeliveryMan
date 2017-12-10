/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

/**
 *
 * @author hsuhong1210
 */
public class DeliveryDetail {

     private int id;
    private String status;
    private DeliveryMan deliveryMan;
    //   private Order order;
    private String custAddress;
    
    //additional in sprint 3
    private String date;
    private int distance;
    //private int totalDelivery;

    public DeliveryDetail(int id, String status, String custAddress, DeliveryMan deliveryMan, String date, int distance) {
        this.id = id;
        this.status = status;
        this.custAddress = custAddress;
        this.deliveryMan = deliveryMan;
        this.distance = distance;
        this.date = date;
      //  this.totalDelivery = totalDelivery;

        // this.order = order;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public DeliveryMan getDeliveryMan() {
        return deliveryMan;
    }
    
      public int getDistance() {
        return distance;
    }
      
       public String getDate() {
        return date;
    }

 //   public int getTotalDelivery() {
  //      return totalDelivery;
   // }

//    public Order getOrder() {
//        return order;
//    }
    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public void setDeliveryMan(DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
    }
    
     public void setDistance(int distance) {
        this.distance = distance;
    }
     
      public void setDate(String date) {
        this.date = date;
    }

 //   public void setTotalDelivery(int totalDelivery) {
 //       this.totalDelivery = totalDelivery;
  //  }

//    public void setOrder(Order order) {
//        this.order = order;
//    }
    @Override
    public String toString() {
        return String.format("| %-5d | %-10s | %-16s", id, status, custAddress) + deliveryMan.toString() + String.format(" | %-5d | %-15s", distance, date);
    }

}
