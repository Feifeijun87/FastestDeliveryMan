/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import java.util.*;

/**
 *
 * @author ruenyenchin
 */
public class RestaurantOwner {

    private List<AffiliateDetails> affiliateDetailsList = new ArrayList<>();
    private List<Item> menuItemsList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer input;

        RestaurantOwner ro = new RestaurantOwner();

        System.out.println("----------------------------------------");
        System.out.println("Welcome to Fastest Deliveryman Sdn. Bhd.");
        System.out.println("----------------------------------------");
        System.out.println("");

        System.out.println("Please choose an option: ");
        System.out.println("1 - Register");
        System.out.println("2 - Login");
        System.out.println("3 - Exit");
        System.out.println("");

        input = choice(1, 3);

        switch (input) {
            case 1:
                ro.register();
                break;
            case 2:
                ro.login();
                break;
            case 3:
                System.out.println("Thank you.");
                break;
            default:
                break;
        }
    }

    public void addItems() {
        Scanner scanner = new Scanner(System.in);

        Item item1 = new Item("Kimchi Jiggae", 12.90, "Kimchi soup with meat");
        Item item2 = new Item("Haemul Jiggae", 10.90, "Kimchi soup with tofu");

        menuItemsList.add(item1);
        menuItemsList.add(item2);

        System.out.println("---------");
        System.out.println("Menu List");
        System.out.println("---------");

        if (menuItemsList.isEmpty()) {
            System.out.println("No record inside.");
        } else {
            for (int i = 0; i < menuItemsList.size(); ++i) {
                System.out.println(menuItemsList.get(i));
            }
        }

        //Add items
        String foodID, foodName, desc;
        Double foodPrice;

        System.out.print("\n");
        System.out.println("--------------");
        System.out.println("Add Menu Items");
        System.out.println("--------------");
        System.out.println("Please enter menu items details: ");

        System.out.print("Food Name > ");
        foodName = scanner.nextLine();

        System.out.print("Food Description > ");
        desc = scanner.nextLine();

        System.out.print("Food Price > ");
        foodPrice = scanner.nextDouble();

        Item item = new Item(foodName, foodPrice, desc);
        menuItemsList.add(item);

        System.out.print("\n");
        System.out.println("--------------");
        System.out.println("Updated Menu Items");
        System.out.println("--------------");

        if (menuItemsList.isEmpty()) {
            System.out.println("No record inside.");
        } else {
            for (int i = 0; i < menuItemsList.size(); ++i) {
                System.out.println(menuItemsList.get(i));
            }

        }

        System.out.print("\n");
        System.out.println("Item(s) added successfully!");
    }

    public void register() {
        AffiliateDetails exist = new AffiliateDetails("Restaurant BTS", "Hitman", "Bang", "Bighit", "bts@gmail.com", "www.bts.com", "Korea", "19970507", "kimseokjin", "lovebts");
        affiliateDetailsList.add(exist);

        Scanner scanner = new Scanner(System.in);

        String affiliateName, firstName, lastName, company, email, websiteURL, address, phone, username, password;
        String existAffiliate;
        Boolean valid = false;

        System.out.println("---------------------");
        System.out.println("Register as affiliate");
        System.out.println("---------------------");
        System.out.println("");

        System.out.print("Affiliate Name > ");
        affiliateName = scanner.nextLine();

        if (!affiliateDetailsList.isEmpty()) {
            for (int i = 0; i < affiliateDetailsList.size(); ++i) {
                existAffiliate = affiliateDetailsList.get(i).getAffiliateName();

                if (affiliateName.equals(existAffiliate)) {
                    System.out.println("Affiliate name exist! Please enter again.");
                    valid = true;
                    System.out.print("Affiliate Name > ");
                    affiliateName = scanner.nextLine();
                } else if (!affiliateName.equals(existAffiliate)) {
                    valid = false;
                    break;
                }
            }
        }

        System.out.print("First Name > ");
        firstName = scanner.nextLine();

        System.out.print("Last Name > ");
        lastName = scanner.nextLine();

        System.out.print("Company Name > ");
        company = scanner.nextLine();

        System.out.print("Email > ");
        email = scanner.nextLine();

        System.out.print("Website URL > ");
        websiteURL = scanner.nextLine();

        System.out.print("Street Address > ");
        address = scanner.nextLine();

        System.out.print("Phone > ");
        phone = scanner.nextLine();

        System.out.print("Username > ");
        username = scanner.nextLine();

        System.out.print("Password > ");
        password = scanner.nextLine();

        AffiliateDetails ad = new AffiliateDetails(affiliateName, firstName, lastName, company, email, websiteURL, address, phone, username, password);
        affiliateDetailsList.add(ad);

        System.out.println("");
        System.out.println("Affiliate " + affiliateName + " has been registered successfully.");

        mainMenu();
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);

        AffiliateDetails ad = new AffiliateDetails("Restaurant BTS", "Hitman", "Bang", "Bighit", "bts@gmail.com", "www.bts.com", "Korea", "19970507", "kimseokjin", "lovebts");
        affiliateDetailsList.add(ad);

        String username, password;
        String existUsername, existPassword;

        System.out.println("");
        System.out.println("-----");
        System.out.println("Login");
        System.out.println("-----");

        System.out.print("Username > ");
        username = scanner.nextLine();

        System.out.print("Password > ");
        password = scanner.nextLine();

        if (!affiliateDetailsList.isEmpty()) {
            for (int i = 0; i < affiliateDetailsList.size(); ++i) {
                existUsername = affiliateDetailsList.get(i).getUsername();
                existPassword = affiliateDetailsList.get(i).getPassword();

                if (username.equals(existUsername) && password.equals(existPassword)) {
                    System.out.println("Login successfully!\n");
                    mainMenu();
                } else if (!username.equals(existUsername) || !password.equals(existPassword)) {
                    System.out.println("Wrong username or password!\n");
                }
            }
        } else {
            System.out.println("There is no relevant account. Please register.");
        }
    }

    public static int choice(int min, int max) {
        int choice = 0;
        boolean valid;

        do {
            valid = false;
            choice = checkDigit();

            if (choice < min || choice > max) {
                System.out.println("Wrong Input! Please enter again.\n");
            }
        } while (valid);

        return choice;
    }

    public static int checkDigit() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean valid = true;

        do {
            try {
                System.out.print("Enter your option > ");
                choice = scanner.nextInt();

                valid = false;
            } catch (Exception error) {
                System.out.println("Wrong Input! Please enter again.\n");
                valid = true;
                scanner.nextLine();
            }
        } while (valid);

        return choice;
    }

    public void mainMenu() {
        Scanner scanner = new Scanner(System.in);

        RestaurantOwner ro = new RestaurantOwner();
        Integer input;

        System.out.println("---------");
        System.out.println("Main Menu");
        System.out.println("---------");

        System.out.println("Please choose an option: ");
        System.out.println("1 - Add item(s)");
        System.out.println("2 - Update item(s)");
        System.out.println("3 - Remove item(s)");
        System.out.println("4 - Exit");
        System.out.println("");

        input = choice(1, 3);

        switch (input) {
            case 1:
                ro.addItems();
                break;
            case 2:
                ro.updateItems();
                break;
            case 3:
                ro.removeItems();
                break;
            case 4:
                System.out.println("Thank you!");
                break;
            default:
                break;
        }
    }

    public void updateItems() {

    }

    public void removeItems() {

    }
}
