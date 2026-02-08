package org.umair.hotel_mangement_system_in_spring_boot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.umair.hotel_mangement_system_in_spring_boot.models.Room;
import org.umair.hotel_mangement_system_in_spring_boot.services.RoomService;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Message;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Responses;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public ResponseEntity<Responses> createRoom(@RequestBody Room room) {

        Responses responses = roomService.createRoom(room);
        return parseResponse(responses);

    }

    @GetMapping("/getall")
    public ResponseEntity<Responses> getAllRooms() {
        Responses responses = roomService.getAllRooms();
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
