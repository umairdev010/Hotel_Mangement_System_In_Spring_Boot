package org.umair.hotel_mangement_system_in_spring_boot.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.umair.hotel_mangement_system_in_spring_boot.models.Customer;
import org.umair.hotel_mangement_system_in_spring_boot.services.CustomerService;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Message;
import org.umair.hotel_mangement_system_in_spring_boot.utility.Responses;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<Responses> createCustomer(@RequestBody Customer customer){

        Responses responses = customerService.createCustomer(customer);
        return parseResponse(responses);
    }

    @GetMapping
    public ResponseEntity<Responses>  getAllCustomer(){
        Responses responses = customerService.getAllCustomer();
        return parseResponse(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Responses>  getByIdCustomer(@PathVariable int id){
        Responses responses = customerService.getCustomerById(id);
        return parseResponse(responses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Responses>  deleteCustomer(@PathVariable int id){
        Responses responses = customerService.deleteCustomer(id);
        return parseResponse(responses);
    }


    public ResponseEntity<Responses> parseResponse(Responses responses){

        try {
            Message message = (Message) responses.getData("mainMessage");
            if (!message.isSuccess()){
                return new ResponseEntity<>(responses, HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(responses,HttpStatus.OK);
        } catch (Exception e) {
            Responses responses1 = new Responses();
            responses1.setResponse("Message",new Message("There is error in backend = " + e,false));
            return new ResponseEntity<>(responses1,HttpStatus.BAD_REQUEST);
        }

    }

}
