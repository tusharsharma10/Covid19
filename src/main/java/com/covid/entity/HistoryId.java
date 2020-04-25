package com.covid.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class HistoryId implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Column(name="Country")
	private String country;
	
	@Column(name="Date")
	private Date day;

	public HistoryId() {
		
	}

	public HistoryId(String country, Date day) {
		super();
		this.country = country;
		this.day = day;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}
	
	
	
}
