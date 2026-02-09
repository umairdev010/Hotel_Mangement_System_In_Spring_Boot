package org.umair.hotel_mangement_system_in_spring_boot.services;

import org.springframework.stereotype.Service;
import org.umair.hotel_mangement_system_in_spring_boot.models.Hotel;
import org.umair.hotel_mangement_system_in_spring_boot.repositories.HotelRepository;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Message;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Responses;

import java.util.List;

@Service
public class HotelService {

    Responses responses = new Responses();

    private HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Responses createHotel(Hotel hotel) {

       try {
           Hotel hotel1 = hotelRepository.save(hotel);
           responses.setResponse("Data",hotel1);
           responses.setResponse("mainMessage",new Message("Hotel created",true));
           return responses;
       } catch (Exception e) {
           responses.setResponse("mainMessage",new Message("Error in creating hotel  = " + e,false));
           return responses;
       }

    }

    public Responses getHotel(int id) {

       try {
           Hotel hotel = hotelRepository.findById(id);
           if (hotel == null) throw new Exception("There is no hotel found by this id");
           responses.setResponse("Data",hotel);
           responses.setResponse("mainMessage",new Message("Hotel found",true));
           return responses;
       } catch (Exception e) {
           responses.setResponse("mainMessage",new Message("Error in getting hotel  = " + e,false));
           return responses;
       }

    }

    public Responses getAllHotels() {

        try {
            List<Hotel> hotelList = hotelRepository.findAll();
            if (hotelList.get(0) == null) throw  new Exception("There is  nothing in the table to get");
            responses.setResponse("mainMessage",new Message("All Hotels found",true));
            responses.setResponse("Data",hotelList);
            return responses;
        } catch (Exception e) {
            responses.setResponse("mainMessage",new Message("Error in getting all hotels  = " + e,false));
            return responses;
        }

    }

    public Responses getHotelByName(String name){
        responses.setResponse("mainMessage",new Message("Hotel found",true));
        return responses;
    }

    public Responses deleteHotel(int id){
        responses.setResponse("mainMessage",new Message("Hotel found",true));
        return responses;
    }

}
