 package com.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.covid.entity.Country;

@Repository
//@CrossOrigin(origins = "http://localhost:4200")
public interface CountryRepository extends JpaRepository<Country, String> {

}
