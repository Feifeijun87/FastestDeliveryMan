/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

/**
 *
 * @author ASUSPC
 */
public class Schedule{
private String id,time;
private int dayOfWeek;
private Order order;

private static int count=1;

public Schedule(Order order,int dayOfWeek,String time){

    this.order=order;
    this.dayOfWeek=dayOfWeek;
    this.time=time;
    this.id="S"+count;
    count++;
}

    public String getId() {
        return id;
    }
    public void addCount(){
    count++;
    }

    @Override
    public String toString() {
        String str="";
        str+=String.format("%-7s%-23s%-7s%-14s\n","Day: ",convertDayOfWeek(),"Time: ",getTime());
        str+=getOrder().toString();
        return str;
    }

    public Order getOrder() {
        return order;
    }
    public String convertDayOfWeek(){
        String str="";
    if (dayOfWeek==1)
        str="Sunday";
    else if (dayOfWeek==2)
       str="Monday";
    else if (dayOfWeek==3)
         str="Tuesday";
    else if (dayOfWeek==4)
       str="Wednesday";
    else if (dayOfWeek==5)
        str="Thursday";
    else if (dayOfWeek==6)
       str="Friday";
    else if (dayOfWeek==7)
         str="Saturday";
    return str;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    }