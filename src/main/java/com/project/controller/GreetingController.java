package com.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.entity.Customer;
import com.project.entity.CustomerRepository;

import io.swagger.annotations.ApiOperation;

@Controller
public class GreetingController {
	
	private static final Logger log = LoggerFactory.getLogger(GreetingController.class);
	
	@Autowired
	CustomerRepository repository;
    
	
	@RequestMapping(method = RequestMethod.GET, value = "/sba/greeting")
	@ApiOperation(value = "insert a customer into database", nickname = "add customer")
	@ResponseBody
    public String greeting(@RequestParam(value = "firstName", required = true, defaultValue = "Srikanth") String fName, @RequestParam(value = "lastName", required = true, defaultValue = "Akula") String lastName,
    Model model) {
	    //model.addAttribute("name", Name);
	    System.out.println("FirstName :"+ fName);
	    System.out.println("LastName :"+ lastName);
	    log.info("In Greeting");
	    repository.save(new Customer("Jack", "Bauer"));
		repository.save(new Customer("Chloe", "O'Brian"));
		repository.save(new Customer("Kim", "Bauer"));
		repository.save(new Customer("David", "Palmer"));
		repository.save(new Customer("Michelle", "Dessler"));
		repository.save(new Customer("Sreekanth", "Akula"));
		repository.save(new Customer("Kiran", "Akula"));
		repository.save(new Customer(fName , lastName ));
		
		
		
		
		// fetch all customers
		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer.toString());
		}
		
		
		return repository.findByFirstName("Sreekanth").toString();
    }
	 

}
