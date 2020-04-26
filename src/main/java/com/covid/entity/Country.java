package com.covid.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Country")
public class Country {

	@Id
	String Country;

	public Country() {
	}

	public Country(String country) {
		Country = country;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}
	
	
	
}
