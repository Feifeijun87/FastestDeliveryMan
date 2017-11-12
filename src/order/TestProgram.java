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
        

        User user1 = new User("Fiffy","cute88","Jalan Cutie","011-111111");
        
        Item item1 = new Item("Chicken Chop", 12.90, "Golden chicken coated with ABC gravy");
        Item item2 = new Item("Spaghetti Bolognese", 10.90, "Tomato sauce spaghetti with meatballs");
        Item item3 = new Item("Mushroom Soup", 6.90, "Forest Mushroom");
        Item item4 = new Item("Pumpkin Soup", 6.90, "Cinderella Pumpkin");

        List<Item> restABCMenu = new ArrayList<>();
        List<Item> restHappyMenu = new ArrayList<>();
   
        
        restABCMenu.add(item1);
        restABCMenu.add(item2);
        restHappyMenu.add(item3);
        restHappyMenu.add(item4);

        
        
        //Restaurant List
        Restaurant restABC = new Restaurant("Restaurant ABC", "Jalan Happy", "012-1111111", restABCMenu);
        Restaurant restHappy = new Restaurant("Restaurant Happy", "Jalan Very Happy", "012-1111111", restHappyMenu);
        List<Restaurant> restaurantList = new ArrayList<>();
        restaurantList.add(restABC);
        restaurantList.add(restHappy);

        //Order
        List<Order> order = new ArrayList<>();
        
        System.out.println("HI, " + user1.getUsername());
        
        orderFood(restaurantList,user1,order);

        
        
    }

    public static void showRestaurantList(List<Restaurant> restaurantList) {
        Scanner scanner = new Scanner(System.in);
        Integer selection;

        System.out.print("Please select a restaurant : *press 0 to exit* ");
        System.out.println();
        for (int i = 0; i < restaurantList.size(); i++) {
            System.out.println(i + 1 + " . " + restaurantList.get(i).getRestaurantName());

        }
       
    }

    public static void orderFood(List<Restaurant> restaurantList, User user, List<Order> order)
    {
        Scanner scanner = new Scanner(System.in);
        Integer menuChoice;
        char newOrder = 'n';
        Integer qty = 0;
        char confirm,payment;
        char contOrder = 'n';
        
        int valid;
        Integer selection;
        
        List<Item> itemOrder = new ArrayList<>();
        List<Integer> qtyOrder = new ArrayList<>();
        List<Double> subtotal = new ArrayList<>(); 

        
        do {

            itemOrder.clear();
            qtyOrder.clear();
            
            showRestaurantList(restaurantList);
            selection = choice(0, 5);

            switch (selection) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                {

                    selection = selection -1;
                    System.out.println();
                    System.out.println(restaurantList.get(selection).getRestaurantName());
                    System.out.println();
                    System.out.print("Please select menu : *press 0 to back*");
                    System.out.println();

                    List<Item> temp = new ArrayList<>();
                    temp = restaurantList.get(selection).getMenu();

                    do {

                        for (int i = 0; i < restaurantList.get(selection).getMenu().size(); i++) {
                            System.out.println(i + 1 + " . " + temp.get(i).toString());
                        }
                        menuChoice = choice(0, restaurantList.get(selection).getMenu().size());

                        switch (menuChoice) {
                            case 0:
                                valid = 0;
                                break;

                            default:
                                valid =1;
                                menuChoice -=1;
                                System.out.println(temp.get(menuChoice).itemDetail());
                                System.out.println("Quantity (Only 10 quantity per order per time) -> ");
                                qty = choice(0, 10);
                                switch (qty) {
                                    case 0:
                                        break;
                                    default:
                                        System.out.println(temp.get(menuChoice).itemDetail());
                                        System.out.println("Quantity = " + qty);                                       
                                        System.out.println("Subtotal = " + qty *temp.get(menuChoice).getPrice() );                                      
                                       System.out.println("Confirm Order ? <Y/N>");
                                        confirm = scanner.next().charAt(0);

                                        if (confirm == 'Y' || confirm == 'y');
                                         {

                                            itemOrder.add((temp.get(menuChoice)));
                                            qtyOrder.add(qty);
                                            subtotal.add(qty *temp.get(menuChoice).getPrice());

                                        }

                                        System.out.println("More Order ? <Y/N>");
                                        contOrder = scanner.next().charAt(0);
                                        break;
                                }

                        }

                    } while(contOrder == 'Y' || contOrder == 'y');
                    
                    
                    Double total = 0.0;

                    if (valid != 0) {
                        System.out.println();
                        System.out.println("Food            Price(RM)   Qty   Subtotal(RM)");
                        for (int i = 0; i < itemOrder.size(); i++) {

                            System.out.printf("%s   %d  %.2f", itemOrder.get(i).itemDetail(), qtyOrder.get(i), subtotal.get(i));
                            System.out.println();
                            System.out.println();
                            total += subtotal.get(i);
                        }
                        System.out.println();

                        System.out.println("-----------------------------------------------");
                        System.out.printf("Total = RM %.2f", total);
                        System.out.println();
                        System.out.println("Confirm Order? <Y/N>");
                        payment = scanner.next().charAt(0);
                        if (payment == 'Y' || payment == 'y') {
                           // for (int i = 0; i<itemOrder.size();i++)
                        
                            Order orderNew = new Order(user,restaurantList.get(selection),itemOrder,qtyOrder,total);
                            order.add(orderNew);
                            System.out.println("Order Complete !");
                            System.out.println(order.get(order.size()-1).toString());
                            
                            
                            
                        }
                    }
                    break;
                }

                default:
                    System.exit(0);

            }

            System.out.println("More Order? <Y/N>");
            newOrder = scanner.next().charAt(0);

        } while (newOrder == 'Y' || newOrder == 'y');
    }
    
    public static int choice(int min, int max)  {
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
