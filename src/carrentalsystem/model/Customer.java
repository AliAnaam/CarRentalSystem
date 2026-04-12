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
    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }

    @Override
    public String toString() {
        return id + "|" + fullName + "|" + phone + "|" + email + "|" + licenseNumber;
    }
}
