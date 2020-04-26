package com.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.covid.entity.HistoryId;
import com.covid.entity.HistoryTable;

@Repository
@CrossOrigin("http://localhost:4200")
public interface HistoryRepository  extends JpaRepository<HistoryTable, HistoryId>{

}
