package com.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.covid.entity.StatisticsTable;

@Repository
@CrossOrigin("http://localhost:4200")
public interface StatisticsRepository extends JpaRepository<StatisticsTable, String> {

}
