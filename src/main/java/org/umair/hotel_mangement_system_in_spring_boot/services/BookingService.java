package org.umair.hotel_mangement_system_in_spring_boot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.umair.hotel_mangement_system_in_spring_boot.models.Booking;
import org.umair.hotel_mangement_system_in_spring_boot.repositories.BookingRepostory;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Message;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Responses;

@Service
public class BookingService {

    @Autowired
    public BookingRepostory bookingRepostory;

    public Responses createBooking(Booking booking){

        try {
            Responses responses = new Responses();
            Booking booking1 = bookingRepostory.save(booking);
            if (booking1 == null){
                throw new Exception("There is some error occurred while saving booking.");
            }
            responses.setResponse("Data",booking1);
            responses.setResponse("mainMessage",new Message("Booking created",true));
            return responses;
        } catch (Exception e) {
            Responses responses = new Responses();
            responses.setResponse("mainMessage",new Message("There is error in Booking = " + e,false));
            return responses;
        }

    }

}
