/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

/**
 *
 * @author hsuhong1210
 */
public class DeliveryReportDistance {

    private int id;
    private String name;
    private int totalDistance;
    private String date;
    private int printId;
    private double revisionNo;

    public DeliveryReportDistance(int id, String name, int totalDistance, String date, int printId, double revisionNo) {
        this.id = id;
        this.name = name;
        this.totalDistance = totalDistance;
        this.date = date;
        this.printId = printId;
        this.revisionNo = revisionNo;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public String getDate() {
        return date;
    }

    public int getPrintId() {
        return printId;
    }

    public double getRevisionNo() {
        return revisionNo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotalDistance(int totalDistance) {
        this.totalDistance = totalDistance;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPrintId(int printId) {
        this.printId = printId;
    }

    public void setRevisionNo(double revisionNo) {
        this.revisionNo = revisionNo;
    }

    @Override
    public String toString() {
        return String.format("| %-40s | %-30d |", name, totalDistance);
    }

}
