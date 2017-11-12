/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

/**
 *
 * @author ASUSPC
 */
class Restaurant {
    private String id;
    private static int count=0;
    private String  name;
    private String  location;

    public Restaurant(String name, String location) {
        this.name = name;
        this.location = location;
        this.id="RS"+Integer.toString(count);
        count++;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

       
  
    
}