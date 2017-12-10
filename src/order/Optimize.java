/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;
import static company.NewMain.checkDigit;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUSPC
 */
public class Optimize {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        User user1 = new User("Fiffy","cute88","Jalan Cutie,Klang","011-111111");
        User user2 = new User("Sixty","nocute87","Jalan Ugly,Setapak","012-9487953");
        
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
        Restaurant restABC = new Restaurant("Restaurant ABC", "Setapak", "012-1111111", restABCMenu);
        Restaurant restHappy = new Restaurant("Restaurant Happy", "Klang", "012-1111111", restHappyMenu);
        List<Restaurant> restaurantList = new ArrayList<>();
        restaurantList.add(restABC);
        restaurantList.add(restHappy);
        
        List<Item> tempOrder=new ArrayList<>();
        tempOrder.add(item1);
        List<Integer> qty1 = new ArrayList<>();
        qty1.add(1);
        
        
        List<Item> tempOrder2=new ArrayList<>();
        tempOrder2.add(item2);
         List<Integer> qty2 = new ArrayList<>();
        qty2.add(1);
        
        List<Item> tempOrder3=new ArrayList<>();
        tempOrder3.add(item3);
        List<Integer> qty3 = new ArrayList<>();
        qty3.add(1);
        
        List<Item> tempOrder4=new ArrayList<>();
        tempOrder4.add(item1);
         List<Integer> qty4 = new ArrayList<>();
        qty4.add(1);

        //Order
        List<Order> order = new ArrayList<>();
        List<Order> orderq;
        Order order1 = new Order(user1,restABC,tempOrder,qty1,12.90);
        
        Order order2 = new Order(user2,restABC,tempOrder2,qty2,10.90);
        
        Order order3 = new Order(user1,restABC,tempOrder3,qty1,6.90);
        Order order4 = new Order(user2,restABC,tempOrder4,qty1,6.90);
        
        
        order.add(order1);
        order.add(order2);
        order.add(order3);
        order.add(order4);
        orderq= new ArrayList<Order>(order);

