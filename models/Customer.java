package models;

public class Customer {
    public String name;
    public String email;
    public String city;
    public String phoneNumber;

    public Customer(String name, String email, String phoneNumber, String city) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
    }
}

