package org.umair.hotel_mangement_system_in_spring_boot.services;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.umair.hotel_mangement_system_in_spring_boot.models.Customer;
import org.umair.hotel_mangement_system_in_spring_boot.repositories.CustomerRepository;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Message;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Responses;

import java.util.Date;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    public Responses createCustomer(Customer customer){

        try {
            Responses responses = new Responses();
            Customer customer1 = customerRepository.save(customer);
            if (customer1 == null){
                throw new Exception("There is not enough data to make a customer.");
            }
            responses.setResponse("Data",customer1);
            responses.setResponse("mainMessage",new Message("Customer created",true));
            return responses;

        } catch (Exception e) {
            Responses response = new Responses();
            response.setResponse("mainMessage",new Message("Error occurred in the customer = " + e,false));
            return response;
        }

    }


    public Responses getAllCustomer(){

        try {
            Responses responses = new Responses();
            List<Customer> customerList = customerRepository.findAll();
            if (customerList.get(0) == null){
                throw new Exception("There is not any customer in database");
            }
            responses.setResponse("Data",customerList);
            responses.setResponse("mainMessage",new Message("All Customer found.",true));
            return responses;
        } catch (Exception e) {
            Responses response = new Responses();
            response.setResponse("mainMessage",new Message("Error occurred in the customer = " + e,false));
            return response;
        }

    }

    public Responses getCustomerById(int id){

        try {
            Responses responses = new Responses();
            Customer customer = customerRepository.findById(id);
            if (customer == null){
                throw new Exception("No customer found for this id");
            }
            responses.setResponse("Data",customer);
            responses.setResponse("mainMessage",new Message("Customer founded",true));
            return responses;
        } catch (Exception e) {
            Responses response = new Responses();
            response.setResponse("mainMessage",new Message("Error occurred in the customer = " + e,false));
            return response;
        }

    }

    public Responses deleteCustomer(int id){

        try {
            Responses responses = new Responses();
            Customer customer = customerRepository.findById(id);
            if (customer == null){
                throw new Exception("There is no customer with this id.");
            }
            customerRepository.delete(customer);
            responses.setResponse("mainMessage",new Message("Customer Deleted",true));
            return responses;
        } catch (Exception e) {
            Responses response = new Responses();
            response.setResponse("mainMessage",new Message("Error occurred in the customer = " + e,false));
            return response;
        }

    }

}