        Schedule schedule1=new Schedule(order1,7,"0900");
        Schedule schedule2=new Schedule(order2,7,"1000");
        Schedule schedule3=new Schedule(order3,2,"2000");
        Schedule schedule4=new Schedule(order4,2,"1200");
        List<Schedule> schedule = new ArrayList<>();
        schedule.add(schedule1);
        schedule.add(schedule2);
        schedule.add(schedule3);
        schedule.add(schedule4);
        int menuChoice,day,again=0;
        String time;
        Restaurant chooseRest;
        Order orderTemp;
        Schedule scheduleTemp;
         do{  
         menuChoice=menu();
     
       do{
       
            if(menuChoice==1){
                    day=selectDay();
                    time=selectTime();
                    chooseRest=selectRestaurant(restaurantList);
                    orderTemp=selectFood(chooseRest,user1);
                    if(orderTemp==null)
                        System.out.println("Cancelled");
                    else{
                    scheduleTemp=new Schedule(orderTemp,day,time);
                    schedule.add(scheduleTemp);
                    printOrder(scheduleTemp);
                    }}
            else if (menuChoice==2){
                   showWork(schedule);
            }
            else{
                    System.out.println("No Such Selection");
            }        
    }while(menuChoice<1||menuChoice>2);
   
        again=again();
   }while(again==1);
        
    }
        public static int again(){
        int choice;
        do{
            System.out.println("Go To Menu?(1-Yes 2-No)");
            choice=checkDigit();
            if(choice<1||choice>2)
                System.out.println("No Such Selection");
        }while(choice<1||choice>2);
        return choice;
        }
    
        public static void printOrder(Schedule schedule){
            String str="";
            System.out.println("Schedule ID:"+ schedule.getId());
            System.out.println("Day:"+schedule.getDayOfWeek());
            str+=String.format("%-3s%-20s%-12s%-5s%-10s","No","Food Name","Unit Price","Qty","Subtotal");
            System.out.println(str);
            
            str=schedule.showOrder();
            System.out.println(str);
        }
        public static void showWork(List<Schedule> schedule){
        Calendar clndr = Calendar.getInstance();
        
        int dayOfWeek=clndr.get(Calendar.DAY_OF_WEEK);
        System.out.println("Current Date: " +convertDayOfWeek(dayOfWeek));
        System.out.println("Schedule for today:");
        
        List<Schedule> temp=new ArrayList<>();
        for( int i=0; i<schedule.size();i++){
        if(dayOfWeek==schedule.get(i).getDayOfWeek() && schedule.get(i).getOrder().getRestaurant().getRestAddress().equals("Setapak")){
            temp.add(schedule.get(i));
        }
        }
        
        for(int i=0;i<temp.size();i++){
            for (int j=0;j<temp.size();j++){
        if(Integer.parseInt(temp.get(j).getTime())>Integer.parseInt(temp.get(i).getTime())){
        Schedule tempo=temp.get(i);
        temp.set(i, temp.get(j));
        temp.set(j, tempo);
            }
            
        }
        }
        String str="";
            System.out.println(temp.size());
        str+=String.format("%-4s%-6s%-5s%-20s%-20s%-20s\n","No","Time","Item","Restaurant Name","Customer Name","Address");
        for(int i=0;i<temp.size();i++){
            str+=i+1+".  "+temp.get(i).getTime()+ "  "+temp.get(i).getOrder().deliveries();
        }
        System.out.println(str);
            System.out.println();
        
        }
        public static int menu(){
        int choice;
            System.out.println("1. Make Schedule Order");
            System.out.println("2. View task assigned");
            choice=checkDigit();
            return choice;
        }
    public static int checkDigit(){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean valid = true;
        
        do{
            try{
                System.out.print("Enter your choice > ");
                choice = scanner.nextInt();
                System.out.println();
                valid = false;
            }catch(Exception error){
                System.out.println("\nWrong Input! Please enter again.");
                valid = true;
                scanner.nextLine();
            }
        }while(valid);
        
        return choice;
    }
        public static String convertDayOfWeek(int dayOfWeek){
        String str="";
        switch (dayOfWeek) {
            case 1:
                str="Sunday";
                break;
            case 2:
                str="Monday";
                break;
            case 3:
                str="Tuesday";
                break;
            case 4:
                str="Wednesday";
                break;
            case 5:
                str="Thursday";
                break;
            case 6:
                str="Friday";
                break;
            case 7:
                str="Saturday";
                break;
            default:
                break;
        }
    return str;
    }
        
        public static String selectTime(){
        Scanner input= new Scanner(System.in);
        String time;
       
        
        System.out.println("Please enter the time");
            System.out.print("Time:");
        time=input.nextLine();
       
        return time;
    }    
    public static int selectDay(){
    
    int day;
    
        System.out.println("Please select the day you want to order (1=Sunday,7=Saturday)");
        day=checkDigit();
        
      return day;
        
    }
         public static int getQuantity(){
        int quantity;
             System.out.println("Please choose Quantity");
            quantity=checkDigit();
            return quantity;
        }
         public static boolean confirmOrder(){
             int choice;
             do{
             System.out.println("Confirm?(1-yes 2-no)");
             choice=checkDigit();
                 switch (choice) {
                     case 1:
                         return true;
                     case 2:
                         return false;
                     default:
                         System.out.println("No Such Selection");
                         break;
                 }
         }while(choice<1||choice>2);
             return false;
         
         }
         public static boolean addOrder(){
             int choice;
             System.out.println("Add Item? (1-yes 2-no)");
             choice=checkDigit();
             switch (choice) {
                     case 1:
                         return true;
                     case 2:
                         return false;
                     default:
                         System.out.println("No Such Selection");
                         break;
                 }
             return false;
         
         }
    public static Order selectFood(Restaurant restaurant,User user){
        
        Order foodOrdered=null;
        List<Item> menu=restaurant.getMenu();
        List<Item>orderItem = new ArrayList<>();
        int choice;
        double total=0;
        List<Integer> qty = new ArrayList<>();
        do{
        for(int i=0;i<menu.size();i++){
            System.out.println(i+1+menu.get(i).getFoodName());
           
        }
            
            choice=checkDigit();
            orderItem.add(menu.get(choice-1));
            qty.add(getQuantity());
            
        }while(addOrder()); 
            if(confirmOrder()){
                for(int i=0;i<orderItem.size();i++){
                total+= orderItem.get(i).getPrice()*qty.get(i);
                }
                foodOrdered=new Order(user,restaurant,orderItem,qty,total);
            
            }
            
            
              return foodOrdered;
        }
    public static Restaurant selectRestaurant(List<Restaurant> restaurant){
            int choice=0;
        Restaurant restaurantName;
        Scanner input=new Scanner(System.in);
            System.out.println("Please select restaurant");
            for (int i=0;i<restaurant.size();i++){
                System.out.println((i+1)+". "+restaurant.get(i).getRestaurantName());
            }
            System.out.print("Choice: ");
            choice=checkDigit();
            restaurantName=restaurant.get(choice-1);
        
        
        return restaurantName;
        }
    
}
