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
        System.out.println();
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
        char proceedToConfirm = 'n';
        
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
                
                case 0:
                    System.out.println();
                    System.out.println("Thanks for using :)");
                    System.exit(0);
                    
                default: {

                    selection = selection - 1;
                    System.out.println();
                    System.out.println(restaurantList.get(selection).getRestaurantName());
                    System.out.println("============");
                    System.out.println();
                    System.out.println("Please select menu : *press 0 to back*");
                    //System.out.println();

                    temp = restaurantList.get(selection).getMenu();
                    

                    order: do {
                        do {
                            System.out.println();
                            System.out.printf("Num Food Name\t\t\tPrice(RM)\tDescription");
                            System.out.println();
                            for (int i = 0; i < restaurantList.get(selection).getMenu().size(); i++) {
                                System.out.printf("%d . %s\t\tRM%.2f\t\t%s", i + 1, temp.get(i).getFoodName(), temp.get(i).getFoodPrice(), temp.get(i).getDesc());
                                System.out.println();
                        }
                        menuChoice = choice(0, restaurantList.get(selection).getMenu().size());

                        switch (menuChoice) {
                            case 0:
                                valid = 0;
                                proceedToConfirm='n';
                                back =1;
                                newOrder = 'y';
                                break order;

                            default:
                                back=0;
                                valid =1;
                                menuChoice -=1;
                                System.out.println();
                                System.out.printf("%s\t\t%.2f\n",temp.get(menuChoice).getFoodName(), temp.get(menuChoice).getFoodPrice());
                                System.out.println("Please select quantity \nMaximum 10 quantity per order per time\n");
                                qty = choice(0, 10);
                                switch (qty) {
                                    case 0:
                                        break;
                                    default:
                                         System.out.println();
                                        System.out.printf("%s\t\tRM%.2f\n",temp.get(menuChoice).getFoodName(), temp.get(menuChoice).getFoodPrice());
                                
                                        System.out.println("Quantity = " + qty);                                       
                                        System.out.printf("Subtotal = RM%.2f",qty *temp.get(menuChoice).getPrice() );    
                                        System.out.println();
                                       System.out.println("Confirm Order ? <Y/N>");
                                        confirm = scanner.next().charAt(0);

                                        if (confirm == 'Y' || confirm == 'y')
                                         {
                                             System.out.println();
                                            System.out.println("Order added!");
                                            itemOrder.add((temp.get(menuChoice)));
                                            qtyOrder.add(qty);
                                            subtotal.add(qty *temp.get(menuChoice).getPrice());

                                        }
                                        else
                                        {
                                            System.out.println("Order Cancelled.");
                                        }

                                        System.out.println();
                                        System.out.println("More Order from this restaurant ? <Y/N>");
                                        contOrder = scanner.next().charAt(0);
                                        break;
                                }

                        }

                        } while (contOrder == 'Y' || contOrder == 'y');
                            
                        if(valid !=0)
                        {
                        System.out.println();
                        System.out.println("Proceed to Order Confirmation? <Y/N>");
                        proceedToConfirm = scanner.next().charAt(0);
                        }
                        
                    } while (proceedToConfirm != 'Y' && proceedToConfirm != 'y');

                    
                    Double total = 0.0;
                    if(itemOrder.isEmpty())
                    {
                        valid =0;
                    }

                    if (valid != 0 ) {
                        System.out.println();
                        System.out.println("Num Food Name\t\t\tPrice(RM)\tQty\tSubtotal(RM)");
                        for (int i = 0; i < itemOrder.size(); i++) {

                            System.out.printf("%d . %s\t\t%.2f\t\t%d\t%.2f",i+1, itemOrder.get(i).getFoodName(),itemOrder.get(i).getFoodPrice(), qtyOrder.get(i), subtotal.get(i));
                            System.out.println();
                            total += subtotal.get(i);
                        }
                        //System.out.println();

                        System.out.println("-----------------------------------------------");
                        System.out.printf("Total = RM %.2f", total);
                        System.out.println();
                        System.out.println();
                        System.out.println("Confirm Order? <Y/N>");
                        payment = scanner.next().charAt(0);
                        if (payment == 'Y' || payment == 'y') {
                           // for (int i = 0; i<itemOrder.size();i++)                
                            Order orderNew = new Order(user,restaurantList.get(selection),itemOrder,qtyOrder,total);
                            order.add(orderNew);
                            System.out.println();
                            System.out.println("Order Successful !");
                            System.out.printf("Your total payment is : RM %.2f \n", total);
                            System.out.println("Please prepare enough amount when your delivery man arrive ! :) ");
                            System.out.println();
                            //System.out.println(order.get(order.size()-1).toString());
                            
                        }
                        else
                        {
                            System.out.println();
                            System.out.println("Order Cancelled.");
                        }
                    }
                    break;
                }
 
            }
            if(back ==0)
            {
            System.out.println();
            System.out.println("Do you want to make new order? <Y/N>");
            newOrder = scanner.next().charAt(0);
            }

        } while (newOrder == 'Y' || newOrder == 'y');
        
        System.out.println();
        System.out.println("Thanks for using :)");
        
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
