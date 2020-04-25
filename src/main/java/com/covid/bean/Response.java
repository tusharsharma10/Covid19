package com.covid.bean;

import java.sql.Date;

public class Response {

	private String country;
	
	private Cases cases;
	
	private Death deaths;
	
	Test tests;
	
	Date day;
	
	Date time;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Cases getCases() {
		return cases;
	}

	public void setCases(Cases cases) {
		this.cases = cases;
	}

	public Death getDeaths() {
		return deaths;
	}

	public void setDeaths(Death deaths) {
		this.deaths = deaths;
	}

	

	public Test getTests() {
		return tests;
	}

	public void setTests(Test tests) {
		this.tests = tests;
	}

	

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
