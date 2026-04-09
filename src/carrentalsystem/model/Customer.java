/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentalsystem.model;

/**
 *
 * @author alianaam
 */
public class Customer {
    private int id;
    private String fullName;
    private String phone;
    private String email;
    private String licenseNumber;

    public Customer(int id, String fullName, String phone, String email, String licenseNumber) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.licenseNumber = licenseNumber;
    }

    // Generate Getters & Setters + toString() like above
    // toString: return id + "," + fullName + "," + phone + "," + email + "," + licenseNumber;
}
