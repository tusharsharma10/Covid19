package com.covid.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid.service.CovidService;

@RestController
public class CovidRestController {

	@Autowired CovidService covidService;
	
	@GetMapping("/getStats")
	public String getDataFromApi() {
		
		covidService.getStatisticsDataFromApi();
		
		return "checking...";
	}
	
	
	@GetMapping("/getHistory")
	public String getDataFromApiHistory() {
		
		covidService.getDataFromApiHistory();
		
		return "checking...";
	}
	
	
	@GetMapping("/getCountries")
	public String getCountries() {
		
		covidService.getCountriesImpl();
		
		return "getting";
	}
	
}
