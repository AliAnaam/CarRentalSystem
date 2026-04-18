/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentalsystem.gui;

import carrentalsystem.model.Car;
import carrentalsystem.model.Customer;
import java.io.*;
import java.util.*;

/**
 *
 * @author alianaam
 */
public class DataManager {

    private static final DataManager instance = new DataManager();

    public static DataManager getInstance() {
        return instance;
    }

    private List<Car> carList = new ArrayList<>();
    private List<Customer> customerList = new ArrayList<>();
    
    private int nextCarId = 1;
    private int nextCustomerId = 1;

    private DataManager() {
        loadCars();
        loadCustomers();
        
        // Strong shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            saveCars();
            saveCustomers();
            System.out.println("✅ FINAL SAVE: All data saved before program exit");
        }));
    }

    // Force save method
    public void forceSave() {
        saveCars();
        saveCustomers();
    }

    // ====================== CARS ======================
    public List<Car> getCars() {
        return carList;
    }

    public void addCar(Car car) {
        carList.add(car);
        if (car.getId() >= nextCarId) nextCarId = car.getId() + 1;
        saveCars();
    }

    public void updateCar(Car updatedCar) {
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getId() == updatedCar.getId()) {
                carList.set(i, updatedCar);
                break;
            }
        }
        saveCars();
    }

    public void deleteCar(int id) {
        carList.removeIf(c -> c.getId() == id);
        saveCars();
    }

    private void saveCars() {
    try (PrintWriter pw = new PrintWriter(new FileWriter("cars.txt"))) {
        for (Car c : carList) {
            pw.println(c.toString());
        }
        System.out.println("✅ Cars SAVED to file: " + carList.size() + " cars");
    } catch (Exception e) {
        System.out.println("❌ FAILED to save cars.txt");
        e.printStackTrace();
    }
}

    private void loadCars() {
    carList.clear();
    int loadedCount = 0;

    try (BufferedReader br = new BufferedReader(new FileReader("cars.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            String[] p = line.split("\\|");
            
            // Must have exactly 6 parts
            if (p.length == 6) {
                try {
                    int id = Integer.parseInt(p[0].trim());
                    String brand = p[1].trim();
                    String model = p[2].trim();
                    String plate = p[3].trim();
                    double rate = Double.parseDouble(p[4].trim());
                    String status = p[5].trim();

                    Car c = new Car(id, brand, model, plate, rate, status);
                    carList.add(c);
                    
                    if (id >= nextCarId) nextCarId = id + 1;
                    loadedCount++;
                } catch (Exception ex) {
                    System.out.println("Skipping invalid line: " + line);
                }
            } else {
                System.out.println("Skipping malformed line: " + line);
            }
        }
        
        System.out.println("✅ Successfully loaded " + loadedCount + " cars from cars.txt");
        
    } catch (Exception e) {
        System.out.println("No cars.txt file found or unable to read it. Starting fresh.");
    }
}

    public int getNextCarId() {
        return nextCarId++;
    }

    // ====================== CUSTOMERS ======================
    public List<Customer> getCustomers() {
        return customerList;
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
        if (customer.getId() >= nextCustomerId) nextCustomerId = customer.getId() + 1;
        saveCustomers();
    }

    public void updateCustomer(Customer updatedCustomer) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId() == updatedCustomer.getId()) {
                customerList.set(i, updatedCustomer);
                break;
            }
        }
        saveCustomers();
    }

    public void deleteCustomer(int id) {
        customerList.removeIf(c -> c.getId() == id);
        saveCustomers();
    }

    private void saveCustomers() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("customers.txt"))) {
            for (Customer c : customerList) {
                pw.println(c.toString());
            }
        } catch (Exception e) {}
    }

    private void loadCustomers() {
        customerList.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("customers.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] p = line.split("\\|");
                if (p.length == 5) {
                    Customer c = new Customer(Integer.parseInt(p[0]), p[1], p[2], p[3], p[4]);
                    customerList.add(c);
                    if (c.getId() >= nextCustomerId) nextCustomerId = c.getId() + 1;
                }
            }
        } catch (Exception e) {}
    }

    public int getNextCustomerId() {
        return nextCustomerId++;
    }
}
