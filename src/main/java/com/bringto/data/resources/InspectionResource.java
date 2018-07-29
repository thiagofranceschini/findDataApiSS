package com.bringto.data.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	 * 2-entender se a consulta deve ou não ser paginada
	 * 3- e mais importante: configurar e testar o projeto rodando em um tomcat[internet , appseeing, ebookcdc]
	 * 4-verificar possibilidade de implementar exception personalizada em json
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> startProcess() {
		service.getInspecitonsResultsAndSendMqResults();
		return ResponseEntity.ok().body("INJETADOS NA FILA!");
	}

	@RequestMapping(method = RequestMethod.GET, value="/take")
	public ResponseEntity<List<String>>getMqResults(){
		return ResponseEntity.ok().body(mqService.getMqResultText());
	}

}
