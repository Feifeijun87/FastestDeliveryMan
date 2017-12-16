/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

/**
 *
 * @author user
 */
class DeliveryMen {
    public String name;
    public String id;
    public String status;
    public String date;
    public DeliveryMen(String name, String id, String status, String date){
        this.name = name;
        this.id = id;
        this.status = status;
        this.date = date;
        
    }
}
