package org.umair.hotel_mangement_system_in_spring_boot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.umair.hotel_mangement_system_in_spring_boot.models.Hotel;
import org.umair.hotel_mangement_system_in_spring_boot.services.HotelService;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Message;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Responses;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/create")
    public ResponseEntity<Responses> createHotel(@RequestBody Hotel hotel) {
        Message message = hotelService.createHotel(hotel);
        Responses response = new Responses();
        response.setResponse("mainMessage", message);
        if (!message.isSuccess()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Responses> getHotel(@PathVariable int id){

        Responses response = hotelService.getHotel(id);

        Message message = (Message) response.getData("mainMessage");

        if (!message.isSuccess()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        return ResponseEntity.ok(response);

    }

    @GetMapping("/getall")
    public ResponseEntity<Responses> getAllHotels(){

        Responses responses = hotelService.getAllHotels();

        Message message = (Message) responses.getData("mainMessage");

        if (!message.isSuccess()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responses);
        }
        return ResponseEntity.ok(responses);
    }

}
