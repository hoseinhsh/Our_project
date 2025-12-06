package services;

import models.Customer;
import models.Room;

public class Reservation {
    private Room room;
    private Customer customer;
    private int nights;

    public Reservation(Room room, Customer customer, int nights) {
        this.room = room;
        this.customer = customer;
        this.nights = nights;
    }

    public Room getRoom() {
        return room;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getNights() {
        return nights;
    }

    public double getTotalPrice() {
        return room.calculateTotal(nights);
    }
}

