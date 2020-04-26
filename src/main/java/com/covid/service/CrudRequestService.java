package com.covid.service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CrudRequestService {

	 RestTemplate template;
	
	
	
	public CrudRequestService() {
	}



	public CrudRequestService(RestTemplate template) {
		this.template = template;
	}



	public RestTemplate getTemplate() {
		return template;
	}



	public void setTemplate(RestTemplate template) {
		this.template = template;
	}



	/*
	 * Ideal choice using ParameterizedTypeReference
	 */
	
	public <T> ResponseEntity<T> getRequest(URI uri, ParameterizedTypeReference<T> clazz) {
		
		Map<String,String> headerMap = new HashMap<>();
		headerMap.put("x-rapidapi-key", "cab47b4f38msh62fbf60c30377b2p10a242jsna2b61d764a2f");
		headerMap.put("x-rapidapi-host", "covid-193.p.rapidapi.com");
		
		
		
		HttpHeaders headers = new HttpHeaders();
		//headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setAll(headerMap);

		HttpEntity<String> entity = new HttpEntity<>("body", headers);
		
		if(template == null)
			template = new RestTemplate();
		
		
		ResponseEntity<T> resEntity =  template.exchange(uri, HttpMethod.GET,entity,clazz);
		
		return resEntity;
		
	}
	
	
	/*
	 * Method works but proper serialization doesn't happen.
	 * Every json object will be in form of Object class
	 */
	
	public <T> ResponseEntity<T> getRequest2(URI uri) {
		
		Map<String,String> headerMap = new HashMap<>();
		headerMap.put("x-rapidapi-key", "cab47b4f38msh62fbf60c30377b2p10a242jsna2b61d764a2f");
		headerMap.put("x-rapidapi-host", "covid-193.p.rapidapi.com");
		
		
		
		HttpHeaders headers = new HttpHeaders();
		//headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setAll(headerMap);

		HttpEntity<String> entity = new HttpEntity<>("body", headers);
		
		if(template == null)
			template = new RestTemplate();
		
		
		ResponseEntity<T> resEntity =  (ResponseEntity<T>) template.exchange(uri, HttpMethod.GET,entity,Object.class);
		
		return resEntity;
		
	}
	
	
}
