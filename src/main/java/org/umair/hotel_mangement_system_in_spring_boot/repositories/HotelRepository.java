package org.umair.hotel_mangement_system_in_spring_boot.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.umair.hotel_mangement_system_in_spring_boot.models.Hotel;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Message;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Responses;

import java.util.List;

@Repository
public class HotelRepository {

    private JdbcTemplate jdbcTemplate;

    public HotelRepository(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;

    }

    RowMapper<Hotel> rowMapper = ((rs, rowNum) -> {
        Hotel hotel = new Hotel();
        hotel.setId(rs.getInt("id"));
        hotel.setName(rs.getString("name"));
        hotel.setLocation(rs.getString("location"));
        hotel.setDescription(rs.getString("description"));
        return hotel;
    });

    public Message createHotel(Hotel hotel) {

        try {
            String sql = "INSERT INTO hotels(name,location,description) VALUES (?,?,?)";
            int row = jdbcTemplate.update(sql, hotel.getName(), hotel.getLocation(), hotel.getDescription());
            if (row == 1) {
                return new Message("The hotel is successfully created", true);
            } else {
                return new Message("The hotel is not created kindly try again", false);
            }
        } catch (Exception e) {
            return new Message("Error occured in creating hotel as " + e.getMessage(), false);
        }

    }

    public Responses getHotel(int id) {
        try {
            String sql = "SELECT * FROM hotels WHERE id = ?";
            Hotel hotel = jdbcTemplate.queryForObject(sql, rowMapper, id);
            Responses responses = new Responses();
            if (hotel == null) {
                responses.setResponse("mainMessage", new Message("Error is occured while getting hotel", false));
                return responses;
            } else {
                responses.setResponse("mainMessage", new Message("User is get successfully", true));
                responses.setResponse("data",hotel);
                return responses;
            }
        } catch (Exception e) {
            Responses responses = new Responses();
            responses.setResponse("mainMessage", new Message("Error is occured while getting hotel" + e, false));
            return responses;
        }

    }

    public Responses getAllHotels(){
        Responses responses = new Responses();
        try {
            String sql = "SELECT * FROM hotels";
            List<Hotel> hotelList = jdbcTemplate.query(sql,rowMapper);
            if (hotelList.get(0) == null){
                responses.setResponse("mainMessage",new Message("There is error in getting hotels and either it is empty",false));
                return responses;
            } else {
                responses.setResponse("mainMessage",new Message("Data of all is Hotels is successfully fetched",true));
                responses.setResponse("Data",hotelList);
                return responses;
            }
        } catch (Exception e) {
            responses.setResponse("mainMessage",new Message(e.getMessage(), false));
            return responses;
        }
    }

    public Responses getHotelByName(String name){
        Responses responses = new Responses();
        try {

            String sql = "SELECT * FROM hotels WHERE name = ?";
            List<Hotel> hotels = jdbcTemplate.query(sql,rowMapper,name);
            if (hotels.get(0) == null){
                responses.setResponse("mainMessage",new Message("There is no hotel in dataBase with name " + name,false));
                return responses;
            }
            responses.setResponse("mainMessage",new Message("Hotel get successfully",true));
            responses.setResponse("Data",hotels);
            return responses;

        } catch (Exception e) {
            responses.setResponse("mainMessage",new Message(e.getMessage(), false));
            return responses;
        }
    }

}
