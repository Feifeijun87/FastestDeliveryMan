/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author hsuhong1210
 */
public class FastestDeliveryManHR {

    private List<String> deliveryManList = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FastestDeliveryManHR fd = new FastestDeliveryManHR();
        fd.staffMainMenu();
    }

    public void staffMainMenu() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        System.out.println("----------------------");
        System.out.println("HR Staff Main Menu");
        System.out.println("----------------------");
        System.out.println("1. Add DeliveryMan");
        System.out.println("2. View DeliveryMan");
        System.out.println("3. Update DeliveryMan");
        System.out.println("4. Generate Daily Report");
        System.out.println("5. Back To Main Menu");
        System.out.print("Please select an option to proceed:");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                addStaff();
                break;
            case 2:
                viewStaff();
                break;
            case 3:

                break;
            case 4:

                break;
            case 5:
                System.out.println("");
                System.out.println("Thank you, have a nice day.");
                break;
        }

        // TODO code application logic here
    }

    public void addStaff() {

        Scanner sc = new Scanner(System.in);

        String name, gender, address, contactNo, email, status;

        System.out.println(" ");
        System.out.println("---------------");
        System.out.print("Add staff page\n");
        System.out.println("---------------");
        System.out.println("Please enter the delivery man details:");
        System.out.print("Name: ");
        name = sc.nextLine();
        deliveryManList.add(name);

        System.out.print("Gender[Male/Female]: ");
        gender = sc.nextLine();
        deliveryManList.add(gender);

        System.out.print("Address: ");
        address = sc.nextLine();
        deliveryManList.add(address);

        System.out.print("Contact No.: ");
        contactNo = sc.nextLine();
        deliveryManList.add(contactNo);

        System.out.print("Email: ");
        email = sc.nextLine();
        deliveryManList.add(email);

        System.out.print("Status: ");
        status = sc.nextLine();
        deliveryManList.add(status);

       // DeliveryMan dm = new DeliveryMan(name, gender, address, contactNo, email, status);
        // deliveryManList.add(dm);

        System.out.println(" ");
        System.out.println("DeliveryMan " + name + " has been added successfully.");
        
        System.out.println("");
        System.out.println("Back to HR Staff main menu... ");
        staffMainMenu();
    }

    public void viewStaff() {
        System.out.println(" ");
        System.out.println("-----------");
        System.out.println("View Staff");
        System.out.println("-----------");
        
        System.out.println("Name Gender Address Contact No. Email Status ");
        System.out.println("---- ------ ------- ----------- ----- ----- ");
        
        for (int i = 0; i < deliveryManList.size(); ++i) {
            if (i == 5 || i == 11 || i == 17 || i == 18){
                System.out.println(deliveryManList.get(i));
            }else{
                System.out.print(deliveryManList.get(i) + " ");
            }
        }
        
        System.out.println("");
        System.out.println("Back to HR Staff main menu... ");
        System.out.println(" ");
        staffMainMenu();
    }

}

