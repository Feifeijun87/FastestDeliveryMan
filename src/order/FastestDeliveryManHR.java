/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author hsuhong1210
 */
public class FastestDeliveryManHR {

    //declare arraylist
    private List<DeliveryMan> deliveryManList = new ArrayList<>();
    private List<DeliveryDetail> deliveryDetailList = new ArrayList<>();

    //declare pattern & matcher for validation purpose
    private Pattern regexPattern;
    private Matcher regMatcher;

    private int tmp = 0;

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

        Boolean verify;

        DeliveryMan dm = new DeliveryMan(1, "Loh Hsu Hong", "951210-35-5064", "Female", "12 Jalan 123", "017-4872097", "hhloh8332@gmail.com", "Hired");
        deliveryManList.add(dm);
        
        DeliveryMan dm1 = new DeliveryMan(2, "Ong Ying Qing", "750531-07-5596", "Female", "15 Jalan ABC", "019-1234555", "oyq531@gmail.com", "Resigned");
        deliveryManList.add(dm1);
        
        DeliveryMan dm2 = new DeliveryMan(3, "Yeoh Kok Xuan", "651006-07-1213", "Male", "9 Jalan K", "012-1234567", "ykxxxx@gmail.com", "Retired");
        deliveryManList.add(dm2);
        
        DeliveryMan dm3 = new DeliveryMan(4, "Ooi Wei Sheng", "850416-03-5555", "Male", "2 Jalan 222", "014-3366333", "owshahaha@gmail.com", "Hired");
        deliveryManList.add(dm3);
        
        DeliveryDetail dd = new DeliveryDetail(1, "Pending", "88 Jalan Halo", dm3);
        deliveryDetailList.add(dd);
        
        DeliveryDetail dd1 = new DeliveryDetail(2, "Delivered", "88 Jalan Wayy", dm2);
        deliveryDetailList.add(dd1);
        
        DeliveryDetail dd2 = new DeliveryDetail(3, "Pending", "88 Jalan Happy", dm);
        deliveryDetailList.add(dd2);
        
        DeliveryDetail dd3 = new DeliveryDetail(4, "Pending", "88 Jalan Ohwei", dm1);
        deliveryDetailList.add(dd3);
        

        do {
            try {
                System.out.println("----------------------");
                System.out.println("HR Staff Main Menu");
                System.out.println("----------------------");
                System.out.println("1. Add DeliveryMan");
                System.out.println("2. List DeliveryMan");
                System.out.println("3. Update DeliveryMan");
                System.out.println("4. List Pending Deliveries");
                System.out.println("5. Generate Daily Report");
                System.out.println("6. Back To Main Menu");
                System.out.print("Please select an option to proceed: ");
                choice = sc.nextInt();
            } catch (Exception error) {
                sc.next();
            }
            switch (choice) {
                case 1:
                    addStaff();
                    break;
                case 2:
                    tmp = 2;
                    viewStaff();

                    break;
                case 3:
                    tmp = 3;
                    updateStaff();

                    break;
                case 4:
                    pendingDelivery();
                    break;
                case 5:

                    break;
                case 6:
                    System.out.println(" ");
                    System.out.println("Thank you, have a nice day.");
                    break;
                default:
                    System.out.println(" ");
                    System.out.println("Wrong input, please try again!");
                    System.out.println(" ");
            }

        } while (choice != 5); //if choice = 5, will exit the program, else continue loop
    }

