/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentalsystem.model;

/**
 *
 * @author alianaam
 */
public class Car {
    private int id;
    private String brand;
    private String model;
    private String plateNumber;
    private double dailyRate;
    private String status; // Available, Rented, Maintenance

    public Car(int id, String brand, String model, String plateNumber, double dailyRate, String status) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.plateNumber = plateNumber;
        this.dailyRate = dailyRate;
        this.status = status;
    }

    // Getters and Setters (Right-click inside class → Insert Code → Getters and Setters)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public String getPlateNumber() { return plateNumber; }
    public void setPlateNumber(String plateNumber) { this.plateNumber = plateNumber; }
    public double getDailyRate() { return dailyRate; }
    public void setDailyRate(double dailyRate) { this.dailyRate = dailyRate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return id + "," + brand + "," + model + "," + plateNumber + "," + dailyRate + "," + status;
    }
}
