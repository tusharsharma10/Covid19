package com.covid.bean;

import java.util.List;

public class Statistics {

	int results;
	
	List<Response> response;

	public Statistics() {
		
	}
	
	
	
	public Statistics(int results, List<Response> response) {
		this.results = results;
		this.response = response;
	}



	public List<Response> getResponse() {
		return response;
	}

	public void setResponse(List<Response> response) {
		this.response = response;
	}

	

	

	public int getResults() {
		return results;
	}

	public void setResults(int results) {
		this.results = results;
	}
	
	
	
	
	
	
}
