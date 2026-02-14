package org.umair.hotel_mangement_system_in_spring_boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.umair.hotel_mangement_system_in_spring_boot.models.Booking;
import org.umair.hotel_mangement_system_in_spring_boot.models.Customer;
import org.umair.hotel_mangement_system_in_spring_boot.models.Room;
import org.umair.hotel_mangement_system_in_spring_boot.services.BookingService;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Message;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Responses;
import tools.jackson.databind.JsonNode;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    public BookingService bookingService;

    @PostMapping
    public ResponseEntity<Responses> createBooking(@RequestBody JsonNode booking){
        try {
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
            return parseResponse(responses);
        } catch (Exception e) {
            Responses responses = new Responses();
            responses.setResponse("mainMessage",new Message("There is an error in creating booking as = " + e,false));
            return parseResponse(responses);
        }
    }

    @GetMapping
    public ResponseEntity<Responses> getAllBookings(){
        Responses responses = bookingService.getAllBookings();
        return parseResponse(responses);
    }




    public ResponseEntity<Responses> parseResponse(Responses responses){

        try {
            Message message = (Message) responses.getData("mainMessage");
            if (!message.isSuccess()){
                return new ResponseEntity<>(responses,HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(responses,HttpStatus.OK);
        } catch (Exception e) {
            Responses responses1 = new Responses();
            responses1.setResponse("Message",new Message("There is error occured as = " + e,false));
            return new ResponseEntity<>(responses1, HttpStatus.BAD_REQUEST);
        }

    }

}
