package com.Hcc.ExportToExcel.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Hcc.ExportToExcel.entity.Address;
import com.Hcc.ExportToExcel.entity.Customer;
import com.Hcc.ExportToExcel.repository.CustomerRepository;

import jakarta.annotation.PostConstruct;

@Component
public class SeedData {
	@Autowired
	private CustomerRepository customerRepository;
	
	public SeedData(CustomerRepository customerRepository)
	{
		this.customerRepository=customerRepository;
		
	}
	private List<Customer>customers=Arrays.asList(
			new Customer("Samiksha" ,"Deshmukh","sam@gmail.com",new Address("India","Maharashtra","Satara","A/P vaduj")),
			new Customer("Pratiksha" ,"Deshmukh","Pratiksha@gmail.com",new Address("India","Maharashtra","Satara","A/P vaduj")),
			
			new Customer("Shwetal" ,"Bhosale","shwetal@gmail.com",new Address("India","Maharashtra","Pune","A/P Baramati")),
			
			new Customer("Rajveer" ,"Chavan","sam@gmail.com",new Address("India","Maharashtra","Satara","A/P Baramati")),
			
			new Customer("Prathmesh" ,"Deshmukh","Pratham@gmail.com",new Address("India","Maharashtra","Satara","A/P Baramati")),
			
			new Customer("ShauryaVeer" ,"Chavan","Parth@gmail.com",new Address("India","Maharashtra","Pune","A/P Baramati")),
			
			new Customer("pratik" ,"Dhumal","pratik@gmail.com",new Address("India","Maharashtra","Pune","A/P Baramati")),
			
			new Customer("Harshali" ,"Bhosale","Harshali@gmail.com",new Address("India","Maharashtra","Pune","A/P Baramati"))
			
			);
	@PostConstruct
	public void saveCustomer()
	{
		customerRepository.saveAll(customers);
	}

}
