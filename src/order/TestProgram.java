/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import java.util.*;

/**
 *
 * @author MacBook
 */
public class TestProgram {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        User user1 = new User("Fiffy", "cute88", "Jalan Cutie", "011111111");
        User user2 = new User("Bingbing", "bingcute", "Jalan Cutie", "0124433335");

        Item item1 = new Item("Chicken Chop", 12.90, "Golden chicken coated with ABC gravy");
        Item item2 = new Item("Spaghetti Bolognese", 10.90, "Tomato sauce spaghetti with meatballs");
        Item item3 = new Item("Mushroom Soup", 6.90, "Forest Mushroom");
        Item item4 = new Item("Pumpkin Soup", 6.90, "Cinderella Pumpkin");
        Item item5 = new Item("Chowder Soup", 6.90, "Vegetable Based Soup");
        Item item6 = new Item("Hokkien Mee", 7.90, "Fresh Prawn Noodle");
        Item item7 = new Item("Laksa", 7.90, "Famous Penang Laksa");

        List<Item> restABCMenu = new ArrayList<>();
        List<Item> restHappyMenu = new ArrayList<>();
        List<Item> restPenangMenu = new ArrayList<>();
        List<User> userList = new ArrayList<>();

        restABCMenu.add(item1);
        restABCMenu.add(item2);
        restHappyMenu.add(item3);
        restHappyMenu.add(item4);
        restHappyMenu.add(item5);
        restPenangMenu.add(item6);
        restPenangMenu.add(item7);
        userList.add(user1);
        userList.add(user2);

        //Restaurant List
        Restaurant restABC = new Restaurant("Restaurant ABC", "Jalan Happy", "0121111111", restABCMenu);
        Restaurant restHappy = new Restaurant("Restaurant Happy", "Jalan Very Happy", "0175565557", restHappyMenu);
        Restaurant restPenang = new Restaurant("Restaurant Penang", "Jalan Penang", "0185554444", restPenangMenu);
        List<Restaurant> restaurantList = new ArrayList<>();
        restaurantList.add(restABC);
        restaurantList.add(restHappy);
        restaurantList.add(restPenang);

        //Order
        List<Order> order = new ArrayList<>();

        System.out.println("HI, " + user1.getUsername());

        int choiceHome = 0;
        char cont = 'n';

