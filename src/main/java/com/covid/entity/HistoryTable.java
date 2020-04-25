package com.covid.entity;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="History_Stats")
public class HistoryTable {

	
	@EmbeddedId
	private HistoryId id;
	
	
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
	
	

	public HistoryTable() {}

	

	public HistoryTable(HistoryId id, Integer totalCases, Integer newCases, Integer totaldeaths, Integer newdeaths,
			Integer recovered, Integer activeCases, Integer critical, Integer totalTests) {
		super();
		this.id = id;
		this.totalCases = totalCases;
		this.newCases = newCases;
		this.totaldeaths = totaldeaths;
		this.newdeaths = newdeaths;
		this.recovered = recovered;
		this.activeCases = activeCases;
		this.critical = critical;
		this.totalTests = totalTests;
	}



	

	public HistoryId getId() {
		return id;
	}



	public void setId(HistoryId id) {
		this.id = id;
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

	
	
}
