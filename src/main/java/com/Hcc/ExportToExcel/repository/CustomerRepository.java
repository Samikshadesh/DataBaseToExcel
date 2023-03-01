package com.Hcc.ExportToExcel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Hcc.ExportToExcel.entity.Customer;

//import org.springframework.data.jpa.repository.jpaRepository;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>   {

}
