package com.covid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.entity.Country;
import com.covid.entity.StatisticsTable;
import com.covid.repository.CountryRepository;
import com.covid.repository.StatisticsRepository;

@Service
public class CovidDbService {

	@Autowired CountryRepository countryRepo;
	@Autowired StatisticsRepository statsRepo;
	
	public List<Country>fetchCountries(){
		
		return  countryRepo.findAll();
		
	}
	
	public List<StatisticsTable> fetchStats(){
		
		return statsRepo.findAll();
		
	}
	
	
	
}
