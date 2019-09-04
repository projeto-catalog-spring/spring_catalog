package br.com.compasso.miniecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.miniecommerce.models.Customer;
import br.com.compasso.miniecommerce.models.CustomerRepository;

@RestController
public class HelloWorld {

	@Autowired
	private CustomerRepository customer;
	
	@GetMapping("/")
	public String helloWorld()
	{
		//Customer c = new Customer("Rafael", "Romeu");
		//customer.save(c);
		
		Iterable<Customer> c1 = customer.findAll();
		
		System.out.println(c1);
		
		return "Hello World";
	}
}
