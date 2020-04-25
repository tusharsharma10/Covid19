package com.covid.entity;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Statistics")
public class StatisticsTable {

	
	@Id
	@Column(name="country")
	private String country;
	
	
	@Column(name="Total_Cases")
	private Integer totalCases;
	
	@Column(name="New_Cases")
	private Integer newCases;
	
	
	@Column(name="Total_Deaths")
	private Integer totaldeaths;
	
	@Column(name="New_Deaths")
	private Integer newdeaths;
	
	@Column(name="Recovered")
	private Integer recovered;
	
	@Column(name="Active_Cases")
	private Integer activeCases;
	
	@Column(name="Critical_Cases")
	private Integer critical;
	
	@Column(name="Total_Tests")
	private Integer totalTests;
	
	@Column(name="Day")
	private Date dateTime;

	
	public StatisticsTable() {}


	public StatisticsTable(String country, Integer totalCases, Integer newCases, Integer totaldeaths, Integer newdeaths,
			Integer recovered, Integer activeCases, Integer critical, Integer totalTests, Date dateTime) {
		super();
		this.country = country;
		this.totalCases = totalCases;
		this.newCases = newCases;
		this.totaldeaths = totaldeaths;
		this.newdeaths = newdeaths;
		this.recovered = recovered;
		this.activeCases = activeCases;
		this.critical = critical;
		this.totalTests = totalTests;
		this.dateTime = dateTime;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public Integer getTotalCases() {
		return totalCases;
	}


	public void setTotalCases(Integer totalCases) {
		this.totalCases = totalCases;
	}


	public Integer getNewCases() {
		return newCases;
	}


	public void setNewCases(Integer newCases) {
		this.newCases = newCases;
	}


	public Integer getTotaldeaths() {
		return totaldeaths;
	}


	public void setTotaldeaths(Integer totaldeaths) {
		this.totaldeaths = totaldeaths;
	}


	public Integer getNewdeaths() {
		return newdeaths;
	}


	public void setNewdeaths(Integer newdeaths) {
		this.newdeaths = newdeaths;
	}


	public Integer getRecovered() {
		return recovered;
	}


	public void setRecovered(Integer recovered) {
		this.recovered = recovered;
	}


	public Integer getActiveCases() {
		return activeCases;
	}


	public void setActiveCases(Integer activeCases) {
		this.activeCases = activeCases;
	}


	public Integer getCritical() {
		return critical;
	}


	public void setCritical(Integer critical) {
		this.critical = critical;
	}


	public Integer getTotalTests() {
		return totalTests;
	}


	public void setTotalTests(Integer totalTests) {
		this.totalTests = totalTests;
	}


	public Date getDateTime() {
		return dateTime;
	}


	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}


	
	
	
	
}
