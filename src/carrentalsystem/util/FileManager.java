/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentalsystem.util;

import carrentalsystem.model.Car;
import carrentalsystem.model.Customer;
import java.io.*;
import java.util.List;

public class FileManager {

    public static void saveCars(List<Car> cars) {
        saveList(cars, "cars.txt");
    }

    public static void saveCustomers(List<Customer> customers) {
        saveList(customers, "customers.txt");
    }

    private static void saveList(List<?> list, String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Object obj : list) {
                pw.println(obj.toString());
            }
            System.out.println("✅ Saved " + list.size() + " items to " + filename); // Debug message
        } catch (IOException e) {
            System.out.println("❌ Error saving to " + filename);
            e.printStackTrace();
        }
    }

    // Add this helper to load cars (we'll use it in forms)
    public static List<Car> loadCars() {
        List<Car> list = new java.util.ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("cars.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] p = line.split("\\|");
                if (p.length == 6) {
                    Car c = new Car(Integer.parseInt(p[0]), p[1], p[2], p[3],
                            Double.parseDouble(p[4]), p[5]);
                    list.add(c);
                }
            }
            System.out.println("✅ Loaded " + list.size() + " cars from file");
        } catch (Exception e) {
            System.out.println("No cars.txt file yet or error loading");
        }
        return list;
    }
}