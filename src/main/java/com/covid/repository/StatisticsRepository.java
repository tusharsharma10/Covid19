package com.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.entity.StatisticsTable;

@Repository
public interface StatisticsRepository extends JpaRepository<StatisticsTable, String> {

}
