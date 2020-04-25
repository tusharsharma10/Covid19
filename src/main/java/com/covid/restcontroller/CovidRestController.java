package com.covid.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid.service.CovidService;

@RestController
public class CovidRestController {

	@Autowired CovidService covidService;
	
	@GetMapping("/get")
	public String getDataFromApi() {
		
		covidService.getDataFromApi();
		
		return "checking...";
	}
	
	
}
