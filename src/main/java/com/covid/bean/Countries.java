package com.covid.bean;

import java.util.List;

public class Countries {

	List<String> response;

	
	
	public Countries() {
	}

	
	
	public Countries(List<String> response) {
		this.response = response;
	}



	public List<String> getResponse() {
		return response;
	}

	public void setResponse(List<String> response) {
		this.response = response;
	}
	
	
}
