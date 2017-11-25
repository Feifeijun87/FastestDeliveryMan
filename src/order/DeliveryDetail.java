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

    public DeliveryDetail(int id, String status, String custAddress, DeliveryMan deliveryMan) {
        this.id = id;
        this.status = status;
        this.custAddress = custAddress;
        this.deliveryMan = deliveryMan;

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

//    public void setOrder(Order order) {
//        this.order = order;
//    }
    @Override
    public String toString() {
        return String.format("| %-5d | %-10s | %-16s ", id, status, custAddress) + deliveryMan.toString();
    }

}
