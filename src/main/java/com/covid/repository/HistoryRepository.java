package com.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.covid.entity.HistoryId;
import com.covid.entity.HistoryTable;

public interface HistoryRepository  extends JpaRepository<HistoryTable, HistoryId>{

}
