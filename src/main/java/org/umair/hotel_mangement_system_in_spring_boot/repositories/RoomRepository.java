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

    RowMapper<Room> rowMapperRoom = ((rs, rowNum) -> {
        Room room = new Room();
        room.setName(rs.getString("name"));
        room.setRoom_number(rs.getInt("room_number"));
        room.setAvailability(rs.getBoolean("availability"));
        room.setType(rs.getString("type").toUpperCase());
        room.setPrice(rs.getFloat("price"));
        room.setHotel_id(rs.getInt("hotel_id"));
        room.setId(rs.getInt("id"));
        return room;
    });

    RowMapper<Hotel> rowMapperHotel = ((rs, rowNum) -> {
        Hotel hotel = new Hotel();
        hotel.setId(rs.getInt("id"));
        hotel.setName(rs.getString("name"));
        hotel.setLocation(rs.getString("location"));
        hotel.setDescription(rs.getString("description"));
        return hotel;
    });

    public Responses createRoom(Room room) {
        Responses responses = new Responses();
        try {
            String sql = "INSERT INTO rooms(name,room_number,availability,type,price,hotel_id) VALUES (?,?,?,?,?,?)";
            int row = jdbcTemplate.update(sql,room.getName(),room.getRoom_number(),room.isAvailability(),room.getType().toUpperCase(),room.getPrice(),room.getHotel_id());
            if (row == 0){
                responses.setResponse("mainMessage", new Message("There is some problem in creating room ", false));
                return responses;
            }
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

            String sql = "SELECT * FROM rooms";

            List<Room> roomList = jdbcTemplate.query(sql,rowMapperRoom);

            if (roomList.get(0) == null){
                responses.setResponse("mainMessage",new Message("there is problem and no room in the DataBase",false));
                return responses;
            }
                for (Room room : roomList){
                    int id = room.getHotel_id();
                    String sqlroom = "SELECT * FROM hotels WHERE id = ?";
                    Hotel hotel = jdbcTemplate.queryForObject(sqlroom, rowMapperHotel, id);
                    if (hotel != null){
                        room.setHotelDetails(hotel);
                    }
                }
                responses.setResponse("mainMessage",new Message("All Rooms successfully fetched",true));
                responses.setResponse("Data",roomList);
                return responses;
        } catch (Exception e) {
            responses.setResponse("mainMessage",new Message("there is error in getting rooms " + e,false));
            return responses;
        }


    }

    public Responses getById(int id){
        Responses responses = new Responses();
        try {

            String sql = "SELECT * FROM rooms WHERE id = ?";
            Room room = jdbcTemplate.queryForObject(sql,rowMapperRoom,id);
            if (room == null){
                responses.setResponse("mainMessage",new Message("THERE IS ERROR IN GETTING ROOM AND NO ROOM FOUND",false));
                return responses;
            }
            Hotel hotel = jdbcTemplate.queryForObject("SELECT * FROM hotels WHERE id = ?",rowMapperHotel,room.getHotel_id());
            if (hotel != null ){
                room.setHotelDetails(hotel);
            }
            responses.setResponse("mainMessage",new Message("GETTING ROOM SUCCESSFUL",true));
            responses.setResponse("Data",room);
            return responses;
        } catch (Exception e) {
            responses.setResponse("mainMessage",new Message("THERE IS ERROR IN GETTING ROOM " + e,false));
            return responses;
        }

    }

    public Responses deleteRoom(int id){
        Responses responses = new Responses();
        try {

        } catch (Exception e) {
            responses.setResponse("mainMessage",new Message("THERE IS ERROR IN DELETING ROOM " + e,false));
            return responses;
        }

    }

}
