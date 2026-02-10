package org.umair.hotel_mangement_system_in_spring_boot.services;

import org.springframework.stereotype.Service;
import org.umair.hotel_mangement_system_in_spring_boot.models.Hotel;
import org.umair.hotel_mangement_system_in_spring_boot.models.Room;
import org.umair.hotel_mangement_system_in_spring_boot.repositories.RoomRepository;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Message;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Responses;

import java.util.List;

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
            responses.setResponse("mainMessage", new Message("Error in  Room  = " + e, false));
            return responses;
        }
    }

    public Responses getAllRooms() {
        try {
            Responses responses = new Responses();
            List<Room> roomList = roomRepository.findAll();
            if (roomList.get(0) == null ){
                throw new Exception("There is no room in database.");
            }
            responses.setResponse("Data",roomList);
            responses.setResponse("mainMessage", new Message("Rooms get successfully", true));
            return responses;
        } catch (Exception e) {
            Responses responses = new Responses();
            responses.setResponse("mainMessage", new Message("Error in  Room  = " + e, false));
            return responses;
        }
    }

    public Responses getBYid(int id) {
        try {
            Responses responses = new Responses();
            Room room = roomRepository.findById(id);
            if (room == null){
                throw new Exception("There is no room with this id");
            }
            responses.setResponse("Data",room);
            responses.setResponse("mainMessage", new Message("Room get successfully " , true));
            return responses;
        } catch (Exception e) {
            Responses responses = new Responses();
            responses.setResponse("mainMessage", new Message("Error in  Room  = " + e, false));
            return responses;
        }
    }

    public Responses roomDelete(int id) {
        try {
            Responses responses = new Responses();
            Room room = roomRepository.findById(id);
            if (room == null){
                throw new Exception("There is no room with this id");
            }
            roomRepository.delete(room);
            responses.setResponse("mainMessage", new Message("Room deleted", true);

            return responses;
        } catch (Exception e) {
            Responses responses = new Responses();
            responses.setResponse("mainMessage", new Message("Error in  Room  = " + e, false));
            return responses;
        }
    }

}
