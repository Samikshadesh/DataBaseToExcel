package com.Hcc.ExportToExcel.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
public class Address {
	private String country;
	private String state;
	private String city;
	private String address;
	
	
	public Address(String country, String state, String city, String address) {
		super();
		this.country = country;
		this.state = state;
		this.city = city;
		this.address = address;
	}
	
	
	public Address() {
		super();
	}
	


	@Override
	public String toString() {
		return "Address [country=" + country + ", state=" + state + ", city=" + city + ", address=" + address + "]";
	}


	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
