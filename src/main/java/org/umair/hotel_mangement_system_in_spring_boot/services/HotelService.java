package org.umair.hotel_mangement_system_in_spring_boot.services;

import org.springframework.stereotype.Service;
import org.umair.hotel_mangement_system_in_spring_boot.models.Hotel;
import org.umair.hotel_mangement_system_in_spring_boot.repositories.HotelRepository;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Message;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Responses;

@Service
public class HotelService {

    private HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Message createHotel(Hotel hotel) {
        return hotelRepository.createHotel(hotel);
    }

    public Responses getHotel(int id) {
        return hotelRepository.getHotel(id);
    }

    public Responses getAllHotels() {
        return hotelRepository.getAllHotels();
    }

    public Responses getHotelByName(String name){
        return hotelRepository.getHotelByName(name);
    }

    public Responses deleteHotel(int id){
        return hotelRepository.deleteHotel(id);
    }

}
