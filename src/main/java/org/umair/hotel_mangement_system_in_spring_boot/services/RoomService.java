package org.umair.hotel_mangement_system_in_spring_boot.services;

import org.springframework.stereotype.Service;
import org.umair.hotel_mangement_system_in_spring_boot.models.Room;
import org.umair.hotel_mangement_system_in_spring_boot.repositories.RoomRepository;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Responses;

@Service
public class RoomService {

    private RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Responses createRoom(Room room) {
        return roomRepository.createRoom(room);
    }

    public Responses getAllRooms() {
        return roomRepository.getAllRooms();
    }

    public Responses getBYid(int id) {
        return roomRepository.getById(id);
    }

}
