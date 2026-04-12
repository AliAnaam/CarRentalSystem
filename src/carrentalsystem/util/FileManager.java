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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}