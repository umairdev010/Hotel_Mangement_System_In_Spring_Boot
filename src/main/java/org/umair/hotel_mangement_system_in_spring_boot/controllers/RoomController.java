package org.umair.hotel_mangement_system_in_spring_boot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.umair.hotel_mangement_system_in_spring_boot.models.Hotel;
import org.umair.hotel_mangement_system_in_spring_boot.models.Room;
import org.umair.hotel_mangement_system_in_spring_boot.services.RoomService;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Message;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Responses;
import tools.jackson.databind.JsonNode;


@RestController
@RequestMapping("/api/room")
public class RoomController {

    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public ResponseEntity<Responses> createRoom(@RequestBody JsonNode room) {
        String name = room.get("name").asText();
        String type = room.get("type").asText();
        double price = room.get("price").asDouble();
        boolean availability = room.get("availability").asBoolean();
        int roomNumber = room.get("room_number").asInt();
        int hotelId = room.get("hotel_id").asInt();
        Hotel hotel = new Hotel();
        hotel.setId(hotelId);
        Room room1 = new Room(roomNumber,name,type,price,availability,hotel);

        Responses responses = roomService.createRoom(room1);
        return parseResponse(responses);

    }

    @GetMapping("/getall")
    public ResponseEntity<Responses> getAllRooms() {
        Responses responses = roomService.getAllRooms();
        return parseResponse(responses);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Responses> getById(@PathVariable int id){
        Responses responses = roomService.getBYid(id);
        return parseResponse(responses);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Responses> deleteRoom(@PathVariable int id){
        Responses responses = roomService.roomDelete(id);
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
