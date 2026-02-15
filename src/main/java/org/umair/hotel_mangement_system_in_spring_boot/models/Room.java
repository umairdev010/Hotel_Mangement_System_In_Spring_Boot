package org.umair.hotel_mangement_system_in_spring_boot.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private int room_number;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private boolean availability;
    @ManyToOne
    private Hotel hotel;

    public Room() {
    }

    public Room(int room_number, String name, String type, double price, boolean availability, Hotel hotel) {
        this.room_number = room_number;
        this.name = name;
        this.type = type;
        this.price = price;
        this.availability = availability;
        this.hotel = hotel;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Room{" +
                "room_number=" + room_number +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", availability=" + availability +
                ", hotel=" + hotel +
                '}';
    }
}
