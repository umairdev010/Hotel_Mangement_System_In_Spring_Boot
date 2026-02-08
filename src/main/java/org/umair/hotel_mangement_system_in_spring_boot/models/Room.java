package org.umair.hotel_mangement_system_in_spring_boot.models;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private int id;
    private int room_number;
    private String name;
    private String type;
    private float price;
    private boolean availability;
    private int hotel_id;
    private Hotel hotelDetails;

    public Room() {
    }

    public Room(int room_number, String name, String type, float price, boolean availability, int hotel_id) {
        this.room_number = room_number;
        this.name = name;
        this.type = type;
        this.price = price;
        this.availability = availability;
        this.hotel_id = hotel_id;
    }

    public Hotel getHotelDetails() {
        return hotelDetails;
    }

    public void setHotelDetails(Hotel hotelDetails) {
        this.hotelDetails = hotelDetails;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    @Override
    public String toString() {
        return "Room{" +
                "room_number=" + room_number +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", availability=" + availability +
                ", hotel_id=" + hotel_id +
                '}';
    }
}
