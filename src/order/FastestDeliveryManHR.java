/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
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

    private List<DeliveryReportDistance> dmReport = new ArrayList<>();
    private List<DeliveryReportDeliveries> dmReport1 = new ArrayList<>();

    //declare pattern & matcher for validation purpose
    private Pattern regexPattern;
    private Matcher regMatcher;

    private int tmp = 0;
    private static int totalDistance = 0;
    //private static int test = 0;
    private static int printID = 1;
    private static double revNo = 1.1;
    private List<String> dateList = new ArrayList<>();

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

        //insert data to delivery man object
        DeliveryMan dm = new DeliveryMan(1, "Loh Hsu Hong", "951210-35-5064", "Female", "12 Jalan 123", "017-4872097", "hhloh8332@gmail.com", "Hired");
        deliveryManList.add(dm);

        DeliveryMan dm1 = new DeliveryMan(2, "Ong Ying Qing", "750531-07-5596", "Female", "15 Jalan ABC", "019-1234555", "oyq531@gmail.com", "Resigned");
        deliveryManList.add(dm1);

        DeliveryMan dm2 = new DeliveryMan(3, "Yeoh Kok Xuan", "651006-07-1213", "Male", "9 Jalan K", "012-1234567", "ykxxxx@gmail.com", "Retired");
        deliveryManList.add(dm2);

        DeliveryMan dm3 = new DeliveryMan(4, "Ooi Wei Sheng", "850416-03-5555", "Male", "2 Jalan 222", "014-3366333", "owshahaha@gmail.com", "Hired");
        deliveryManList.add(dm3);

        //insert data to delivery detail object
        DeliveryDetail dd = new DeliveryDetail(1, "Pending", "88 Jalan Halo", dm3, "07/12/2017", 10);
        deliveryDetailList.add(dd);

        DeliveryDetail dd1 = new DeliveryDetail(2, "Delivered", "88 Jalan Wayy", dm2, "07/12/2017", 3);
        deliveryDetailList.add(dd1);

        DeliveryDetail dd2 = new DeliveryDetail(3, "Pending", "88 Jalan Happy", dm, "07/12/2017", 7);
        deliveryDetailList.add(dd2);

        DeliveryDetail dd3 = new DeliveryDetail(4, "Pending", "88 Jalan Ohwei", dm1, "07/12/2017", 6);
        deliveryDetailList.add(dd3);

        DeliveryDetail dd4 = new DeliveryDetail(5, "Delivered", "12 Jalan Season", dm3, "08/12/2017", 9);
        deliveryDetailList.add(dd4);

        DeliveryDetail dd5 = new DeliveryDetail(6, "Delivered", "13 Jalan Year", dm2, "08/12/2017", 3);
        deliveryDetailList.add(dd5);

        DeliveryDetail dd6 = new DeliveryDetail(7, "Delivered", "14 Jalan Cookie", dm, "08/12/2017", 2);
        deliveryDetailList.add(dd6);

        DeliveryDetail dd7 = new DeliveryDetail(8, "Delivered", "15 Jalan Time", dm1, "08/12/2017", 5);
        deliveryDetailList.add(dd7);

        DeliveryDetail dd8 = new DeliveryDetail(9, "Delivered", "16 Jalan Door", dm3, "09/12/2017", 8);
        deliveryDetailList.add(dd8);

        DeliveryDetail dd9 = new DeliveryDetail(10, "Delivered", "25 Jalan Hang", dm2, "09/12/2017", 1);
        deliveryDetailList.add(dd9);

        DeliveryDetail dd10 = new DeliveryDetail(11, "Delivered", "26 Jalan Fire", dm, "09/12/2017", 12);
        deliveryDetailList.add(dd10);

        DeliveryDetail dd11 = new DeliveryDetail(12, "Delivered", "27 Jalan Merry", dm1, "09/12/2017", 2);
        deliveryDetailList.add(dd11);

        DeliveryDetail dd12 = new DeliveryDetail(13, "Delivered", "28 Jalan King", dm, "10/12/2017", 8);
        deliveryDetailList.add(dd12);

        DeliveryDetail dd13 = new DeliveryDetail(14, "Delivered", "56 Jalan Queen", dm1, "10/12/2017", 7);
        deliveryDetailList.add(dd13);

        DeliveryDetail dd14 = new DeliveryDetail(15, "Delivered", "55 Jalan Prince", dm, "10/12/2017", 5);
        deliveryDetailList.add(dd14);

        DeliveryDetail dd15 = new DeliveryDetail(16, "Delivered", "54 Jalan Princess", dm1, "10/12/2017", 4);
        deliveryDetailList.add(dd15);

        DeliveryDetail dd16 = new DeliveryDetail(17, "Delivered", "34 Jalan Well", dm, "10/12/2017", 4);
        deliveryDetailList.add(dd16);

        DeliveryDetail dd17 = new DeliveryDetail(18, "Delivered", "35 Jalan Fruit", dm1, "10/12/2017", 10);
        deliveryDetailList.add(dd17);

        DeliveryDetail dd18 = new DeliveryDetail(19, "Delivered", "36 Jalan Right", dm1, "10/12/2017", 7);
        deliveryDetailList.add(dd18);

        DeliveryReportDistance dr = new DeliveryReportDistance(0, "Yeoh Kok Xuan", 20, "05/12/2017", 1, 1.1);
        dmReport.add(dr);

        DeliveryReportDistance dr1 = new DeliveryReportDistance(1, "Loh Hsu Hong", 10, "05/12/2017", 1, 1.1);
        dmReport.add(dr1);

        DeliveryReportDistance dr2 = new DeliveryReportDistance(2, "Ooi Wei Sheng", 31, "05/12/2017", 1, 1.1);
        dmReport.add(dr2);

        DeliveryReportDistance dr3 = new DeliveryReportDistance(3, "Ong Ying Qing", 24, "05/12/2017", 1, 1.1);
        dmReport.add(dr3);

        DeliveryReportDistance dr4 = new DeliveryReportDistance(0, "Yeoh Kok Xuan", 20, "06/12/2017", 2, 1.2);
        dmReport.add(dr4);

        DeliveryReportDistance dr5 = new DeliveryReportDistance(1, "Loh Hsu Hong", 30, "06/12/2017", 2, 1.2);
        dmReport.add(dr5);

        DeliveryReportDistance dr6 = new DeliveryReportDistance(2, "Ong Ying Qing", 22, "06/12/2017", 2, 1.2);
        dmReport.add(dr6);

        DeliveryReportDeliveries drd = new DeliveryReportDeliveries(0, "Yeoh Kok Xuan", 5, "05/12/2017", 1, 1.1);
        dmReport1.add(drd);

        DeliveryReportDeliveries drd1 = new DeliveryReportDeliveries(1, "Loh Hsu Hong", 6, "05/12/2017", 1, 1.1);
        dmReport1.add(drd1);

        DeliveryReportDeliveries drd2 = new DeliveryReportDeliveries(2, "Ooi Wei Sheng", 3, "05/12/2017", 1, 1.1);
        dmReport1.add(drd2);

        DeliveryReportDeliveries drd3 = new DeliveryReportDeliveries(3, "Ong Ying Qing", 4, "05/12/2017", 1, 1.1);
        dmReport1.add(drd3);

        DeliveryReportDeliveries drd4 = new DeliveryReportDeliveries(0, "Yeoh Kok Xuan", 2, "06/12/2017", 2, 1.2);
        dmReport1.add(drd4);

        DeliveryReportDeliveries drd5 = new DeliveryReportDeliveries(1, "Loh Hsu Hong", 4, "06/12/2017", 2, 1.2);
        dmReport1.add(drd5);

        DeliveryReportDeliveries drd6 = new DeliveryReportDeliveries(2, "Ong Ying Qing", 6, "06/12/2017", 2, 1.2);
        dmReport1.add(drd6);

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
                    generateDailyReport();
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

        } while (choice != 6); //if choice = 5, will exit the program, else continue loop
    }

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
            System.out.print("Gender[M: Male / F: Female]: ");
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
            System.out.print("Status[H: Hired / R: Resigned / D: Retired]: ");
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
        String genderV = "", statusV = "";

        if (gender.equals("M") || gender.equals("m")) {
            genderV = "Male";
        } else if (gender.equals("F") || gender.equals("f")) {
            genderV = "Female";
        }

        if (status.equals("H") || status.equals("h")) {
            statusV = "Hired";
        } else if (status.equals("R") || status.equals("r")) {
            statusV = "Resigned";
        } else if (status.equals("D") || status.equals("d")) {
            statusV = "Retired";
        }

        //allow the first char of input of each word to uppercase
        nameA = toUpperCase(name);
        genderA = toUpperCase(genderV);
        statusA = toUpperCase(statusV);
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

        if (gender.equals("M") || gender.equals("F") || gender.equals("m") || gender.equals("f")) {
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
            case "H":
            case "h":
            case "R":
            case "r":
            case "D":
            case "d":
                verify = true;
                break;
            default:
                verify = false;
        }
        return verify;
    }

    // to view the delivery man
    public void viewStaff() {
        if (tmp == 3) {

        } else {
            System.out.println(" ");
            System.out.println("-----------");
            System.out.println("View Staff");
            System.out.println("-----------");
        }

        System.out.println("");
        for (int i = 0; i <= 136; i++) {
            System.out.print("-");
        }

        System.out.println("");
        System.out.println(String.format("| %-5s | %-20s | %-15s | %-6s | %-20s | %-15s | %-20s | %-10s |", "No.", "Name", "IC", "Gender", "Address", "Contact No.", "Email", "Status"));
        System.out.println(String.format("| %-5s | %-20s | %-15s | %-6s | %-20s | %-15s | %-20s | %-10s |", "-----", "--------------------", "---------------", "------", "--------------------", "---------------", "--------------------", "----------"));

        //retrive data from arraylist
        if (deliveryManList.isEmpty()) {
            System.out.println("No record inside.");
        } else {
            for (int i = 0; i < deliveryManList.size(); ++i) {
                System.out.println(deliveryManList.get(i));
            }
        }

        for (int i = 0; i <= 136; i++) {
            System.out.print("-");
        }
        if (tmp == 3) {

        } else {
            Scanner sc = new Scanner(System.in);
            char valid;
            int verify = 0;
            do {
                System.out.print("\nDo you want to update staff details?  (Y = Yes, N = No): ");
                valid = sc.next().charAt(0);
                switch (valid) {
                    case 'Y':
                    case 'y':
                        verify = 1;
                        updateStaff();
                        break;
                    case 'N':
                    case 'n':
                        verify = 1;
                        System.out.println("");
                        System.out.println("");
                        System.out.println("Thank You. Back to HR Staff Main Menu...");
                        System.out.println("");
                        break;
                    default:
                        verify = 0;
                        System.out.println(" ");
                        System.out.println("Wrong input, please try again!");
                }
            } while (verify == 0); //if verify != 0, will exit the loop, else continue loop
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
        Boolean verify = false, verifyEmpty = false, verifyExist = false, verifyChar = false, verifyChoice = false;
        String nameA, genderA, statusA, addressA;

        do {
            try {
                System.out.println(" ");
                System.out.print("Please select a staff to update(-1 back to HR staff main menu): ");
                choice = sc.nextInt();
                verifyChar = false;
                verifyChoice = false;
            } catch (Exception error) {
                verifyChar = true;
                verifyChoice = false;
                sc.next();
            }

            if ((choice <= (deliveryManList.size()) && verifyChar == false && choice > 0) || choice == -1) {
                verifyChoice = true;
                verifyChar = true;
            } else {
                verifyChoice = false;
                verifyChar = true;
                System.out.println(" ");
                System.out.print("Invalid input. Please try again.");
                System.out.println(" ");
            }
        } while (verifyChar == false || verifyChoice == false); //if verifyChar = true or verifyChoice = true, will exit the loop, else continue loop

        if (choice == -1) {
            System.out.println(" ");
            System.out.print("Thank you. Back to HR staff Main Menu...");
            System.out.println(" ");
        } else {
            //loop the data from delivery man arrayList
            for (int i = 0; i < deliveryManList.size(); i++) {
                if (choice == deliveryManList.get(i).getId()) { //if choice match with the id that inside arrayList, will continue
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

                                for (int j = 0; j <= 136; j++) {
                                    System.out.print("-");
                                }

                                System.out.println("");
                                System.out.println(String.format("| %-5s | %-20s | %-15s | %-6s | %-20s | %-15s | %-20s | %-10s |", "No.", "Name", "IC", "Gender", "Address", "Contact No.", "Email", "Status"));
                                System.out.println(String.format("| %-5s | %-20s | %-15s | %-6s | %-20s | %-15s | %-20s | %-10s |", "-----", "--------------------", "---------------", "------", "--------------------", "---------------", "--------------------", "----------"));
                                System.out.println(deliveryManList.get(i));

                                for (int k = 0; k <= 136; k++) {
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

                                for (int j = 0; j <= 136; j++) {
                                    System.out.print("-");
                                }

                                System.out.println("");
                                System.out.println(String.format("| %-5s | %-20s | %-15s | %-6s | %-20s | %-15s | %-20s | %-10s |", "No.", "Name", "IC", "Gender", "Address", "Contact No.", "Email", "Status"));
                                System.out.println(String.format("| %-5s | %-20s | %-15s | %-6s | %-20s | %-15s | %-20s | %-10s |", "-----", "--------------------", "---------------", "------", "--------------------", "---------------", "--------------------", "----------"));
                                System.out.println(deliveryManList.get(i));

                                for (int k = 0; k <= 136; k++) {
                                    System.out.print("-");
                                }
                                System.out.println(" ");
                                break;
                            case 3:
                                do {
                                    System.out.print("Please enter new Gender[M: Male / F: Female]: ");
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

                                String genderV = "";

                                if (gender.equals("M") || gender.equals("m")) {
                                    genderV = "Male";
                                } else if (gender.equals("F") || gender.equals("f")) {
                                    genderV = "Female";
                                }

                                genderA = toUpperCase(genderV);

                                deliveryManList.get(i).setGender(genderA);

                                System.out.println(" ");
                                System.out.println("----------------");
                                System.out.println("Updated Profile");
                                System.out.println("----------------");

                                for (int j = 0; j <= 136; j++) {
                                    System.out.print("-");
                                }

                                System.out.println("");
                                System.out.println(String.format("| %-5s | %-20s | %-15s | %-6s | %-20s | %-15s | %-20s | %-10s |", "No.", "Name", "IC", "Gender", "Address", "Contact No.", "Email", "Status"));
                                System.out.println(String.format("| %-5s | %-20s | %-15s | %-6s | %-20s | %-15s | %-20s | %-10s |", "-----", "--------------------", "---------------", "------", "--------------------", "---------------", "--------------------", "----------"));
                                System.out.println(deliveryManList.get(i));

                                for (int k = 0; k <= 136; k++) {
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

                                for (int j = 0; j <= 136; j++) {
                                    System.out.print("-");
                                }

                                System.out.println("");
                                System.out.println(String.format("| %-5s | %-20s | %-15s | %-6s | %-20s | %-15s | %-20s | %-10s |", "No.", "Name", "IC", "Gender", "Address", "Contact No.", "Email", "Status"));
                                System.out.println(String.format("| %-5s | %-20s | %-15s | %-6s | %-20s | %-15s | %-20s | %-10s |", "-----", "--------------------", "---------------", "------", "--------------------", "---------------", "--------------------", "----------"));
                                System.out.println(deliveryManList.get(i));

                                for (int k = 0; k <= 136; k++) {
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

                                for (int j = 0; j <= 136; j++) {
                                    System.out.print("-");
                                }

                                System.out.println("");
                                System.out.println(String.format("| %-5s | %-20s | %-15s | %-6s | %-20s | %-15s | %-20s | %-10s |", "No.", "Name", "IC", "Gender", "Address", "Contact No.", "Email", "Status"));
                                System.out.println(String.format("| %-5s | %-20s | %-15s | %-6s | %-20s | %-15s | %-20s | %-10s |", "-----", "--------------------", "---------------", "------", "--------------------", "---------------", "--------------------", "----------"));
                                System.out.println(deliveryManList.get(i));

                                for (int k = 0; k <= 136; k++) {
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

                                for (int j = 0; j <= 136; j++) {
                                    System.out.print("-");
                                }

                                System.out.println("");
                                System.out.println(String.format("| %-5s | %-20s | %-15s | %-6s | %-20s | %-15s | %-20s | %-10s |", "No.", "Name", "IC", "Gender", "Address", "Contact No.", "Email", "Status"));
                                System.out.println(String.format("| %-5s | %-20s | %-15s | %-6s | %-20s | %-15s | %-20s | %-10s |", "-----", "--------------------", "---------------", "------", "--------------------", "---------------", "--------------------", "----------"));
                                System.out.println(deliveryManList.get(i));

                                for (int k = 0; k <= 136; k++) {
                                    System.out.print("-");
                                }
                                System.out.println(" ");
                                break;
                            case 7:
                                do {
                                    System.out.print("Please enter new Status[H: Hired / R : Resigned / D: Retired]: ");
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
                                String statusV = "";
                                if (status.equals("H") || status.equals("h")) {
                                    statusV = "Hired";
                                } else if (status.equals("R") || status.equals("r")) {
                                    statusV = "Resigned";
                                } else if (status.equals("D") || status.equals("d")) {
                                    statusV = "Retired";
                                }
                                statusA = toUpperCase(statusV);

                                deliveryManList.get(i).setStatus(statusA);

                                System.out.println(" ");
                                System.out.println("----------------");
                                System.out.println("Updated Profile");
                                System.out.println("----------------");

                                for (int j = 0; j <= 136; j++) {
                                    System.out.print("-");
                                }

                                System.out.println("");
                                System.out.println(String.format("| %-5s | %-20s | %-15s | %-6s | %-20s | %-15s | %-20s | %-10s |", "No.", "Name", "IC", "Gender", "Address", "Contact No.", "Email", "Status"));
                                System.out.println(String.format("| %-5s | %-20s | %-15s | %-6s | %-20s | %-15s | %-20s | %-10s |", "-----", "--------------------", "---------------", "------", "--------------------", "---------------", "--------------------", "----------"));
                                System.out.println(deliveryManList.get(i));

                                for (int k = 0; k <= 136; k++) {
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
                } //else {
//                    System.out.println(" ");
//                    System.out.println("Wrong input, please try again!");
//                    verifyChar = true;
            }
        }

    }
    // } while (verifyChar == true);
    //  }

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
                if (deliveryDetailList.get(i).getStatus() == "Pending") {
                    System.out.println(String.format("| %-5d | %-10s | %-16s | %-15s | ", deliveryDetailList.get(i).getId(), deliveryDetailList.get(i).getStatus(), deliveryDetailList.get(i).getCustAddress(), deliveryDetailList.get(i).getDeliveryMan().getName()));
                }
            }
        }
        for (int i = 0; i <= 59; i++) {
            System.out.print("-");
        }

        System.out.println(" ");
        System.out.println(" ");

    }

    public void generateDailyReport() {

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            try {
                System.out.println(" ");
                System.out.println("----------------------------");
                System.out.println("Generate Daily Report Menu");
                System.out.println("----------------------------");
                System.out.println("1. Distance Travelled Daily Report");
                System.out.println("2. Total Deliveries Daily Report");
                System.out.println("3. Back to HR Main Menu");

                System.out.print("Please select an option to proceed: ");
                choice = sc.nextInt();
            } catch (Exception error) {
                sc.next();
            }
            switch (choice) {
                case 1:
                    generateDailyReportDistance();
                    break;
                case 2:
                    generateDailyReportDeliveries1();
                    break;
                default:
                    System.out.println(" ");
                    System.out.println("Wrong input, please try again aaa!");
                    System.out.println(" ");
            }

        } while (choice != 3);

    }

    public void generateDailyReportDistance() {
        //Tmrw do: verify date that is not available inside database, report format
        Scanner sc = new Scanner(System.in);
        String dateInput = "";
        int count = 0;
        Boolean verify = false, verifyEmpty = false, verifyDateExist = false, verifyDateList = false, verifyne1 = true;
        List<DeliveryDetail> dmList = new ArrayList<>();
        List<DeliveryDetail> dmList1 = new ArrayList<>();

        do {
            System.out.println(" ");
            System.out.println("--------------------------------");
            System.out.println("Distance Travelled Daily Report");
            System.out.println("--------------------------------");
            System.out.print("Please write the date that need to generate report(dd/mm/yyyy)[-1 back to Generate Daily Report Menu]: ");
            dateInput = sc.nextLine();

            verify = verifyDate(dateInput);
            verifyEmpty = verifyEmpty(dateInput);
            verifyDateExist = verifyDateExist(dateInput);
            verifyDateList = verifyDateList(dateInput);

            if (dateInput.equals("-1")) {
                verify = true;
                verifyEmpty = true;
                verifyDateExist = true;
                verifyDateList = true;
                verifyne1 = true;
            } else {
                if (verifyEmpty == false) {
                    System.out.println("Date cannot be empty, please try again.");
                    System.out.println(" ");
                } else if (verify == false) {
                    System.out.println("Date must in the format of dd/mm/yyyy, please try again.");
                    System.out.println(" ");
                } else if (verifyDateList == false) {
                    System.out.println("Report already generated, please try again.");
                    System.out.println(" ");
                    printDailyReportDistance(dateInput, dmReport);
                } else if (verifyDateExist == false) {
                    System.out.println("Date does not exist, please try again.");
                    System.out.println(" ");
                }

                if (verifyEmpty == true && verify == true && verifyDateList == true && verifyDateExist == true) {
                    verifyne1 = true;
                }
            }

        } while (verify == false || verifyEmpty == false || verifyDateExist == false || verifyDateList == false || verifyne1 == false);
        if (dateInput.equals("-1")) {
            System.out.println(" ");
            System.out.print("Thank you. Back to Generate Daily Report Menu...");
            System.out.println(" ");
        } else {
            if (deliveryDetailList.isEmpty()) {
                System.out.println("No record inside.");
            } else {
                for (int i = 0; i < deliveryDetailList.size(); ++i) {

                    //System.out.println("aa.");
                    if (deliveryDetailList.get(i).getStatus() == "Delivered" && dateInput.equals(deliveryDetailList.get(i).getDate())) {
                        //1, "Pending", "88 Jalan Halo", dm3, "7/12/2017", 10
                        // id,status, deliveryMan, custAddress, date, distance;        

                        //   System.out.println("bb.");
                        DeliveryDetail dm = new DeliveryDetail(deliveryDetailList.get(i).getId(), deliveryDetailList.get(i).getStatus(), deliveryDetailList.get(i).getCustAddress(), deliveryDetailList.get(i).getDeliveryMan(), deliveryDetailList.get(i).getDate(), deliveryDetailList.get(i).getDistance());
                        dmList.add(dm);

                        DeliveryDetail dm2 = new DeliveryDetail(deliveryDetailList.get(i).getId(), deliveryDetailList.get(i).getStatus(), deliveryDetailList.get(i).getCustAddress(), deliveryDetailList.get(i).getDeliveryMan(), deliveryDetailList.get(i).getDate(), deliveryDetailList.get(i).getDistance());
                        dmList1.add(dm2);
                    }
                }
            }

            String tmp = "";

//        List<DeliveryReportDistance> dmReport = new ArrayList<>();
            // List<String> dmList2Name = new ArrayList<>();
            //  List<Integer> dmListDistance = new ArrayList<>();
            //      tmp = dmList.get(0).getDeliveryMan().getIC();
            //0 = A, 1 = B, 2 = A  
            int consInt = 0;

            // printID++;
            // revNo = (revNo + 0.1);
            //String printingID = "";
            //  Double revisionNo = 0.0;
//        for (int i = 0; i < dmReport.size(); ++i) {
//            if (dateInput.equals(dmReport.get(i).getDate())) {
//               // printingID = "FDM-" + dmReport.get(i).getPrintId();
//               // revisionNo = dmReport.get(i).getRevisionNo();
//                break;
//            }
//        }
            //Collections.sort(arr, Collections.reverseOrder());
            int printNo = 0;
            printNo = dmReport.get(dmReport.size() - 1).getPrintId();
            printNo++;

            double reviNo = 0.0;
            reviNo = dmReport.get(dmReport.size() - 1).getRevisionNo();
            reviNo = (reviNo + 0.1);

            DeliveryReportDistance dm = new DeliveryReportDistance(consInt, dmList.get(consInt).getDeliveryMan().getName(), dmList.get(consInt).getDistance(), dateInput, printNo, reviNo);
            dmReport.add(dm);
            List<String> dmTmp = new ArrayList<>();
            //dmTmpName.add(dmList.get(consInt).getDeliveryMan().getName());

            String consName = dmList.get(consInt).getDeliveryMan().getName();
            dmTmp.add(consName);

            for (int b = 0; b < dmList.size(); ++b) {
                //System.out.println("dmReport.get(b) " + dmReport.get(b));
                if (consName.equals(dmList.get(b).getDeliveryMan().getName())) {

                } else {
                    int test = 0;

                    if (dmTmp.isEmpty()) {

                    } else {
                        for (int h = 0; h < dmTmp.size(); ++h) {
                            if (dmList.get(b).getDeliveryMan().getName().equals(dmTmp.get(h))) {
                                test += 1;
                            }
                        }
                    }

                    if (test == 0) {

                        //   for (int c = 0; c < dmTmpName.size(); ++c) {
                        //   if (dmTmpName.get(c).equals(dmList.get(b).getDeliveryMan().getName())) {
                        //    } else {
                        consInt++;
                        DeliveryReportDistance dm5 = new DeliveryReportDistance(consInt, dmList.get(b).getDeliveryMan().getName(), dmList.get(b).getDistance(), dateInput, printNo, reviNo);
                        dmReport.add(dm5);

                        dmTmp.add(dmList.get(b).getDeliveryMan().getName());

                        //System.out.println("tmpName " + dmTmpName.get(c));
                    }
                }
            }

//System.out.println("cc.");
            List<Integer> dmReportTest = new ArrayList<>();

            if (dmList.isEmpty()) {
                System.out.println("No record inside.");
                //    System.out.println("dd.");
            } else {
                for (int i = 0; i < dmList.size(); ++i) {//0 //2

                    tmp = dmList.get(i).getDeliveryMan().getIC(); //0 //2

                    // System.out.println("dmReport.get(i).getId() " + dmReport.get(i).getId());
//                System.out.println("i" + i);
//                System.out.println("dmList1.size()" + dmList1.size());
//                System.out.println("i tmp" + tmp);
                    for (int j = 0; j < dmList1.size(); ++j) { //2 //0
//                    System.out.println("j" + j);
//                    System.out.println("start dmList1.get(j).getDeliveryMan().getName() " + dmList1.get(j).getDeliveryMan().getName());
                        if (i == j) {
                        } else {
                            // 
                            //  System.out.println("hh." + j);
                            if (tmp.equals(dmList1.get(j).getDeliveryMan().getIC())) { //true
//                            System.out.println("dmList1.get(j).getDeliveryMan().getName() " + dmList1.get(j).getDeliveryMan().getName());

                                for (int k = 0; k < dmReport.size(); ++k) {
//                                System.out.println("k" + k);
//                                System.out.println("dmReport.get(k).getId() " + dmReport.get(k).getId());

                                    if (j == dmReport.get(k).getId() && dmList1.get(j).getDeliveryMan().getName().equals(dmReport.get(k).getName())) {
//                                    System.out.println("same" + k);
                                    } else if (dmList1.get(j).getDeliveryMan().getName().equals(dmReport.get(k).getName())) {
                                        int test = 0;

                                        if (dmReportTest.isEmpty()) {

                                        } else {
                                            for (int h = 0; h < dmReportTest.size(); ++h) {
                                                if (j == dmReportTest.get(h)) {
                                                    test += 1;
                                                }
                                            }
                                        }
                                        if (test == 0) {
//                                        System.out.println("after dmReport.get(k).getId() " + dmReport.get(k).getId());

                                            totalDistance = dmList1.get(j).getDistance() + dmReport.get(k).getTotalDistance();

                                            dmReport.get(k).setTotalDistance(totalDistance);
//                                        System.out.println("k dmReport.get(k).getName()" + dmReport.get(k).getName());
//                                        System.out.println("k totalDistance " + totalDistance);

                                            dmReportTest.add(j);
                                        }

                                    } else {

//                                    System.out.println("dsa dmReport.get(k).getName()" + dmReport.get(k).getName());
                                        // DeliveryReportDistance dm1 = new DeliveryReportDistance(i, dmList.get(i).getDeliveryMan().getName(), dmList.get(i).getDistance());
                                        //  dmReport.add(dm1);
                                    }

                                }

                                // dmList2Name.add(dmList1.get(i).getDeliveryMan().getName());
                                // dmListDistance.add(totalDistance);
                            } else {

//                            int verify1 = 0;
//
//                            for (int u = 0; u < dmReport.size(); ++u) {
//                                if (dmList1.get(j).getDeliveryMan().getName().equals(dmReport.get(u).getName())) {
//                                    totalDistance += dmList1.get(j).getDistance();
//                                    dmReport.get(u).setTotalDistance(totalDistance);
//
//                                    verify1++;
//                                }
//                            }
//
//                            if (verify1 == 0) {
//                                totalDistance += dmList1.get(j).getDistance();
//                                DeliveryReportDistance dm1 = new DeliveryReportDistance(j, dmList1.get(j).getDeliveryMan().getName(), dmList1.get(j).getDistance());
//                                dmReport.add(dm1);
//
//                                System.out.println("verify1 dmList1.get(j).getDeliveryMan().getName()" + dmList1.get(j).getDeliveryMan().getName());
//
//                            }
                            }
                        }

                    }

                }
                printDailyReportDistance(dateInput, dmReport);
            }

        }

    }

    public void printDailyReportDistance(String dateInput, List<DeliveryReportDistance> dmReport) {

        System.out.println("");
        for (int i = 0; i <= 89; i++) {
            System.out.print("-");
        }
        String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());

        String printingID = "";
        Double revisionNo = 0.0;
        for (int i = 0; i < dmReport.size(); ++i) {
            if (dateInput.equals(dmReport.get(i).getDate())) {
                printingID = "FDM-" + dmReport.get(i).getPrintId();
                revisionNo = dmReport.get(i).getRevisionNo();
                break;
            }
        }

        // String revisionNo = revNo;
        System.out.println(" ");
        System.out.println(String.format("| %-53s | %-15s : %-12s | ", "     Daily Deliveryman Distance Travelled Report     ", "Printing Date", timeStamp));
        System.out.println(String.format("| %-53s | %-15s : %-12s | ", "            Fastest Deliveryman Sdn. Bhd.            ", "Printing ID ", printingID));
        System.out.println(String.format("| %-53s | %-15s : %-12.1f | ", "                     " + dateInput + "                      ", "Revision No. ", revisionNo));
        dateList.add(dateInput);
        // printID++;

        // revNo = (revNo + 0.1);
        //System.out.println(" ");
        for (int i = 0; i <= 89; i++) {
            System.out.print("-");
        }

        System.out.println("");
        System.out.println(String.format("| %-10s | %-40s | %-30s |", "No.", "Deliveryman Name", "Total Distance(km)"));
        System.out.println(String.format("| %-10s | %-40s | %-30s |", "----------", "----------------------------------------", "------------------------------"));

        int maxTotalDistance = 0;
        //  maxTotalDistance = dmReport.get(0).getTotalDistance();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < dmReport.size(); ++i) {
            if (dateInput.equals(dmReport.get(i).getDate())) {
                arr.add(dmReport.get(i).getTotalDistance());
            }
            //System.out.println("arr " + arr);
        }
        Collections.sort(arr, Collections.reverseOrder());

//         for (int i = 0; i < dmReport.size(); ++i) {
//           
//            System.out.println("after arr " + arr);
//        }
        //retrive data from arraylist
        if (dmReport.isEmpty()) {
            System.out.println("No record inside.");
        } else {
            int no = 1;
            for (int j = 0; j < arr.size(); ++j) { //0
                for (int i = 0; i < dmReport.size(); ++i) { //0
                    if (arr.get(j) == dmReport.get(i).getTotalDistance() && dateInput.equals(dmReport.get(i).getDate())) {
                        System.out.print(String.format("| %-10d ", no));
                        System.out.println(dmReport.get(i));
                        no++;
                    }

//                    if (dmReport.get(i).getTotalDistance() > dmReport.get(j).getTotalDistance()) {
//                        // System.out.println(dmReport.get(i));
//                        int temp = arr[k];
//                        arr[k] = arr[i];
//                        arr[i] = temp;
//                        int totalDistanceJ = dmReport.get(j).getTotalDistance();
//                        int totalDistanceI = dmReport.get(i).getTotalDistance();
//                        maxTotalDistance = totalDistanceJ;
//                        totalDistanceJ = totalDistanceI;
//                        totalDistanceI = maxTotalDistance;
//
//                    } else {
//                        //  System.out.println(dmReport.get(i));
//                    }
                }

            }
        }
        for (int i = 0; i <= 89; i++) {
            System.out.print("-");
        }

        System.out.println(" ");
        System.out.println(" ");

        // String[] dmList = new String[count];
    }

    public void generateDailyReportDeliveries1() {
        //Tmrw do: verify date that is not available inside database, report format
        Scanner sc = new Scanner(System.in);
        String dateInput = "";
        int count = 0;
        Boolean verify = false, verifyEmpty = false, verifyDateExist = false, verifyDateList = false, verifyne1 = true;
        List<DeliveryDetail> dmList = new ArrayList<>();
        List<DeliveryDetail> dmList1 = new ArrayList<>();

        do {
            System.out.println(" ");
            System.out.println("--------------------------------");
            System.out.println("Total Deliveries Daily Report");
            System.out.println("--------------------------------");
            System.out.print("Please write the date that need to generate report(dd/mm/yyyy)[-1 back to Generate Daily Report Menu]: ");
            dateInput = sc.nextLine();

            verify = verifyDate(dateInput);
            verifyEmpty = verifyEmpty(dateInput);
            verifyDateExist = verifyDateExist(dateInput);
            verifyDateList = verifyDateList1(dateInput);

            if (dateInput.equals("-1")) {
                verify = true;
                verifyEmpty = true;
                verifyDateExist = true;
                verifyDateList = true;
                verifyne1 = true;
                //    System.out.println("abc");

            } else {
                if (verifyEmpty == false) {
                    System.out.println("Date cannot be empty, please try again.");
                    System.out.println(" ");
                } else if (verify == false) {
                    System.out.println("Date must in the format of dd/mm/yyyy, please try again.");
                    System.out.println(" ");
                } else if (verifyDateList == false) {
                    System.out.println("Report already generated, please try again.");
                    System.out.println(" ");
                    printDailyReportDeliveries(dateInput, dmReport1);
                } else if (verifyDateExist == false) {
                    System.out.println("Date does not exist, please try again.");
                    System.out.println(" ");
                }

                if (verifyEmpty == true && verify == true && verifyDateList == true && verifyDateExist == true) {
                    verifyne1 = true;
                }
            }

        } while (verify == false || verifyEmpty == false || verifyDateExist == false || verifyDateList == false || verifyne1 == false);

        if (dateInput.equals("-1")) {
            System.out.println(" ");
            System.out.print("Thank you. Back to Generate Daily Report Menu...");
            System.out.println(" ");
        } else {
            // System.out.println("abcss");
            if (deliveryDetailList.isEmpty()) {
                System.out.println("No record inside.");
            } else {
                for (int i = 0; i < deliveryDetailList.size(); ++i) {

                    //System.out.println("aa.");
                    if (deliveryDetailList.get(i).getStatus() == "Delivered" && dateInput.equals(deliveryDetailList.get(i).getDate())) {
                        //1, "Pending", "88 Jalan Halo", dm3, "7/12/2017", 10
                        // id,status, deliveryMan, custAddress, date, distance;        

                        //   System.out.println("bb.");
                        DeliveryDetail dm = new DeliveryDetail(deliveryDetailList.get(i).getId(), deliveryDetailList.get(i).getStatus(), deliveryDetailList.get(i).getCustAddress(), deliveryDetailList.get(i).getDeliveryMan(), deliveryDetailList.get(i).getDate(), deliveryDetailList.get(i).getDistance());
                        dmList.add(dm);

                        DeliveryDetail dm2 = new DeliveryDetail(deliveryDetailList.get(i).getId(), deliveryDetailList.get(i).getStatus(), deliveryDetailList.get(i).getCustAddress(), deliveryDetailList.get(i).getDeliveryMan(), deliveryDetailList.get(i).getDate(), deliveryDetailList.get(i).getDistance());
                        dmList1.add(dm2);
                    }
                }
            }

            String tmp = "";

//        List<DeliveryReportDistance> dmReport = new ArrayList<>();
            // List<String> dmList2Name = new ArrayList<>();
            //  List<Integer> dmListDistance = new ArrayList<>();
            //      tmp = dmList.get(0).getDeliveryMan().getIC();
            //0 = A, 1 = B, 2 = A  
            int consInt = 0;

            // printID++;
            // revNo = (revNo + 0.1);
            //String printingID = "";
            //  Double revisionNo = 0.0;
//        for (int i = 0; i < dmReport.size(); ++i) {
//            if (dateInput.equals(dmReport.get(i).getDate())) {
//               // printingID = "FDM-" + dmReport.get(i).getPrintId();
//               // revisionNo = dmReport.get(i).getRevisionNo();
//                break;
//            }
//        }
            //Collections.sort(arr, Collections.reverseOrder());
            int printNo = 0;
            printNo = dmReport1.get(dmReport1.size() - 1).getPrintId();
            printNo++;

            double reviNo = 0.0;
            reviNo = dmReport1.get(dmReport1.size() - 1).getRevisionNo();
            reviNo = (reviNo + 0.1);

            DeliveryReportDeliveries dm = new DeliveryReportDeliveries(consInt, dmList.get(consInt).getDeliveryMan().getName(), 1, dateInput, printNo, reviNo);
            dmReport1.add(dm);
            List<String> dmTmp = new ArrayList<>();
            //dmTmpName.add(dmList.get(consInt).getDeliveryMan().getName());

            String consName = dmList.get(consInt).getDeliveryMan().getName();
            dmTmp.add(consName);

            for (int b = 0; b < dmList.size(); ++b) {

                if (consName.equals(dmList.get(b).getDeliveryMan().getName())) {

                } else {
                    int test = 0;

                    if (dmTmp.isEmpty()) {

                    } else {
                        for (int h = 0; h < dmTmp.size(); ++h) {
                            if (dmList.get(b).getDeliveryMan().getName().equals(dmTmp.get(h))) {
                                test += 1;
                            }
                        }
                    }

                    if (test == 0) {

                        //   for (int c = 0; c < dmTmpName.size(); ++c) {
                        //   if (dmTmpName.get(c).equals(dmList.get(b).getDeliveryMan().getName())) {
                        //    } else {
                        consInt++;
                        DeliveryReportDeliveries dm5 = new DeliveryReportDeliveries(consInt, dmList.get(b).getDeliveryMan().getName(), 1, dateInput, printNo, reviNo);
                        dmReport1.add(dm5);

                        dmTmp.add(dmList.get(b).getDeliveryMan().getName());

                        //System.out.println("tmpName " + dmTmpName.get(c));
                    }
                }
            }

//System.out.println("cc.");
            List<Integer> dmReportTest = new ArrayList<>();

            if (dmList.isEmpty()) {
                System.out.println("No record inside.");
                //    System.out.println("dd.");
            } else {
                for (int i = 0; i < dmList.size(); ++i) {//0 //2

                    tmp = dmList.get(i).getDeliveryMan().getIC(); //0 //2

                    // System.out.println("dmReport.get(i).getId() " + dmReport.get(i).getId());
//                System.out.println("i" + i);
//                System.out.println("dmList1.size()" + dmList1.size());
//                System.out.println("i tmp" + tmp);
                    for (int j = 0; j < dmList1.size(); ++j) { //2 //0
//                    System.out.println("j" + j);
//                    System.out.println("start dmList1.get(j).getDeliveryMan().getName() " + dmList1.get(j).getDeliveryMan().getName());
                        if (i == j) {
                        } else {
                            // 
                            //  System.out.println("hh." + j);
                            if (tmp.equals(dmList1.get(j).getDeliveryMan().getIC())) { //true
//                            System.out.println("dmList1.get(j).getDeliveryMan().getName() " + dmList1.get(j).getDeliveryMan().getName());

                                for (int k = 0; k < dmReport1.size(); ++k) {
//                                System.out.println("k" + k);
//                                System.out.println("dmReport.get(k).getId() " + dmReport.get(k).getId());

                                    if (j == dmReport1.get(k).getId() && dmList1.get(j).getDeliveryMan().getName().equals(dmReport1.get(k).getName())) {
//                                    System.out.println("same" + k);
                                    } else if (dmList1.get(j).getDeliveryMan().getName().equals(dmReport1.get(k).getName())) {
                                        if (dateInput.equals(dmReport1.get(k).getDate())) {
                                            int test = 0;

                                            if (dmReportTest.isEmpty()) {

                                            } else {
                                                for (int h = 0; h < dmReportTest.size(); ++h) {
                                                    if (j == dmReportTest.get(h)) {
                                                        test += 1;
                                                    }
                                                }
                                            }
                                            if (test == 0) {
//                                        System.out.println("after dmReport.get(k).getId() " + dmReport.get(k).getId());

                                                int countDelivery = (1 + dmReport1.get(k).getTotalDeliveries());

                                                dmReport1.get(k).setTotalDeliveries(countDelivery);
//                                        System.out.println("k dmReport.get(k).getName()" + dmReport.get(k).getName());
//                                        System.out.println("k totalDistance " + totalDistance);

                                                dmReportTest.add(j);
                                            }
                                        }

                                    } else {

//                                    System.out.println("dsa dmReport.get(k).getName()" + dmReport.get(k).getName());
                                        // DeliveryReportDistance dm1 = new DeliveryReportDistance(i, dmList.get(i).getDeliveryMan().getName(), dmList.get(i).getDistance());
                                        //  dmReport.add(dm1);
                                    }

                                }

                                // dmList2Name.add(dmList1.get(i).getDeliveryMan().getName());
                                // dmListDistance.add(totalDistance);
                            } else {

//                            int verify1 = 0;
//
//                            for (int u = 0; u < dmReport.size(); ++u) {
//                                if (dmList1.get(j).getDeliveryMan().getName().equals(dmReport.get(u).getName())) {
//                                    totalDistance += dmList1.get(j).getDistance();
//                                    dmReport.get(u).setTotalDistance(totalDistance);
//
//                                    verify1++;
//                                }
//                            }
//
//                            if (verify1 == 0) {
//                                totalDistance += dmList1.get(j).getDistance();
//                                DeliveryReportDistance dm1 = new DeliveryReportDistance(j, dmList1.get(j).getDeliveryMan().getName(), dmList1.get(j).getDistance());
//                                dmReport.add(dm1);
//
//                                System.out.println("verify1 dmList1.get(j).getDeliveryMan().getName()" + dmList1.get(j).getDeliveryMan().getName());
//
//                            }
                            }
                        }

                    }

                }
//                for (int hh = 0; hh < dmReport1.size(); hh++) {
//                    System.out.println(dmReport1.get(hh));
//                }
                printDailyReportDeliveries(dateInput, dmReport1);
            }

        }
    }

    public void generateDailyReportDeliveries() { //broken
        Scanner sc = new Scanner(System.in);
        String dateInput = "";
        int count = 0;
        Boolean verify = false, verifyEmpty = false, verifyDateExist = false, verifyDateList = false;
        List<DeliveryDetail> dmList = new ArrayList<>();
        List<DeliveryDetail> dmList1 = new ArrayList<>();

        do {
            System.out.println(" ");
            System.out.println("--------------------------------");
            System.out.println("Total Deliveries Daily Report");
            System.out.println("--------------------------------");
            System.out.print("Please write the date that need to generate report(dd/mm/yyyy): ");
            dateInput = sc.nextLine();

            verify = verifyDate(dateInput);
            verifyEmpty = verifyEmpty(dateInput);
            verifyDateExist = verifyDateExist(dateInput);
            verifyDateList = verifyDateList(dateInput);

            if (verifyEmpty == false) {
                System.out.println("Date cannot be empty, please try again.");
                System.out.println(" ");
            } else if (verify == false) {
                System.out.println("Date must in the format of dd/mm/yyyy, please try again.");
                System.out.println(" ");
            } else if (verifyDateList == false) {
                System.out.println("Report already generated, please try again.");
                System.out.println(" ");
                printDailyReportDeliveries(dateInput, dmReport1);
            } else if (verifyDateExist == false) {
                System.out.println("Date does not exist, please try again.");
                System.out.println(" ");
            }

        } while (verify == false || verifyEmpty == false || verifyDateExist == false || verifyDateList == false);

        if (deliveryDetailList.isEmpty()) {
            System.out.println("No record inside.");
        } else {
            for (int i = 0; i < deliveryDetailList.size(); ++i) {
                if (deliveryDetailList.get(i).getStatus() == "Delivered" && dateInput.equals(deliveryDetailList.get(i).getDate())) {
                    DeliveryDetail dm = new DeliveryDetail(deliveryDetailList.get(i).getId(), deliveryDetailList.get(i).getStatus(), deliveryDetailList.get(i).getCustAddress(), deliveryDetailList.get(i).getDeliveryMan(), deliveryDetailList.get(i).getDate(), deliveryDetailList.get(i).getDistance());
                    dmList.add(dm);

                    DeliveryDetail dm2 = new DeliveryDetail(deliveryDetailList.get(i).getId(), deliveryDetailList.get(i).getStatus(), deliveryDetailList.get(i).getCustAddress(), deliveryDetailList.get(i).getDeliveryMan(), deliveryDetailList.get(i).getDate(), deliveryDetailList.get(i).getDistance());
                    dmList1.add(dm2);
                }
            }
        }

        String tmp = "";
        int consInt = 0;
        int printNo = 0;
        printNo = dmReport1.get(dmReport1.size() - 1).getPrintId();
        printNo++;

        double reviNo = 0.0;
        reviNo = dmReport1.get(dmReport1.size() - 1).getRevisionNo();
        reviNo = (reviNo + 0.1);

        List<String> dmTmp = new ArrayList<>();
        List<String> dmTmpName = new ArrayList<>();

        String consName = dmList.get(consInt).getDeliveryMan().getName();
        dmTmp.add(consName);

        for (int f = 0; f < dmList.size(); f++) {
            consName = dmList.get(f).getDeliveryMan().getName();
        }

        for (int i = 0; i < dmList.size(); ++i) {
            if (consName.equals(dmList.get(i).getDeliveryMan().getName()) && dateInput.equals(dmList.get(i).getDate())) {
                dmTmpName.add(consName);
                consName = dmList.get(i + 1).getDeliveryMan().getName();
            }
        }

        int occurrences = Collections.frequency(dmTmpName, consName);
        System.out.println("consName " + consName);
        System.out.println("occurrences " + occurrences);

        DeliveryReportDeliveries dm = new DeliveryReportDeliveries(consInt, dmList.get(consInt).getDeliveryMan().getName(), occurrences, dateInput, printNo, reviNo);
        dmReport1.add(dm);

        //    List<Integer> dmTmp1 = new ArrayList<>();
        //  dmTmp1.add(1);
        //   int occurrences = Collections.frequency(dmList, consName);
        for (int b = 0; b < dmList.size(); ++b) {
            if (consName.equals(dmList.get(b).getDeliveryMan().getName())) {

            } else {
                int test = 0;

                if (dmTmp.isEmpty()) {

                } else {
                    for (int h = 0; h < dmTmp.size(); ++h) {
                        if (dmList.get(b).getDeliveryMan().getName().equals(dmTmp.get(h))) {
                            test += 1;
                        }
                    }
                }

                if (test == 0) {
                    consInt++;

                    for (int i = 0; i < dmList.size(); ++i) {
                        if (dmList.get(b).getDeliveryMan().getName().equals(dmList.get(i).getDeliveryMan().getName()) && dateInput.equals(dmList.get(i).getDate())) {
                            dmTmpName.add(dmList.get(b).getDeliveryMan().getName());
                        }
                    }

                    int occurrences1 = Collections.frequency(dmTmpName, dmList.get(b).getDeliveryMan().getName());
                    DeliveryReportDeliveries dm5 = new DeliveryReportDeliveries(consInt, dmList.get(b).getDeliveryMan().getName(), occurrences1, dateInput, printNo, reviNo);
                    dmReport1.add(dm5);

                    dmTmp.add(dmList.get(b).getDeliveryMan().getName());
                }
            }
        }
        
         System.out.println("abc ");

        printDailyReportDeliveries(dateInput, dmReport1);

//        List<Integer> dmReportTest = new ArrayList<>();
//
//        if (dmList.isEmpty()) {
//            System.out.println("No record inside.");
//        } else {
//            for (int i = 0; i < dmList.size(); ++i) {
//
//                tmp = dmList.get(i).getDeliveryMan().getIC();
//
//                for (int j = 0; j < dmList1.size(); ++j) {
//                    if (i == j) {
//                    } else {
//
//                        if (tmp.equals(dmList1.get(j).getDeliveryMan().getIC())) {
//                            for (int k = 0; k < dmReport1.size(); ++k) {
//                                if (j == dmReport1.get(k).getId() && dmList1.get(j).getDeliveryMan().getName().equals(dmReport1.get(k).getName())) {
//                                } else if (dmList1.get(j).getDeliveryMan().getName().equals(dmReport1.get(k).getName())) {
//                                    int test = 0;
//
//                                    if (dmReportTest.isEmpty()) {
//
//                                    } else {
//                                        for (int h = 0; h < dmReportTest.size(); ++h) {
//                                            if (j == dmReportTest.get(h)) {
//                                                test += 1;
//                                            }
//                                        }
//                                    }
//                                    if (test == 0) {
//                                        totalDistance = dmList1.get(j).getDistance() + dmReport.get(k).getTotalDistance();
//
//                                        dmReport1.get(k).setTotalDistance(totalDistance);
//                                        dmReportTest.add(j);
//                                    }
//
//                                } else {
//                                }
//
//                            }
//                        } else {
//                        }
//                    }
//
//                }
//
//            }
    }

    public void printDailyReportDeliveries(String dateInput, List<DeliveryReportDeliveries> dmReport1) {

        System.out.println("");
        for (int i = 0; i <= 89; i++) {
            System.out.print("-");
        }
        String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());

        String printingID = "";
        Double revisionNo = 0.0;
        for (int i = 0; i < dmReport1.size(); ++i) {
            if (dateInput.equals(dmReport1.get(i).getDate())) {
                printingID = "FDM-" + dmReport1.get(i).getPrintId();
                revisionNo = dmReport1.get(i).getRevisionNo();
                break;
            }
        }

        System.out.println(" ");
        System.out.println(String.format("| %-53s | %-15s : %-12s | ", "         Daily Deliveryman Delivered Report         ", "Printing Date", timeStamp));
        System.out.println(String.format("| %-53s | %-15s : %-12s | ", "            Fastest Deliveryman Sdn. Bhd.            ", "Printing ID ", printingID));
        System.out.println(String.format("| %-53s | %-15s : %-12.1f | ", "                     " + dateInput + "                      ", "Revision No. ", revisionNo));
        dateList.add(dateInput);

        for (int i = 0; i <= 89; i++) {
            System.out.print("-");
        }

        System.out.println("");
        System.out.println(String.format("| %-10s | %-40s | %-30s |", "No.", "Deliveryman Name", "Total Delivery"));
        System.out.println(String.format("| %-10s | %-40s | %-30s |", "----------", "----------------------------------------", "------------------------------"));

        int maxTotalDistance = 0;
        List<Integer> arr = new ArrayList<>();
        List<String> arr1 = new ArrayList<>();
        List<String> arr2 = new ArrayList<>();
        List<Integer> arr3 = new ArrayList<>();
        for (int i = 0; i < dmReport1.size(); ++i) {
            if (dateInput.equals(dmReport1.get(i).getDate())) {
                arr.add(dmReport1.get(i).getTotalDeliveries());
                arr1.add(dmReport1.get(i).getName());
                arr3.add(dmReport1.get(i).getTotalDeliveries());
            }
        }

        int tmpInt = 0;
        tmpInt = arr.get(0);

//        for (int jk = 0; jk < arr.size(); jk++) {
//            System.out.println("arr.get(jk) " + arr.get(jk)); //do until here
//            System.out.println("arr1.get(jk) " + arr1.get(jk));
//            System.out.println("arr3.get(jk) " + arr3.get(jk));
//            
//        }
        Collections.sort(arr, Collections.reverseOrder());

        int sizeArr = 0;

        for (int try1 = 0; try1 < arr.size(); try1++) {
            //    System.out.println("try1 " + try1);
            for (int try2 = 0; try2 < arr3.size(); try2++) {
                //      System.out.println("try2 " + try2);
                //      System.out.println("arr.get(try1) " + arr.get(try1) + "arr3.get(try2) " + arr3.get(try2) + "arr1.get(try2) " + arr1.get(try2));

                if (arr.get(try1) == arr3.get(try2)) {
                    arr2.add(arr1.get(try2));

                    //     System.out.println("arr2.get(try2) " + arr2.get(sizeArr));
                    sizeArr++;
                }
            }
        }

//        for (int jk1 = 0; jk1 < arr1.size(); jk1++) {
//            System.out.println("jk1 " + jk1);
//            if (tmpInt == arr.get(jk1)) {
//
//                arr2.add(arr1.get(jk1));
//                System.out.println("arr1.get(jk1) " + arr1.get(jk1));
//                int tmpsize = 0;
//
//                tmpsize = jk1 + 1;
//
//                if (tmpsize < arr.size()) {
//                    tmpInt = arr.get(tmpsize);
//                     System.out.println("arr2.get(jk1) " + arr2.get(jk1)); //do until here
//                }
//               
//            }
//
//        }
        if (dmReport.isEmpty()) {
            System.out.println("No record inside.");
        } else {
            int no = 1;
            for (int j = 0; j < arr.size(); ++j) { //0
                for (int i = 0; i < dmReport1.size(); ++i) { //0
                    //   System.out.println("arr1.get(j) " + arr1.get(j));
                    //   System.out.println("dmReport1.get(i).getName() " + dmReport1.get(i).getName());
                    if (arr.get(j) == dmReport1.get(i).getTotalDeliveries() && dateInput.equals(dmReport1.get(i).getDate())) {
                        //      System.out.println("i " + i + " j " + j);
                        //     System.out.println("dmReport1.get(i).getTotalDeliveries() " + dmReport1.get(i).getTotalDeliveries() + "arr.get(j) " + arr.get(j));
                        //      System.out.println("i " + i + " j " + j);
                        //      System.out.println("arr1.get(j) " + arr1.get(j) + " dmReport1.get(i).getName() " + dmReport1.get(i).getName());
                        if (arr2.get(j).equals(dmReport1.get(i).getName())) {
                            System.out.print(String.format("| %-10d ", no));
                            System.out.println(dmReport1.get(i));
                            no++;
                        }
                    }
                }

            }
        }
        for (int i = 0; i <= 89; i++) {
            System.out.print("-");
        }

        System.out.println(" ");
        System.out.println(" ");
    }

    public Boolean verifyDate(String input) {
        Boolean verify;

        regexPattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
        regMatcher = regexPattern.matcher(input);
        if (regMatcher.matches()) {
            verify = true;
        } else {
            verify = false;
        }
        return verify;
    }

    public Boolean verifyDateExist(String input) {

        Boolean verify = false;

        String dateConstant;

        if (deliveryDetailList.isEmpty()) {

        } else {
            for (int i = 0; i < deliveryDetailList.size(); ++i) {

                dateConstant = deliveryDetailList.get(i).getDate();

                if (input.equals(dateConstant)) {
                    verify = true;
                    break;
                } else {
                    verify = false;
                }
            }
        }
        return verify;
    }

    public Boolean verifyDateList(String input) {

        Boolean verify = true;

        String dateConstant;

        if (dmReport.isEmpty()) {

        } else {
            for (int i = 0; i < dmReport.size(); ++i) {

                dateConstant = dmReport.get(i).getDate();

                if (input.equals(dateConstant)) {
                    verify = false;
                    break;
                } else {
                    verify = true;
                }
            }
        }
        return verify;
    }

    public Boolean verifyDateList1(String input) {

        Boolean verify = true;

        String dateConstant;

        if (dmReport1.isEmpty()) {

        } else {
            for (int i = 0; i < dmReport1.size(); ++i) {

                dateConstant = dmReport1.get(i).getDate();

                if (input.equals(dateConstant)) {
                    verify = false;
                    break;
                } else {
                    verify = true;
                }
            }
        }
        return verify;
    }
}
