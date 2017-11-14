/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

/**
 *
 * @author ASUSPC
 */
public class Schedule{
private String id,day,time;
private Order order;

private static int count=1;

public Schedule(Order order,String day,String time){

    this.order=order;
    this.day=day;
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
        str+=String.format("%-7s%-23s%-7s%-14s\n","Day: ",getDay(),"Time: ",getTime());
        str+=((Order)order).toString();
        return str;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



}