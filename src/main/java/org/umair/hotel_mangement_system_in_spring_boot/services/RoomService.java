package org.umair.hotel_mangement_system_in_spring_boot.services;

import org.springframework.stereotype.Service;
import org.umair.hotel_mangement_system_in_spring_boot.models.Room;
import org.umair.hotel_mangement_system_in_spring_boot.repositories.RoomRepository;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Message;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Responses;

@Service
public class RoomService {

    private RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Responses createRoom(Room room) {
        try {
            Responses responses = new Responses();
            Room room1 = roomRepository.save(room);
            responses.setResponse("Data",room1);
            responses.setResponse("mainMessage",new Message("Room created",true));
            return responses;
        } catch (Exception e) {
            Responses responses = new Responses();
            responses.setResponse("mainMessage", new Message("Error in  hotel  = " + e, false));
            return responses;
        }
    }

    public Responses getAllRooms() {
        try {
            Responses responses = new Responses();


            return responses;
        } catch (Exception e) {
            Responses responses = new Responses();
            responses.setResponse("mainMessage", new Message("Error in  hotel  = " + e, false));
            return responses;
        }
    }

    public Responses getBYid(int id) {
        try {
            Responses responses = new Responses();


            return responses;
        } catch (Exception e) {
            Responses responses = new Responses();
            responses.setResponse("mainMessage", new Message("Error in  hotel  = " + e, false));
            return responses;
        }
    }

    public Responses roomDelete(int id) {
        try {
            Responses responses = new Responses();


            return responses;
        } catch (Exception e) {
            Responses responses = new Responses();
            responses.setResponse("mainMessage", new Message("Error in  hotel  = " + e, false));
            return responses;
        }
    }

}
