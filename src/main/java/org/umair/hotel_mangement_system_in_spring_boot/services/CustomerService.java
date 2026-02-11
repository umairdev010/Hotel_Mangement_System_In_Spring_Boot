package org.umair.hotel_mangement_system_in_spring_boot.services;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.umair.hotel_mangement_system_in_spring_boot.models.Customer;
import org.umair.hotel_mangement_system_in_spring_boot.repositories.CustomerRepository;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Message;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Responses;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    public Responses createCustomer(Customer customer){

        try {
            Responses responses = new Responses();


        } catch (Exception e) {
            Responses response = new Responses();
            response.setResponse("mainMessage",new Message("Error occurred in the customer = " + e,false));
            return response;
        }

    }

}
