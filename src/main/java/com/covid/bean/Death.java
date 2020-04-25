package com.covid.bean;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Death {

	@JsonProperty("new")
	int newDeaths;
	int total;
	
	
	public int getNewDeaths() {
		return newDeaths;
	}
	public void setNewDeaths(int newDeaths) {
		this.newDeaths = newDeaths;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
}
