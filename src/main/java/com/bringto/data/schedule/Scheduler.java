package com.bringto.data.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bringto.data.service.InspectionService;

@EnableScheduling
@Component
public class Scheduler {
	@Autowired
	private InspectionService service;

	@Scheduled(cron = "30 * * * * *")
	public void getInspectionsByTimeScheduler() {
		service.getInspecitonsResultsAndSendMqResults();
	}
	
	/*
	 * limpeza do cache às 03:01:10 do dia 17 de cada mês
	 */
	@Scheduled(cron = "10 01 03 17 * *")
	public void clearCashList() {
		service.clearlists();
	}
}