//    public Boolean isDigit(int choice) {
//        Boolean verify;
//
//        if (!Character.isDigit(choice)) {
//            verify = false;
//            System.out.println("Wrong input, please try again!");
//        } else {
//            verify = true;
//            System.out.println("Wrong input, please try again!dsasdas");
//        }
//
//        return verify;
//    }
    // TODO code application logic here
    public void addStaff() {

        Scanner sc = new Scanner(System.in);

        String name, ic, gender, address, contactNo, email, status;
        Boolean verify = false, verifyEmpty = false, verifyExist = false;

        System.out.println(" ");
        System.out.println("-----------");
        System.out.println("Add Staff");
        System.out.println("-----------");
        System.out.println("Please enter the delivery man details:");
        do {
            do {
                System.out.print("Name: ");
                name = sc.nextLine();

                verifyEmpty = verifyEmpty(name);

                if (verifyEmpty == false) {
                    System.out.println("Name cannot be empty, please try again.");
                    System.out.println(" ");
                }
            } while (verifyEmpty == false); // if input is empty, it will loop until input is not empty

            do {
                System.out.print("IC: ");
                ic = sc.nextLine();

                verify = verifyIC(ic);
                verifyEmpty = verifyEmpty(ic);

                if (verifyEmpty == false) {
                    System.out.println("IC cannot be empty, please try again.");
                    System.out.println(" ");

                } else if (verify == false) {
                    System.out.println("IC must in the format of xxxx-xx-xxxx, please try again.");
                    System.out.println(" ");
                }
            } while (verify == false || verifyEmpty == false); // if input is empty/wrong format, it will loop until the input is not empty/correct format

            verifyExist = verifyICExist(ic);

            if (verifyExist == false) {
                System.out.println("Delivery Man already exist, please try again.");
                System.out.println(" ");
            }
        } while (verifyExist == false); // if ic is exist, it will loop until the input is not duplicate

        do {
            System.out.print("Gender[Male/Female]: ");
            gender = sc.nextLine();

            verify = verifyGender(gender);
            verifyEmpty = verifyEmpty(gender);

            if (verifyEmpty == false) {
                System.out.println("Gender cannot be empty, please try again.");
                System.out.println(" ");

            } else if (verify == false) {
                System.out.println("Invalid Input, please try again.");
                System.out.println(" ");
            }

        } while (verify == false || verifyEmpty == false); // if input is empty/wrong format, it will loop until the input is not empty/correct format

        do {
            System.out.print("Address: ");
            address = sc.nextLine();
            verifyEmpty = verifyEmpty(address);

            if (verifyEmpty == false) {
                System.out.println("Address cannot be empty, please try again.");
                System.out.println(" ");
            }
        } while (verifyEmpty == false); // if input is empty, it will loop until the input is not empty

        do {
            System.out.print("Contact No.: ");
            contactNo = sc.nextLine();

            verify = verifyContactNo(contactNo);
            verifyEmpty = verifyEmpty(contactNo);

            if (verifyEmpty == false) {
                System.out.println("ContactNo cannot be empty, please try again.");
                System.out.println(" ");

            } else if (verify == false) {
                System.out.println("Contact No. must in the format of xxx-xxxxxxx, please try again.");
                System.out.println(" ");
            }

        } while (verify == false || verifyEmpty == false); // if input is empty/wrong format, it will loop until the input is not empty/correct format

        do {
            System.out.print("Email: ");
            email = sc.nextLine();

            verify = verifyEmailAddress(email);
            verifyEmpty = verifyEmpty(email);

            if (verifyEmpty == false) {
                System.out.println("Email cannot be empty, please try again.");
                System.out.println(" ");

            } else if (verify == false) {
                System.out.println("Email must in the format of example@gmail.com, please try again.");
                System.out.println(" ");
            }

        } while (verify == false || verify == false); // if input is empty/wrong format, it will loop until the input is not empty/correct format

        do {
            System.out.print("Status[Hired/Resigned/Retired]: ");
            status = sc.nextLine();

            verify = verifyStatus(status);
            verifyEmpty = verifyEmpty(status);

            if (verifyEmpty == false) {
                System.out.println("Status cannot be empty, please try again.");
                System.out.println(" ");

            } else if (verify == false) {
                System.out.println("Invalid Input, please try again.");
                System.out.println(" ");
            }

        } while (verify == false || verifyEmpty == false); // if input is empty/wrong format, it will loop until the input is not empty/correct format

        String nameA, genderA, statusA, addressA;

        //allow the first char of input of each word to uppercase
        nameA = toUpperCase(name);
        genderA = toUpperCase(gender);
        statusA = toUpperCase(status);
        addressA = toUpperCase(address);

        //store data inside object
        DeliveryMan dm = new DeliveryMan(deliveryManList.size() + 1, nameA, ic, genderA, addressA, contactNo, email, statusA);
        deliveryManList.add(dm);

        System.out.println(" ");
        System.out.println("DeliveryMan " + nameA + " has been added successfully.");

        System.out.println("");
        System.out.println("Back to HR Staff main menu... ");
    }

    //allow the first char of input of each word to uppercase
    public static String toUpperCase(String input) {
        String[] arr = input.split(" ");
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < arr.length; i++) {
            sb.append(Character.toUpperCase(arr[i].charAt(0)))
                    .append(arr[i].substring(1)).append(" ");
        }
        return sb.toString().trim();
    }

    //to verify whether the input is or is not null
    public Boolean verifyEmpty(String input) {
        Boolean verify;
        if (input.equals("")) {
            verify = false;
        } else {
            verify = true;
        }
        return verify;
    }

    //to verify whether the ic is or is not exits so that it will not duplicated
    public Boolean verifyICExist(String ic) {

        Boolean verify = true;

        String icConstant;

        if (deliveryManList.isEmpty()) {

        } else {
            for (int i = 0; i < deliveryManList.size(); ++i) {

                icConstant = deliveryManList.get(i).getIC();

                if (ic.equals(icConstant)) {
                    verify = false;
                    break;
                } else {
                    verify = true;
                }
            }
        }
        return verify;
    }

    //to verify whether the ic is or is not correct format
    public Boolean verifyIC(String ic) {

        Boolean verify;

        regexPattern = Pattern.compile("\\d{6}-\\d{2}-\\d{4}");
        regMatcher = regexPattern.matcher(ic);
        if (regMatcher.matches()) {
            verify = true;
        } else {
            verify = false;
        }
        return verify;
    }

    //to verify whether the gender is or is not correct format
    public boolean verifyGender(String gender) {

        Boolean verify;

        if (gender.equals("Male") || gender.equals("Female") || gender.equals("male") || gender.equals("female")) {
            verify = true;

        } else {
            verify = false;
        }

        return verify;
    }

    //to verify whether the contactNo is or is not correct format
    public Boolean verifyContactNo(String contactNo) {

        Boolean verify;

        regexPattern = Pattern.compile("\\d{3}-\\d{7}");
        regMatcher = regexPattern.matcher(contactNo);
        if (regMatcher.matches()) {
            verify = true;
        } else {
            verify = false;
        }
        return verify;
    }

    //to verify whether the email is or is not correct format
    public Boolean verifyEmailAddress(String email) {

        Boolean verify;

        regexPattern = Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
        regMatcher = regexPattern.matcher(email);
        if (regMatcher.matches()) {
            verify = true;
        } else {
            verify = false;
        }

        return verify;
    }

    //to verify whether the status is or is not correct format
    public boolean verifyStatus(String status) {

        Boolean verify;

        switch (status) {
            case "Hired":
            case "hired":
            case "Retired":
            case "retired":
            case "Resigned":
            case "resigned":
                verify = true;
                break;
            default:
                verify = false;
        }
        return verify;
    }

    public void viewStaff() {
        if (tmp == 3) {

        } else {
            System.out.println(" ");
            System.out.println("-----------");
            System.out.println("View Staff");
            System.out.println("-----------");
        }

        System.out.println("");
        for (int i = 0; i <= 120; i++) {
            System.out.print("-");
        }

        System.out.println("");
        System.out.println(String.format("| %-5s | %-15s | %-15s | %-6s | %-15s | %-15s | %-15s | %-10s |", "No.", "Name", "IC", "Gender", "Address", "Contact No.", "Email", "Status"));
        System.out.println(String.format("| %-5s | %-15s | %-15s | %-6s | %-15s | %-15s | %-15s | %-10s |", "-----", "---------------", "---------------", "------", "---------------", "---------------", "---------------", "----------"));

        //retrive data from arraylist
        if (deliveryManList.isEmpty()) {
            System.out.println("No record inside.");
        } else {
            for (int i = 0; i < deliveryManList.size(); ++i) {
                //  System.out.print(String.format("| %-5s", (i + 1) + "."));
                System.out.println(deliveryManList.get(i));
            }
        }

        for (int i = 0; i <= 120; i++) {
            System.out.print("-");
        }
        if (tmp == 3) {

        } else {
            Scanner sc = new Scanner(System.in);

            System.out.print("\nDo you want to update staff details?  (Y = Yes, N = No): ");
            char valid = sc.next().charAt(0);
            switch (valid) {
                case 'Y':
                case 'y':
                    updateStaff();
                    break;
                case 'N':
                case 'n':
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Thank You. Back to HR Staff Main Menu...");
                    System.out.println("");
                    break;
                default:
                    System.out.println(" ");
                    System.out.println("Wrong input, please try again!");
            }
        }

    }

    public void updateStaff() {
        System.out.println(" ");
        System.out.println("-----------");
        System.out.println("Update Staff");
        System.out.println("-----------");

        if (tmp == 3) {
            viewStaff();
        }

        Scanner sc = new Scanner(System.in);
        int choice = 0, choice1 = 0;
        String name = "", ic = "", gender = "", address = "", contactNo = "", email = "", status = "";
        Boolean verify = false, verifyEmpty = false, verifyExist = false, verifyChar = false;
        String nameA, genderA, statusA, addressA;

        do {
            try {
                //allow the first char of input of each word to uppercase
                System.out.println(" ");
                System.out.print("Please select a staff to update: ");
                choice = sc.nextInt();
                verifyChar = false;
            } catch (Exception error) {
                verifyChar = true;
                sc.next();
            }

            for (int i = 0; i < deliveryManList.size(); i++) {
                if (choice == deliveryManList.get(i).getId()) {
                    do {
                        try {
                            System.out.println(" ");
                            System.out.println("---------------------------------------------------");
                            System.out.println("Please choose which part that you want to update: ");
                            System.out.println("1. Name");
                            System.out.println("2. IC");
                            System.out.println("3. Gender");
                            System.out.println("4. Address");
                            System.out.println("5. Contact No.");
                            System.out.println("6. Email");
                            System.out.println("7. Status");
                            System.out.println("8. Back To HR Staff Main Menu");
                            System.out.println("---------------------------------------------------");
                            System.out.print("Enter your choice : ");
                            choice1 = sc.nextInt();
                            sc.nextLine();
                        } catch (Exception error) {

                            sc.next();
                        }
                        switch (choice1) {
                            case 1:
                                do {
                                    System.out.flush();
                                    System.out.println(" ");
                                    System.out.print("Please enter new name: ");
                                    name = sc.nextLine();

                                    verifyEmpty = verifyEmpty(name);

                                    if (verifyEmpty == false) {
                                        System.out.println("Name cannot be empty, please try again.");
                                        System.out.println(" ");
                                    }
                                } while (verifyEmpty == false); // if input is empty, it will loop until input is not empty

                                nameA = toUpperCase(name);
                                deliveryManList.get(i).setName(nameA);

                                System.out.println(" ");
                                System.out.println("----------------");
                                System.out.println("Updated Profile");
                                System.out.println("----------------");

                                for (int j = 0; j <= 120; j++) {
                                    System.out.print("-");
                                }

                                System.out.println("");
                                System.out.println(String.format("| %-5s | %-15s | %-15s | %-6s | %-15s | %-15s | %-15s | %-10s |", "No.", "Name", "IC", "Gender", "Address", "Contact No.", "Email", "Status"));
                                System.out.println(String.format("| %-5s | %-15s | %-15s | %-6s | %-15s | %-15s | %-15s | %-10s |", "-----", "---------------", "---------------", "------", "---------------", "---------------", "---------------", "----------"));
                                System.out.println(deliveryManList.get(i));

                                for (int k = 0; k <= 120; k++) {
                                    System.out.print("-");
                                }
                                System.out.println(" ");
                                break;
                            case 2:
                                do {
                                    do {
                                        System.out.print("Please enter new IC: ");
                                        ic = sc.nextLine();

                                        verify = verifyIC(ic);
                                        verifyEmpty = verifyEmpty(ic);

                                        if (verifyEmpty == false) {
                                            System.out.println("IC cannot be empty, please try again.");
                                            System.out.println(" ");

                                        } else if (verify == false) {
                                            System.out.println("IC must in the format of xxxx-xx-xxxx, please try again.");
                                            System.out.println(" ");
                                        }
                                    } while (verify == false || verifyEmpty == false); // if input is empty/wrong format, it will loop until the input is not empty/correct format

                                    verifyExist = verifyICExist(ic);

                                    if (verifyExist == false) {
                                        System.out.println("Delivery Man already exist, please try again.");
                                        System.out.println(" ");
                                    }
                                } while (verifyExist == false); // if ic is exist, it will loop until the input is not duplicate
                                deliveryManList.get(i).setIc(ic);

                                System.out.println(" ");
                                System.out.println("----------------");
                                System.out.println("Updated Profile");
                                System.out.println("----------------");

                                for (int j = 0; j <= 120; j++) {
                                    System.out.print("-");
                                }

                                System.out.println("");
                                System.out.println(String.format("| %-5s | %-15s | %-15s | %-6s | %-15s | %-15s | %-15s | %-10s |", "No.", "Name", "IC", "Gender", "Address", "Contact No.", "Email", "Status"));
                                System.out.println(String.format("| %-5s | %-15s | %-15s | %-6s | %-15s | %-15s | %-15s | %-10s |", "-----", "---------------", "---------------", "------", "---------------", "---------------", "---------------", "----------"));
                                System.out.println(deliveryManList.get(i));

                                for (int k = 0; k <= 120; k++) {
                                    System.out.print("-");
                                }
                                System.out.println(" ");
                                break;
                            case 3:
                                do {
                                    System.out.print("Please enter new Gender[Male/Female]: ");
                                    gender = sc.nextLine();

                                    verify = verifyGender(gender);
                                    verifyEmpty = verifyEmpty(gender);

                                    if (verifyEmpty == false) {
                                        System.out.println("Gender cannot be empty, please try again.");
                                        System.out.println(" ");

                                    } else if (verify == false) {
                                        System.out.println("Invalid Input, please try again.");
                                        System.out.println(" ");
                                    }

                                } while (verify == false || verifyEmpty == false); // if input is empty/wrong format, it will loop until the input is not empty/correct format
                                genderA = toUpperCase(gender);

                                deliveryManList.get(i).setGender(genderA);

                                System.out.println(" ");
                                System.out.println("----------------");
                                System.out.println("Updated Profile");
                                System.out.println("----------------");

                                for (int j = 0; j <= 120; j++) {
                                    System.out.print("-");
                                }

                                System.out.println("");
                                System.out.println(String.format("| %-5s | %-15s | %-15s | %-6s | %-15s | %-15s | %-15s | %-10s |", "No.", "Name", "IC", "Gender", "Address", "Contact No.", "Email", "Status"));
                                System.out.println(String.format("| %-5s | %-15s | %-15s | %-6s | %-15s | %-15s | %-15s | %-10s |", "-----", "---------------", "---------------", "------", "---------------", "---------------", "---------------", "----------"));
                                System.out.println(deliveryManList.get(i));

                                for (int k = 0; k <= 120; k++) {
                                    System.out.print("-");
                                }
                                System.out.println(" ");
                                break;
                            case 4:
                                do {
                                    System.out.print("Please enter new Address: ");
                                    address = sc.nextLine();
                                    verifyEmpty = verifyEmpty(address);

                                    if (verifyEmpty == false) {
                                        System.out.println("Address cannot be empty, please try again.");
                                        System.out.println(" ");
                                    }
                                } while (verifyEmpty == false); // if input is empty, it will loop until the input is not empty
                                addressA = toUpperCase(address);

                                deliveryManList.get(i).setAddress(addressA);

                                System.out.println(" ");
                                System.out.println("----------------");
                                System.out.println("Updated Profile");
                                System.out.println("----------------");

                                for (int j = 0; j <= 120; j++) {
                                    System.out.print("-");
                                }

                                System.out.println("");
                                System.out.println(String.format("| %-5s | %-15s | %-15s | %-6s | %-15s | %-15s | %-15s | %-10s |", "No.", "Name", "IC", "Gender", "Address", "Contact No.", "Email", "Status"));
                                System.out.println(String.format("| %-5s | %-15s | %-15s | %-6s | %-15s | %-15s | %-15s | %-10s |", "-----", "---------------", "---------------", "------", "---------------", "---------------", "---------------", "----------"));
                                System.out.println(deliveryManList.get(i));

                                for (int k = 0; k <= 120; k++) {
                                    System.out.print("-");
                                }
                                System.out.println(" ");
                                break;
                            case 5:
                                do {
                                    System.out.print("Please enter new Contact No.: ");
                                    contactNo = sc.nextLine();

                                    verify = verifyContactNo(contactNo);
                                    verifyEmpty = verifyEmpty(contactNo);

                                    if (verifyEmpty == false) {
                                        System.out.println("ContactNo cannot be empty, please try again.");
                                        System.out.println(" ");

                                    } else if (verify == false) {
                                        System.out.println("Contact No. must in the format of xxx-xxxxxxx, please try again.");
                                        System.out.println(" ");
                                    }

                                } while (verify == false || verifyEmpty == false); // if input is empty/wrong format, it will loop until the input is not empty/correct format

                                deliveryManList.get(i).setContactNo(contactNo);

                                System.out.println(" ");
                                System.out.println("----------------");
                                System.out.println("Updated Profile");
                                System.out.println("----------------");

                                for (int j = 0; j <= 120; j++) {
                                    System.out.print("-");
                                }

                                System.out.println("");
                                System.out.println(String.format("| %-5s | %-15s | %-15s | %-6s | %-15s | %-15s | %-15s | %-10s |", "No.", "Name", "IC", "Gender", "Address", "Contact No.", "Email", "Status"));
                                System.out.println(String.format("| %-5s | %-15s | %-15s | %-6s | %-15s | %-15s | %-15s | %-10s |", "-----", "---------------", "---------------", "------", "---------------", "---------------", "---------------", "----------"));
                                System.out.println(deliveryManList.get(i));

                                for (int k = 0; k <= 120; k++) {
                                    System.out.print("-");
                                }
                                System.out.println(" ");
                                break;
                            case 6:
                                do {
                                    System.out.print("Please enter new Email: ");
                                    email = sc.nextLine();

                                    verify = verifyEmailAddress(email);
                                    verifyEmpty = verifyEmpty(email);

                                    if (verifyEmpty == false) {
                                        System.out.println("Email cannot be empty, please try again.");
                                        System.out.println(" ");

                                    } else if (verify == false) {
                                        System.out.println("Email must in the format of example@gmail.com, please try again.");
                                        System.out.println(" ");
                                    }

                                } while (verify == false || verify == false); // if input is empty/wrong format, it will loop until the input is not empty/correct format
                                deliveryManList.get(i).setEmail(email);

                                System.out.println(" ");
                                System.out.println("----------------");
                                System.out.println("Updated Profile");
                                System.out.println("----------------");

                                for (int j = 0; j <= 120; j++) {
                                    System.out.print("-");
                                }

                                System.out.println("");
                                System.out.println(String.format("| %-5s | %-15s | %-15s | %-6s | %-15s | %-15s | %-15s | %-10s |", "No.", "Name", "IC", "Gender", "Address", "Contact No.", "Email", "Status"));
                                System.out.println(String.format("| %-5s | %-15s | %-15s | %-6s | %-15s | %-15s | %-15s | %-10s |", "-----", "---------------", "---------------", "------", "---------------", "---------------", "---------------", "----------"));
                                System.out.println(deliveryManList.get(i));

                                for (int k = 0; k <= 120; k++) {
                                    System.out.print("-");
                                }
                                System.out.println(" ");
                                break;
                            case 7:
                                do {
                                    System.out.print("Please enter new Status[Hired/Resigned/Retired]: ");
                                    status = sc.nextLine();

                                    verify = verifyStatus(status);
                                    verifyEmpty = verifyEmpty(status);

                                    if (verifyEmpty == false) {
                                        System.out.println("Status cannot be empty, please try again.");
                                        System.out.println(" ");

                                    } else if (verify == false) {
                                        System.out.println("Invalid Input, please try again.");
                                        System.out.println(" ");
                                    }

                                } while (verify == false || verifyEmpty == false);
                                statusA = toUpperCase(status);

                                deliveryManList.get(i).setStatus(statusA);

                                System.out.println(" ");
                                System.out.println("----------------");
                                System.out.println("Updated Profile");
                                System.out.println("----------------");

                                for (int j = 0; j <= 120; j++) {
                                    System.out.print("-");
                                }

                                System.out.println("");
                                System.out.println(String.format("| %-5s | %-15s | %-15s | %-6s | %-15s | %-15s | %-15s | %-10s |", "No.", "Name", "IC", "Gender", "Address", "Contact No.", "Email", "Status"));
                                System.out.println(String.format("| %-5s | %-15s | %-15s | %-6s | %-15s | %-15s | %-15s | %-10s |", "-----", "---------------", "---------------", "------", "---------------", "---------------", "---------------", "----------"));
                                System.out.println(deliveryManList.get(i));

                                for (int k = 0; k <= 120; k++) {
                                    System.out.print("-");
                                }
                                System.out.println(" ");
                                break;
                            case 8:
                                System.out.println(" ");
                                System.out.println("Thank You. Back to HR Staff Main Menu...");
                                System.out.println(" ");
                                break;
                            default:
                                System.out.println(" ");
                                System.out.println("Wrong input, please try again!");
                        }
                    } while (choice1 != 8);
                    break;
                } else {
                    System.out.println(" ");
                    System.out.println("Wrong input, please try again!");
                    verifyChar = true;
                }
            }
        } while (verifyChar == true);
    }

    public void pendingDelivery() {
        System.out.println(" ");
        System.out.println("------------------------");
        System.out.println("List Pending Deliveries");
        System.out.println("------------------------");
        
         System.out.println("");
        for (int i = 0; i <= 59; i++) {
            System.out.print("-");
        }

        System.out.println("");
        System.out.println(String.format("| %-5s | %-10s | %-16s | %-15s | ", "No.", "Status", "Delivery Address", "Delivery Man"));
        System.out.println(String.format("| %-5s | %-10s | %-16s | %-15s | ", "-----", "----------", "----------------", "---------------"));
        
        //retrive data from arraylist
        if (deliveryDetailList.isEmpty()) {
            System.out.println("No record inside.");
        } else {
            for (int i = 0; i < deliveryDetailList.size(); ++i) {
                //  System.out.print(String.format("| %-5s", (i + 1) + "."));
                if(deliveryDetailList.get(i).getStatus() == "Pending")
                System.out.println(String.format("| %-5d | %-10s | %-16s | %-15s | ", deliveryDetailList.get(i).getId(), deliveryDetailList.get(i).getStatus(), deliveryDetailList.get(i).getCustAddress(), deliveryDetailList.get(i).getDeliveryMan().getName()));
            }
        }
       for (int i = 0; i <= 59; i++) {
            System.out.print("-");
        }
       
       System.out.println(" ");
       System.out.println(" ");

    }
}
