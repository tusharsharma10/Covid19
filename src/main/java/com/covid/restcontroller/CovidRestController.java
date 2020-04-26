package com.covid.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid.entity.Country;
import com.covid.entity.StatisticsTable;
import com.covid.service.CovidApiService;
import com.covid.service.CovidDbService;

@RestController
public class CovidRestController {

	@Autowired CovidApiService covidApiService;
	
	@Autowired CovidDbService covidDbService;
	
	/**
	 * Api controllers
	 * @return
	 */
	
	@GetMapping("/stats/api")
	public String getDataFromApi() {
		
		covidApiService.getStatisticsDataFromApi();
		
		return "checking...";
	}
	
	
	@GetMapping("/history/api")
	public String getDataFromApiHistory() {
		
		covidApiService.getDataFromApiHistory();
		
		return "checking...";
	}
	
	
	@GetMapping("/countries/api")
	public String getCountries() {
		
		covidApiService.getCountriesImpl();
		
		return "getting";
	}
	
	
	/**
	 * Db controllers
	 * @return
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/countries/db")
	public List<Country> getCountriesFromDb() {
		
		return covidDbService.fetchCountries();
		
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/stats/db")
	public List<StatisticsTable> getStatsFromDb() {
		
		return covidDbService.fetchStats();
		
		
	}
	
	
}
