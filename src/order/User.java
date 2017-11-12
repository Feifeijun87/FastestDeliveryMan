/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

/**
 *
 * @author MacBook
 */
public class User {
    
    private String userID;
    private String username;
    private String password;
    private String address;
    private String contactNum;
    private static Integer count = 1;
    
    User(String username, String password,String address,String contactNum)
    {
        userID = "U" + count;
        this.username = username;
        this.password = password;
        this.address = address;
        this.contactNum = contactNum;
        count++;
              
    }
    
    User()
    {
        count++;
        
    }
    
    public String getContactNum()
    {
        return contactNum;
    }
    
}
