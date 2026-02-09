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
        Hotel hotel1 = hotelRepository.save(hotel);
        responses.setResponse("Data",hotel1);
        responses.setResponse("mainMessage",new Message("Hotel created",true));
        return responses;
    }

    public Responses getHotel(int id) {
        Hotel hotel = hotelRepository.findById(id);
        responses.setResponse("mainMessage",new Message("Hotel found",true));
        return responses;
    }

    public Responses getAllHotels() {
        List<Hotel> hotelList = hotelRepository.findAll();
        responses.setResponse("mainMessage",new Message("Hotel found",true));
        return responses;
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
