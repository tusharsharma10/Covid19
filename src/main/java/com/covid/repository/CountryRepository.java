 package com.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.covid.entity.Country;

public interface CountryRepository extends JpaRepository<Country, String> {

}
