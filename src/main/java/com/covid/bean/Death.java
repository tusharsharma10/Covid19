package com.covid.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Death {

	@JsonProperty("new")
	String newDeaths;
	
	
	public String getNewDeaths() {
		return newDeaths;
	}
	public void setNewDeaths(String newDeaths) {
		this.newDeaths = newDeaths;
	}
	int total;
	
	
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
}
