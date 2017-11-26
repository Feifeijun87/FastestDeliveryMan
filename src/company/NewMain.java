/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author ASUSPC
 */
public class NewMain {

  public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        // TODO code application logic here
        Restaurant[] restaurant= new Restaurant[2];
        restaurant[0]=new Restaurant("XXX Restaurant","Setapak");
        restaurant[1]=new Restaurant("YYY Restaurant","Klang");
        
        Meal[] meal= new Meal[5];
        meal[0]=new Meal("Filet O Fish Burger",8.90,restaurant[0]);
        meal[1]=new Meal("Fried Rice",6.50,restaurant[1]);
        meal[2]=new Meal("Beef Burger",12.90,restaurant[0]);
        meal[3]=new Meal("Maggi Goreng",4.50,restaurant[1]);
        meal[4]=new Meal("French Fries",5.50,restaurant[0]);
        
        
        Schedule[] schedule=new Schedule[10];        
        Order order=new Order();
        
        
        String day,restaurantName,time;
        int quantity,orderCount=0,choice=0,reorder=0,scheduleCount=0,deleteNum;
      
        do{
        choice=menu();
        if(choice==1){
        
do{        
         OrderDetails[] orderDtl= new OrderDetails[10];
        day = selectDay();
        time=selectTime();
        Meal food;
       
        do{
        restaurantName= selectRestaurant(restaurant);
        food=selectFood(meal,restaurantName);
        quantity=getQuantity();
        orderDtl[orderCount]= new OrderDetails(food,quantity);
        orderDtl[orderCount].calculatePrice();
        orderCount++;
            System.out.println("Any extra order on "+day+"?(1=yes,2-no)");
            System.out.print("Choice: ");
            choice=input.nextInt();
        }while(choice==1);
        
       order.setOrderDtl(orderDtl);
        order.calculateTotal();
        
        schedule[scheduleCount]=new Schedule(order,day,time);
        System.out.println("Schedule ID=" +((Schedule)schedule[scheduleCount]).getId());
        
        System.out.println(schedule[scheduleCount].toString());
        scheduleCount++;
        
        System.out.println("Do you want to make a new schedule? (1-yes 0-no)");
        reorder=input.nextInt();
        
}while(reorder==1);
        } 
        else if (choice==2){
           for (int i=0;i<schedule.length;i++){
               if(schedule[i]!=null)
               System.out.println(i+1+". "+((Schedule)schedule[i]).getId());
               
        }
           System.out.print("Cancel:: ");
           deleteNum=input.nextInt();
           schedule[deleteNum]=null;
            System.out.println("Successful");
           
           
        }
        else if (choice==3){
            int count=0;
            if (schedule.length==0){
                System.out.println("no Schedule");}
        for(int i=0;i<schedule.length;i++){
            if(schedule[i]!=null){
            System.out.println(count+1+". "+((Schedule)schedule[i]).getId());
            count++;}
        }
        }
        choice=continues();
        
        }while (choice==1);
        
        
    }
  public static int continues(){
  int choice;
  Scanner input=new Scanner(System.in);
      System.out.println("Go to menu? (1-yes 0-no)");
      choice=input.nextInt();
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
        public static int menu(){
        int choice;
        Scanner input=new Scanner(System.in);
        System.out.println("1. Add schedule");
        System.out.println("2. Cancel schedule");
        System.out.println("3. List schedule");
        choice=checkDigit();
        return choice;
        
        }
        public static int getQuantity(){
        int quantity;
        Scanner input= new Scanner(System.in);
       
            System.out.print("Quantity: ");
            quantity=checkDigit();
            return quantity;
        }
        
        public static Meal selectFood(Meal[] meal, String restaurant){
        Scanner input=new Scanner(System.in);
        Meal foodOrdered=new Meal();
        int choice,count=1;
        String[] foodArr=new String[100];
            System.out.println("Please select the meal");
            for (int i=0;i<meal.length;i++){
            if (((Restaurant)((Meal)meal[i]).getRestaurant()).getName().equals(restaurant)){
            System.out.println(count+". "+meal[i].getName());
            
            foodArr[count]=meal[i].getName();
            count++;
            } 
            }
            System.out.print("Choice: ");
            choice=checkDigit();
            
              for (int i=0;i<meal.length;i++){
                 
            if (((Meal)meal[i]).getName().equals(foodArr[choice])){
            
            foodOrdered.setName(meal[i].getName());
            foodOrdered.setUnitPrice(meal[i].getUnitPrice());
            foodOrdered.setRestaurant(meal[i].getRestaurant());
            
            } 
            
            }
              return foodOrdered;
        }
        
        
        public static String selectRestaurant(Restaurant[] restaurant){
            int choice=0;
        String restaurantName;
        Scanner input=new Scanner(System.in);
            System.out.println("Please select restaurant");
            for (int i=0;i<restaurant.length;i++){
                System.out.println((i+1)+". "+restaurant[i].getName());
            }
            System.out.print("Choice: ");
            choice=checkDigit();
            restaurantName=restaurant[choice-1].getName();     
        
        
        return restaurantName;
        }
        
    public static String selectTime(){
        Scanner input= new Scanner(System.in);
    String time;
            int choice;
        System.out.println("Please select time (1-AM , 2-PM)");
        System.out.print("Choice: ");
        choice=checkDigit();
        System.out.println("Please enter the time");
        input.nextLine();
        System.out.print("Time: ");
        time=input.nextLine();
        if(choice==1)
            time+="AM";
        else if (choice==2)
            time+="PM";
        
        return time;
    }    
    public static String selectDay(){
    Scanner input=new Scanner(System.in);
    int day=0;
    String str="";
        System.out.println("Please select the day you want to order (1=Sunday,7=Saturday)");
        System.out.print("Day: ");
        day=checkDigit();
        switch (day) {
            case 2:
                str="Monday";
                break;
            case 3:
                str="Tuesday";
                break;
            case 1:
                str="Sunday";
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
    
}
