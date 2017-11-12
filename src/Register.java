

import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ruenyenchin
 */
public class Register {
    private final List<String> registerList = new ArrayList<>();
    
   
    public void registerInput(){
        Integer input;

        input = choice(1,2);   
        
        if(input == 1){
            register();
        }else if(input == 2){
            System.out.println("\nThank you.");
        }
    }
    public static int choice(int min, int max){
        int choice = 0;
        boolean valid;
        
        do{
            valid = false;
            choice = checkDigit();
            
            if(choice < min || choice > max){
                System.out.println("\nWrong Input! Please enter again.");
            }
        }while(valid);
        
        return choice;
    }

    public static int checkDigit(){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean valid = true;
        
        do{
            try{
                System.out.print("\nEnter your choice > ");
                choice = scanner.nextInt();
                
                valid = false;
            }catch(Exception error){
                System.out.println("\nWrong Input! Please enter again.");
                valid = true;
                scanner.nextLine();
            }
        }while(valid);
        
        return choice;
    }
    
    public void register(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\nRegister as affiliate:\n");
        System.out.print("Affiliate Name > ");
        String affiliateName = scanner.nextLine();
        registerList.add(affiliateName);
        
        System.out.print("First Name > ");
        String firstName = scanner.nextLine();
        registerList.add(firstName);
        
        System.out.print("Last Name > ");
        String lastName = scanner.nextLine();
        registerList.add(lastName);
        
        System.out.print("Company Name > ");
        String companyName = scanner.nextLine();
        registerList.add(companyName);
        
        System.out.print("Email > ");
        String email = scanner.nextLine();
        registerList.add(email);
        
        System.out.print("Website URL > ");
        String websiteURL = scanner.nextLine();
        registerList.add(websiteURL);
        
        System.out.print("Street Address > ");
        String streetAddress = scanner.nextLine();
        registerList.add(streetAddress);
        
        System.out.print("Phone > ");
        String phone = scanner.nextLine();
        registerList.add(phone);
        
        System.out.print("Username > ");
        String username = scanner.nextLine();
        registerList.add(username);
        
        System.out.print("Password > ");
        String password = scanner.nextLine();
        registerList.add(password);
        
        displayRegisterDetails();
    }
    
    public void displayRegisterDetails(){
        System.out.println("\n\nThank you for successfully registered as affiliate.\n");
        System.out.println("Affiliate details:");
        System.out.println("Affiliate Name: " + registerList.get(0));
        System.out.println("First Name: " + registerList.get(1));
        System.out.println("Last Name: " + registerList.get(2));
        System.out.println("Company Name: " + registerList.get(3));
        System.out.println("Email: " + registerList.get(4));
        System.out.println("Website URL: " + registerList.get(5));
        System.out.println("Street Address: " + registerList.get(6));
        System.out.println("Phone: " + registerList.get(7));
        System.out.println("Username: " + registerList.get(8));
        
    }
    
    public static void main(String args[]){
        System.out.println("Welcome to Fastest Deliveryman Sdn. Bhd.\n");
        System.out.println("Please register as affiliate: ");
        System.out.println("Register -> 1");
        System.out.println("Exit -> 2");
        
        Register a = new Register();
        a.registerInput();
    }
}
