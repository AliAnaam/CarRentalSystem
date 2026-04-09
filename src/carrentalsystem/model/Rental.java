/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentalsystem.model;

/**
 *
 * @author alianaam
 */
import java.util.Date;

public class Rental {
    private int rentalId;
    private int carId;
    private int customerId;
    private String rentalDate;      // store as String "2026-04-10"
    private String expectedReturnDate;
    private String actualReturnDate; // null if not returned
    private double totalAmount;
    private String status; // Active, Returned

    // Constructor, Getters, Setters, toString
}
