package com.covid.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.covid.bean.Countries;
import com.covid.bean.Response;
import com.covid.bean.Statistics;
import com.covid.entity.Country;
import com.covid.entity.HistoryId;
import com.covid.entity.HistoryTable;
import com.covid.entity.StatisticsTable;
import com.covid.repository.CountryRepository;
import com.covid.repository.HistoryRepository;
import com.covid.repository.StatisticsRepository;

import javassist.expr.Instanceof;

@Service
public class CovidService {

	@Autowired
	StatisticsRepository statsRepo;

	@Autowired
	HistoryRepository historyRepo;

	@Autowired
	CountryRepository countryRepo;

	@Autowired
	CrudRequestService requestService;

	ParameterizedTypeReference<Countries> clazzCountry = new ParameterizedTypeReference<Countries>() {
	};

	ParameterizedTypeReference<Statistics> clazzStats = new ParameterizedTypeReference<Statistics>() {
	};

	public void getStatisticsDataFromApi() {

		URI uri = null;

		try {
			uri = new URI("https://covid-193.p.rapidapi.com/statistics");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		ResponseEntity<Statistics> stats = requestService.getRequest(uri, clazzStats);
		
		 storeDataToStatsTable(stats.getBody().getResponse());
		 
		 System.out.println("Data stored");
	}

	public void storeDataToStatsTable(List<Response> respList) {

		for (Response r : respList) {

			StatisticsTable statsTable = new StatisticsTable();

			statsTable.setCountry(r.getCountry());

			statsTable.setActiveCases(r.getCases().getActive());

			statsTable.setCritical(r.getCases().getCritical());

			statsTable.setDateTime(r.getDay());

			statsTable.setRecovered(r.getCases().getRecovered());

			statsTable.setTotalCases(r.getCases().getTotal());

			statsTable.setTotalTests(r.getTests().getTotal());

			statsTable.setTotaldeaths(r.getDeaths().getTotal());

			// new cases
			
			if(r.getCases().getNewCases() == null)
				statsTable.setNewCases(0);
			
			else {
				Integer newCases = specialCharRemover(r.getCases().getNewCases());
				statsTable.setNewCases(newCases);

			}
			
			// new deaths
			
			if(r.getDeaths().getNewDeaths() == null) {
				
				statsTable.setNewdeaths(0);
			}
			
			
			else {
				Integer newDeaths = specialCharRemover(r.getDeaths().getNewDeaths());
				statsTable.setNewdeaths(newDeaths);
			}
			
			

			statsRepo.save(statsTable);
		}

	}

	private Integer specialCharRemover(String s) {

		StringBuilder str = new StringBuilder(s);

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) < 48 || s.charAt(i) > 57)
				str.deleteCharAt(i);

		}

		return Integer.valueOf(str.toString());

	}

	
	
//	private <T> T nullHandler(T ob) {
//		
//		if(ob instanceof Integer) {
//			
//			return (T) new Integer(0);
//		}
//		
//		else  {
//			
//			return (T) "";
//		}
//		
//	}
	
	
	public void getDataFromApiHistory() {

		URI uri = null;

		List<String> countryList = new ArrayList<>();

		for (StatisticsTable srec : statsRepo.findAll()) {

			countryList.add(srec.getCountry());
		}

		Date d = new Date(120, 2, 22);

		List<String> dateList = new ArrayList<String>();
		// dateList.add("2020-03-22");
		// dateList.add("2020-03-23");
		dateList.add("2020-03-24");
		dateList.add("2020-03-25");
		dateList.add("2020-03-26");
		dateList.add("2020-03-27");
		dateList.add("2020-03-28");
		dateList.add("2020-03-29");
		dateList.add("2020-03-30");
		dateList.add("2020-03-31");

		for (String country : countryList) {

			for (String date : dateList) {

				if (!country.equalsIgnoreCase("All")) {
					try {
						uri = new URI("https://covid-193.p.rapidapi.com/history?day=" + date + "&country=" + country);
					} catch (URISyntaxException e) {
						e.printStackTrace();
					}

					ResponseEntity<Statistics> s = requestService.getRequest(uri, clazzStats);

					storeDataToHistoryTable(s.getBody().getResponse());

				}

			}

		}

		System.out.println("Done...");

	}

	public void storeDataToHistoryTable(List<Response> respList) {

		if (respList == null || respList.size() == 0) {

			return;

		}

		Response r = respList.get(0);

		HistoryTable statsTable = new HistoryTable();

		HistoryId id = new HistoryId();

		id.setCountry(r.getCountry());

		id.setDay(r.getDay());

		statsTable.setId(id);

		statsTable.setTotalCases(r.getCases().getTotal());

		statsTable.setTotaldeaths(r.getDeaths().getTotal());

		statsTable.setRecovered(r.getCases().getRecovered());

		statsTable.setActiveCases(r.getCases().getActive());

		statsTable.setCritical(r.getCases().getCritical());

		statsTable.setTotalTests(r.getTests().getTotal());

		HistoryId prevId = new HistoryId();
		prevId.setCountry(id.getCountry());

		int dateChange = id.getDay().getDate() - 1;

		Date prevDate = new Date(120, 02, dateChange);

		prevId.setDay(prevDate);

		Optional<HistoryTable> prevRecord = historyRepo.findById(prevId);

		if (prevRecord.isPresent()) {
			Integer newCases = r.getCases().getTotal() - prevRecord.get().getTotalCases();

			Integer newDeaths = r.getDeaths().getTotal() - prevRecord.get().getTotaldeaths();

			statsTable.setNewCases(newCases);

			statsTable.setNewdeaths(newDeaths);
		}

		else {
			statsTable.setNewCases(0);

			statsTable.setNewdeaths(0);

		}

		historyRepo.save(statsTable);

	}

	public void getCountriesImpl() {

		URI uri = null;

		try {
			uri = new URI("https://covid-193.p.rapidapi.com/countries");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		ResponseEntity<Countries> s = requestService.getRequest(uri, clazzCountry);

		for (String x : s.getBody().getResponse()) {
			Country c = new Country();

			c.setCountry(x);
			countryRepo.save(c);

		}

		System.out.println("Data stored");

	}

}
