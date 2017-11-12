/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hsuhong1210
 */
public class DeliveryMan {

  //  private static int dmIDC = 1000;
 //   private int dmID;
    private String dmName;
    private String gender;
    private String address;
    private String contactNo;
    private String email;
    private String status;

    public DeliveryMan(String name, String gender, String address, String contactNo, String email, String status) {
        this.dmName = dmName;
        this.gender = gender;
        this.address = address;
        this.contactNo = contactNo;
        this.email = email;
        this.status = status;
  //      this.dmID = dmIDC++;
    }

   // public int getDmID() {
   //     return dmID;
   // }

   // public void setDmID(int dmID) {
   //     this.dmID = dmID;
   // }

    public String getDmName() {
        return dmName;
    }

    public void setDmName(String dmName) {
        this.dmName = dmName;
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
        
        return String.format("dmName = %-20s\n gender = %-20s\n address = %-20s\n contactNo = %-20s\n email = %-20s\n status = %-20s\n ", dmName, gender, address, contactNo, email, status);
    }

}
