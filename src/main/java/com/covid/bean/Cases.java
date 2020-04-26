package com.covid.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cases {

	@JsonProperty("new")
	String newCases;
	int active;
	int critical;
	
	int recovered;
	public String getNewCases() {
		return newCases;
	}
	public void setNewCases(String newCases) {
		this.newCases = newCases;
	}
	int total;
	
	
	
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public int getCritical() {
		return critical;
	}
	public void setCritical(int critical) {
		this.critical = critical;
	}
	public int getRecovered() {
		return recovered;
	}
	public void setRecovered(int recovered) {
		this.recovered = recovered;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
	
}
