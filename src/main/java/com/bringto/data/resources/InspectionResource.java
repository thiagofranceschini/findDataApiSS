package com.bringto.data.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bringto.data.service.ActiveMqReceiverService;
import com.bringto.data.service.InspectionService;

@RestController
@RequestMapping(value = "/inspections")
public class InspectionResource {
	@Autowired
	private InspectionService service;
	@Autowired
	private ActiveMqReceiverService mqService;

	/*
	 * método abaixo apenas para teste populando fila
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/populate")
	public ResponseEntity<?> startProcess() {
		service.getInspecitonsResultsAndSendMqResults();
		return ResponseEntity.ok().body("INJETADOS NA FILA!");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<String>> getMqResults() {
		List<String> resultText = mqService.getMqResultText();

		List<String> list2 = new ArrayList<>();
		if (!CollectionUtils.isEmpty(resultText)) {
			for (String s : resultText) {
				list2.add(s);
			}
		}

		mqService.clearList();
		return ResponseEntity.ok().body(list2);
	}

}
