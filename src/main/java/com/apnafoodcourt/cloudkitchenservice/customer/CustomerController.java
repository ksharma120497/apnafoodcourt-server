package com.apnafoodcourt.cloudkitchenservice.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(value="/getAllCustomerData",method = RequestMethod.GET)
    public List<Customer> getAllCustomerData(){
        List<Customer> list= customerRepository.findAll();
        for(Customer c:list){
            System.out.println(c.getName()+"==");
        }
        return customerRepository.findAll();
    }

    @RequestMapping(value="/addCustomer",method = RequestMethod.POST, headers = "Accept=application/json" )
    public Customer saveCustomer(@RequestBody Map<String,String> body){
        Customer customer = new Customer();
        customer.setName(body.get("name"));
        customer.setPassword(body.get("password"));
        customer.setPhoneNumber(body.get("phoneNumber"));
        customer.setOfficeName(body.get("officeName"));
        customer.setOfficeAddress(body.get("officeAddress"));
        return customerRepository.save(customer);
    }

    @RequestMapping(value="/loginDetails",method = RequestMethod.POST )
    public Customer loginDetails(@RequestBody Map<String,String> body){
        Customer customer = customerRepository.findByPhoneNumber(body.get("phoneNumber"));
        System.out.println(customer.getPassword());
        return customer;
    }

}
