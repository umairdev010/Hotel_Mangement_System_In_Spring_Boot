package org.umair.hotel_mangement_system_in_spring_boot.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "room_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_booking_room")
    )
    private Room room;

    // Many bookings can be for one customer
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "customer_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_booking_customer")
    )
    private Customer customer;
    private LocalDate check_in_date;
    private LocalDate check_out_date;
    private float price;
    private String status;
    @CreationTimestamp
    private Date createdAt;

    public Booking() {
    }

    public Booking(Room room_id, Customer customer_id, LocalDate check_in_date, LocalDate check_out_date, float price, String status) {
        this.room = room_id;
        this.customer = customer_id;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
        this.price = price;
        this.status = status;
    }


    public LocalDate getCheck_in_date() {
        return check_in_date;
    }

    public void setCheck_in_date(LocalDate check_in_date) {
        this.check_in_date = check_in_date;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "room='" + room + '\'' +
                ", customer='" + customer + '\'' +
                ", check_in_date=" + check_in_date +
                ", check_out_date=" + check_out_date +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
}
