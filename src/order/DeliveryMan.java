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
public class DeliveryMan {

  //  private static int dmIDC = 1000;
 //   private int dmID;
    private int id;
    private String name;
    private String ic;
    private String gender;
    private String address;
    private String contactNo;
    private String email;
    private String status;

    public DeliveryMan(int id, String name, String ic, String gender,  String address, String contactNo, String email, String status) {
        this.id = id;
        this.name = name;
        this.ic = ic;
        this.gender = gender;
        this.address = address;
        this.contactNo = contactNo;
        this.email = email;
        this.status = status;
  //      this.dmID = dmIDC++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
       this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
      public String getIC() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
     

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

  //  public static int getDmIDC() {
  //      return dmIDC;
  //  }

  //  public static void setDmIDC(int dmIDC) {
  //      DeliveryMan.dmIDC = dmIDC;
 //   }

    @Override
    public String toString() {
        
        return String.format("| %-5d | %-15s | %-15s | %-6s | %-15s | %-15s | %-15s | %-10s | ", id, name, ic, gender, address, contactNo, email, status);
    }

}
