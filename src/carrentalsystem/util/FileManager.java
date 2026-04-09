/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentalsystem.util;

/**
 *
 * @author alianaam
 */
import java.io.*;
import java.util.*;

public class FileManager {
    private static final String CARS_FILE = "cars.txt";
    private static final String CUSTOMERS_FILE = "customers.txt";
    private static final String RENTALS_FILE = "rentals.txt";

    public static void saveCars(List<Car> cars) {
        saveList(cars, CARS_FILE);
    }

    public static void saveCustomers(List<Customer> customers) {
        saveList(customers, CUSTOMERS_FILE);
    }

    public static void saveRentals(List<Rental> rentals) {
        saveList(rentals, RENTALS_FILE);
    }

    private static void saveList(List<?> list, String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Object obj : list) {
                pw.println(obj.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load methods (read line by line and create objects) - I will give you when we build the forms
}