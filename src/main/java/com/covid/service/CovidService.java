package com.covid.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.covid.bean.Response;
import com.covid.bean.Statistics;
import com.covid.entity.HistoryId;
import com.covid.entity.HistoryTable;
import com.covid.entity.StatisticsTable;
import com.covid.repository.HistoryRepository;
import com.covid.repository.StatisticsRepository;

@Service
public class CovidService {

	@Autowired StatisticsRepository statsRepo;
	
	@Autowired HistoryRepository historyRepo;
	
	public void getDataFromApi() {
		
		Map<String,String> headerMap = new HashMap<>();
		headerMap.put("x-rapidapi-key", "cab47b4f38msh62fbf60c30377b2p10a242jsna2b61d764a2f");
		headerMap.put("x-rapidapi-host", "covid-193.p.rapidapi.com");
		
		RestTemplate template = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		//headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setAll(headerMap);

		HttpEntity<String> entity = new HttpEntity<>("body", headers);
		
		URI uri = null;
		
		try {
			 uri = new URI("https://covid-193.p.rapidapi.com/statistics");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		
		ResponseEntity<Statistics> s = template.exchange(uri, HttpMethod.GET,entity,Statistics.class);
		
		System.out.println();
		
		storeDataToDb(s.getBody().getResponse());
	}
	
	
	public void storeDataToDb(List<Response> respList) {
		
		
				
				
		
		
		for(Response r: respList) {
			
			
			HistoryTable statsTable = new HistoryTable();
			
			HistoryId id = new HistoryId();
			
			id.setCountry(r.getCountry());
			
			id.setDay(r.getDay());
			
			statsTable.setTotalCases(r.getCases().getTotal());
		
			statsTable.setNewCases(r.getCases().getNewCases());
			
			statsTable.setTotaldeaths(r.getDeaths().getTotal());
			
			statsTable.setNewdeaths(r.getDeaths().getNewDeaths());
			
			statsTable.setRecovered(r.getCases().getRecovered());
			
			statsTable.setActiveCases(r.getCases().getActive());
			
			statsTable.setCritical(r.getCases().getCritical());
			
			statsTable.setTotalTests(r.getTests().getTotal());
			
			
			historyRepo.save(statsTable);
		}
		
		
	
		
	}
	
	
	
}
