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
}
