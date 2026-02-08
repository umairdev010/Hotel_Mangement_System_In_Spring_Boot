package org.umair.hotel_mangement_system_in_spring_boot.models;

import java.time.LocalDate;

public class Booking {

    private String room_id;
    private String customer_id;
    private LocalDate check_in_date;
    private LocalDate check_out_date;
    private float price;
    private String status;

    public Booking() {
    }

    public Booking(String room_id, String customer_id, LocalDate check_in_date, LocalDate check_out_date, float price, String status) {
        this.room_id = room_id;
        this.customer_id = customer_id;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
        this.price = price;
        this.status = status;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public LocalDate getCheck_in_date() {
        return check_in_date;
    }

    public void setCheck_in_date(LocalDate check_in_date) {
        this.check_in_date = check_in_date;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public LocalDate getCheck_out_date() {
        return check_out_date;
    }

    public void setCheck_out_date(LocalDate check_out_date) {
        this.check_out_date = check_out_date;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "room_id='" + room_id + '\'' +
                ", customer_id='" + customer_id + '\'' +
                ", check_in_date=" + check_in_date +
                ", check_out_date=" + check_out_date +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
}