        do {
            choiceHome = showHome();
            switch (choiceHome) {
                case 1:
                    orderFood(restaurantList, user1, order);
                    break;
                case 2:
                    checkContact(userList);
                    break;
                default:
                    System.exit(0);
            }
            
            System.out.println("\nDo you want to continue use this system ?  <Y/N>");
            cont = scanner.next().charAt(0);
        } while (cont == 'y' || cont == 'Y');

    }

    public static void checkContact(List<User> userList) {
        Scanner scanner = new Scanner(System.in);
        String contact;
        char check;
        boolean valid;
        char cont;
        int found;
        boolean proceed;

        do {
            valid = true;
            cont = 'n';
            found = 0;
            contact = "";
            proceed = true;

            System.out.println("\nPlease enter customer contact number : *press 9 to back*");
            contact = scanner.next();
            if (contact.charAt(0) == '9' && contact.length() ==1)
            {
                cont = 'n';
                proceed = false;
            }
                

            if( proceed == true) {
                for (int i = 0; i < contact.length(); i++) {
                    check = contact.charAt(i);
                    if (!Character.isDigit(check)) {
                        System.out.println("\nPlease enter digit only ! ");
                        valid = false;
                        break;

                    }

                }

                if (valid == true) {
                    for (int i = 0; i < userList.size(); i++) {

                        if (contact.equals(userList.get(i).getContactNum())) {
                            System.out.println(userList.get(i).getUserDetail());
                            found = 1;
                            break;
                        }
                    }

                    if (found == 0) {
                        System.out.println("No user found ! Please ensure you have entered correct contact number.");
                    }

                }

                System.out.println("\nDo you want to continue check user's contact number?  <Y/N>");
                cont = scanner.next().charAt(0);
            }

        } while (cont == 'Y' || cont == 'y');

    }

    public static int showHome() {
        System.out.println("\nHome Page");
        System.out.println("Please select");
        System.out.println("1. Order Food");
        System.out.println("2. Get customer detail");
        System.out.println("3. Exit");
        return choice(1, 3);
    }

    public static void showRestaurantList(List<Restaurant> restaurantList) {
        Scanner scanner = new Scanner(System.in);
        Integer selection;
        System.out.println();
        System.out.print("Please select a restaurant : *press 0 to exit* ");
        System.out.println();
        for (int i = 0; i < restaurantList.size(); i++) {
            System.out.println(i + 1 + " . " + restaurantList.get(i).getRestaurantName());

        }

    }

    public static void orderFood(List<Restaurant> restaurantList, User user, List<Order> order) {
        Scanner scanner = new Scanner(System.in);
        Integer menuChoice;
        char newOrder = 'n';
        Integer qty = 0;
        char confirm, payment;
        char contOrder = 'n';
        char proceedToConfirm = 'n';

        //boolean home = true;
        
        int valid;
        Integer selection;
        int back = 0;

        List<Item> itemOrder = new ArrayList<>();
        List<Integer> qtyOrder = new ArrayList<>();
        List<Double> subtotal = new ArrayList<>();
        List<Item> temp = new ArrayList<>();

        do {

            itemOrder.clear();
            qtyOrder.clear();
            subtotal.clear();
            showRestaurantList(restaurantList);
            selection = choice(0, restaurantList.size());

            switch (selection) {

                case 0:{
                    //System.out.println();
                    //System.out.println("Thanks for using :)");
                   // System.exit(0);
                    back = 1;
                    newOrder = 'n';
                    break;
                }
                default: {

                    selection = selection - 1;
                    System.out.println();
                    System.out.println(restaurantList.get(selection).getRestaurantName());
                    System.out.println("================");
                    System.out.println();
                    System.out.println("Please select menu : *press 0 to back*");
                    //System.out.println();

                    temp = restaurantList.get(selection).getMenu();

                    order:
                    do {
                        do {
                            System.out.println();
                            System.out.printf("Num Food Name\t\t\t\t\tPrice(RM)\t\tDescription");
                            System.out.println();
                            for (int i = 0; i < restaurantList.get(selection).getMenu().size(); i++) {
                                System.out.printf("%d . %-30s\t\tRM%6.2f\t\t%s", i + 1, temp.get(i).getFoodName(), temp.get(i).getFoodPrice(), temp.get(i).getDesc());
                                System.out.println();
                            }
                            menuChoice = choice(0, restaurantList.get(selection).getMenu().size());

                            switch (menuChoice) {
                                case 0:
                                    valid = 0;
                                    proceedToConfirm = 'n';
                                    back = 1;
                                    newOrder = 'y';
                                    break order;

                                default:
                                    back = 0;
                                    valid = 1;
                                    menuChoice -= 1;
                                    System.out.println();
                                    System.out.printf("%s\t\t%.2f\n", temp.get(menuChoice).getFoodName(), temp.get(menuChoice).getFoodPrice());
                                    System.out.println("Please select quantity \nMaximum 100 quantity per item per order\n");
                                    qty = choice(0, 100);
                                    switch (qty) {
                                        case 0:
                                            break;
                                        default:
                                            System.out.println();
                                            System.out.printf("%s\t\tRM%.2f\n", temp.get(menuChoice).getFoodName(), temp.get(menuChoice).getFoodPrice());

                                            System.out.println("Quantity = " + qty);
                                            System.out.printf("Subtotal = RM%.2f", qty * temp.get(menuChoice).getPrice());
                                            System.out.println();
                                            System.out.println("Confirm Order ? <Y/N>");
                                            confirm = scanner.next().charAt(0);

                                            int tempQty,
                                             tempIndex = 0,
                                             contain;

                                            if (confirm == 'Y' || confirm == 'y') {
                                                tempQty = qty;
                                                contain = 0;

                                                for (int i = 0; i < itemOrder.size(); i++) {
                                                    if (itemOrder.contains(temp.get(menuChoice))) {
                                                        contain = 1;
                                                        tempIndex = itemOrder.indexOf(temp.get(menuChoice));
                                                        tempQty += qtyOrder.get(tempIndex);
                                                    }
                                                }

                                                if (contain == 0) {
                                                    System.out.println();
                                                    System.out.println("Order added!");
                                                    itemOrder.add((temp.get(menuChoice)));
                                                    qtyOrder.add(qty);
                                                    subtotal.add(qty * temp.get(menuChoice).getPrice());
                                                } else {
                                                    if (tempQty <= 100) {
                                                        System.out.println();
                                                        System.out.println("Order added!");
                                                        qtyOrder.set(tempIndex, tempQty);
                                                        subtotal.set(tempIndex, tempQty * temp.get(menuChoice).getPrice());

                                                    } else {
                                                        System.out.println();
                                                        System.out.println("Order for this item have exceeded 100 quantity.");
                                                        System.out.println("Order unsuccessful!");
                                                    }
                                                }

                                            } else {
                                                System.out.println("Order Cancelled.");
                                            }

                                            System.out.println();
                                            System.out.println("More Order from this restaurant ? <Y/N>");
                                            contOrder = scanner.next().charAt(0);
                                            break;
                                    }

                            }

                        } while (contOrder == 'Y' || contOrder == 'y');

                        if (valid != 0) {
                            System.out.println();
                            System.out.println("Proceed to Order Confirmation? <Y/N>");
                            proceedToConfirm = scanner.next().charAt(0);
                        }

                    } while (proceedToConfirm != 'Y' && proceedToConfirm != 'y');

                    Double total = 0.0;
                    if (itemOrder.isEmpty()) {
                        valid = 0;
                    }

                    if (valid != 0) {
                        System.out.println();
                        System.out.println("Num Food Name\t\t\t\t\tPrice(RM)\tQty\tSubtotal(RM)");
                        for (int i = 0; i < itemOrder.size(); i++) {

                            System.out.printf("%d . %-30s\t\t%6.2f\t\t%3d\t%8.2f", i + 1, itemOrder.get(i).getFoodName(), itemOrder.get(i).getFoodPrice(), qtyOrder.get(i), subtotal.get(i));
                            System.out.println();
                            total += subtotal.get(i);
                        }
                        //System.out.println();

                        System.out.println("----------------------------------------------------------------------------------");
                        System.out.printf("Total = RM %.2f", total);
                        System.out.println();
                        System.out.println();
                        System.out.println("Confirm Order? <Y/N>");
                        payment = scanner.next().charAt(0);
                        if (payment == 'Y' || payment == 'y') {
                            // for (int i = 0; i<itemOrder.size();i++)                
                            Order orderNew = new Order(user, restaurantList.get(selection), itemOrder, qtyOrder, total);
                            order.add(orderNew);
                            System.out.println();
                            System.out.println("Order Successful !");
                            System.out.printf("Your total payment is : RM %.2f \n", total);
                            System.out.println("Please prepare enough amount when your delivery man arrive ! :) ");
                            System.out.println();
                            //System.out.println(order.get(order.size()-1).toString());

                        } else {
                            System.out.println();
                            System.out.println("Order Cancelled.");
                        }
                    }
                    break;
                }

            }
            if (back == 0) {
                System.out.println();
                System.out.println("Do you want to make new order? <Y/N>");
                newOrder = scanner.next().charAt(0);
            }

        } while (newOrder == 'Y' || newOrder == 'y');

        System.out.println();
        System.out.println("Thanks for using :)");

    }

    public static int choice(int min, int max) {
        int choice = 0;
        boolean valid;

        do {
            valid = false;
            choice = checkDigit();

            if (choice < min || choice > max) {
                System.out.println("Wrong Input!! Please Try Again... ");
                valid = true;
            }

        } while (valid);

        return choice;
    }

    public static int checkDigit() { //Check is integer or not 

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean valid = true;

        do {
            try {
                System.out.print("Please Enter your Choice: ");
                choice = scanner.nextInt();

                valid = false;
            } catch (Exception error) {
                System.out.println("Wrong Input!! Please Try Again... ");
                valid = true;
                scanner.nextLine();
            }
        } while (valid);

        return choice;
    }
}
