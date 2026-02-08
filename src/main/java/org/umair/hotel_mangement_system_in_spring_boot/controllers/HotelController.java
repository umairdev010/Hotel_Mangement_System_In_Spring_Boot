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
        return parseResponse(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Responses> getHotel(@PathVariable int id) {

        Responses response = hotelService.getHotel(id);
        return parseResponse(response);

    }

    @GetMapping("/getall")
    public ResponseEntity<Responses> getAllHotels() {

        Responses responses = hotelService.getAllHotels();
        return parseResponse(responses);

    }

    @GetMapping("/byname/{name}")
    public ResponseEntity<Responses> getHotelByName(@PathVariable String name) {

        Responses responses = hotelService.getHotelByName(name);
        return parseResponse(responses);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Responses> deleteHotel(@PathVariable int id){
        Responses responses = hotelService.deleteHotel(id);
        return parseResponse(responses);
    }


    public ResponseEntity<Responses> parseResponse(Responses responses) {

        Message message = (Message) responses.getData("mainMessage");

        if (!message.isSuccess()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responses);
        }
        return ResponseEntity.ok(responses);

    }

}
