package org.umair.hotel_mangement_system_in_spring_boot.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.umair.hotel_mangement_system_in_spring_boot.models.Hotel;
import org.umair.hotel_mangement_system_in_spring_boot.models.Room;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Message;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Responses;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoomRepository {

    private JdbcTemplate jdbcTemplate;

    public RoomRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public Responses createRoom(Room room) {
        Responses responses = new Responses();
        try {
            responses.setResponse("mainMessage", new Message("Successfully added new room ", true));
            return responses;
        } catch (Exception e) {
            responses.setResponse("mainMessage", new Message("Error is occurred while deleting hotel " + e, false));
            return responses;
        }

    }


    public Responses getAllRooms(){

        Responses responses =new Responses();

        try {
                responses.setResponse("mainMessage",new Message("All Rooms successfully fetched",true));
                return responses;
        } catch (Exception e) {
            responses.setResponse("mainMessage",new Message("there is error in getting rooms " + e,false));
            return responses;
        }


    }

    public Responses getById(int id){
        Responses responses = new Responses();
        try {
            responses.setResponse("mainMessage",new Message("GETTING ROOM SUCCESSFUL",true));
            return responses;
        } catch (Exception e) {
            responses.setResponse("mainMessage",new Message("THERE IS ERROR IN GETTING ROOM " + e,false));
            return responses;
        }

    }

    public Responses deleteRoom(int id){
        Responses responses = new Responses();
        try {
            String sql = "DELETE FROM rooms WHERE id = ?";
            int row = jdbcTemplate.update(sql,id);
            if (row == 0){
                responses.setResponse("mainMessage",new Message("THERE IS ERROR IN DELEING ROOM AND NO ROOM FOUND",false));
                return responses;
            }
                responses.setResponse("mainMessage",new Message("ROOM DELETED",true));
                return responses;
        } catch (Exception e) {
            responses.setResponse("mainMessage",new Message("THERE IS ERROR IN DELETING ROOM " + e,false));
            return responses;
        }

    }

}
