package org.umair.hotel_mangement_system_in_spring_boot.services;

import org.springframework.stereotype.Service;
import org.umair.hotel_mangement_system_in_spring_boot.models.Hotel;
import org.umair.hotel_mangement_system_in_spring_boot.repositories.HotelRepository;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Message;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Responses;

import java.util.List;

@Service
public class HotelService {

    private HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Responses createHotel(Hotel hotel) {

       try {
           Responses responses = new Responses();
           Hotel hotel1 = hotelRepository.save(hotel);
           responses.setResponse("Data",hotel1);
           responses.setResponse("mainMessage",new Message("Hotel created",true));
           return responses;
       } catch (Exception e) {
           Responses responses = new Responses();
           responses.setResponse("mainMessage",new Message("Error in creating hotel  = " + e,false));
           return responses;
       }

    }

    public Responses getHotel(int id) {

       try {
           Responses responses = new Responses();
           Hotel hotel = hotelRepository.findById(id);
           if (hotel == null) throw new Exception("There is no hotel found by this id");
           responses.setResponse("Data",hotel);
           responses.setResponse("mainMessage",new Message("Hotel found",true));
           return responses;
       } catch (Exception e) {
           Responses responses = new Responses();
           responses.setResponse("mainMessage",new Message("Error in getting hotel  = " + e,false));
           return responses;
       }

    }

    public Responses getAllHotels() {

        try {
            Responses responses = new Responses();
            List<Hotel> hotelList = hotelRepository.findAll();
            if (hotelList.get(0) == null) throw  new Exception("There is  nothing in the table to get");
            responses.setResponse("mainMessage",new Message("All Hotels found",true));
            responses.setResponse("Data",hotelList);
            return responses;
        } catch (Exception e) {
            Responses responses = new Responses();
            responses.setResponse("mainMessage",new Message("Error in getting all hotels  = " + e,false));
            return responses;
        }

    }

    public Responses getHotelByName(String name){

        try {
            Responses responses = new Responses();
            List<Hotel> hotelList = hotelRepository.findByName(name);
            if (hotelList.get(0) == null) throw new Exception("There is no hotel with this name");
            responses.setResponse("mainMessage",new Message("Hotel found",true));
            responses.setResponse("Data",hotelList);
            return responses;
        } catch (Exception e) {
            Responses newRes = new Responses();
            newRes.setResponse("mainMessage",new Message("Error in getting hotel  = " + e,false));
            return newRes;
        }

    }

    public Responses deleteHotel(int id){

        try {
            Responses responses1 = new Responses();
            Hotel hotel = new Hotel();
            hotel.setId(id);
            Hotel hotel1 = hotelRepository.findById(id);
            if (hotel1 == null) throw new Exception("There is error in deleting and no hotel found ecxception");
            hotelRepository.delete(hotel);
            responses1.setResponse("mainMessage",new Message("Hotel Deleted",true));
            return responses1;
        } catch (Exception e) {
            Responses responses1 = new Responses();
            responses1.setResponse("mainMessage",new Message("Error in Deleting hotel  = " + e,false));
            return responses1;
        }

    }

}
