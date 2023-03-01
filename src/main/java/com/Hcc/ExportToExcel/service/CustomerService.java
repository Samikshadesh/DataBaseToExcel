package com.Hcc.ExportToExcel.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hcc.ExportToExcel.entity.Customer;
import com.Hcc.ExportToExcel.repository.CustomerRepository;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer>exportCustomerToExcel(HttpServletResponse response) throws IOException
	{
		List<Customer>customers = customerRepository.findAll();
		ExcelExportUtils exportUtils = new ExcelExportUtils(customers);
		exportUtils.exportDataToExcel(response);
		return customers;
	
	}

}
