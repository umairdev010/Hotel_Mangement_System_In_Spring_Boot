package org.umair.hotel_mangement_system_in_spring_boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.umair.hotel_mangement_system_in_spring_boot.models.Booking;
import org.umair.hotel_mangement_system_in_spring_boot.models.Customer;
import org.umair.hotel_mangement_system_in_spring_boot.models.Room;
import org.umair.hotel_mangement_system_in_spring_boot.services.BookingService;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Responses;
import tools.jackson.databind.JsonNode;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    public BookingService bookingService;

    @PostMapping
    public Responses createBooking(@RequestBody JsonNode booking){
        System.out.println(booking);
        int roomId = booking.get("roomId").asInt();
        int customerId = booking.get("customerId").asInt();
        LocalDate check_in_date = LocalDate.parse(booking.get("check_in_date").asText());
        LocalDate check_out_date = LocalDate.parse(booking.get("check_out_date").asText());
        float price = (float) booking.get("price").asDouble();
        String status = booking.get("status").asText();
        Room room = new Room();
        room.setId(roomId);
        Customer customer = new Customer();
        customer.setId(customerId);
        Booking booking1 = new Booking(room,customer,check_in_date,check_out_date,price,status);
        Responses responses = bookingService.createBooking(booking1);
        return responses;
    }

}
