package com.bringto.data.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.bringto.data.model.MqResult;
import com.bringto.data.repository.InspectionRepository;

@Service
public class InspectionService {
	@Autowired
	private InspectionRepository repository;
	@Autowired
	private JmsTemplate jmsTemplate;

	public void getInspecitonsResultsAndSendMqResults() {

		List<BigDecimal> idList = getIdFromInspections();

		if (CollectionUtils.isEmpty(idList)) {
			throw new RuntimeException("NÃO FORAM ENCONTRADAS INSPEÇÕES");
		}

		List<Integer> listInteger = new ArrayList<>();

		for (BigDecimal b : idList) {
			// tratamento de repetição
			if (!listInteger.contains(Integer.valueOf(b.toString()))) {
				listInteger.add(Integer.valueOf(b.toString()));
			}

		}

		for (int i = 0; i < listInteger.size(); i++) {
			System.out.println("ENCONTRADA INSPECAO: " + i);

			String mqResult = getMqResult(listInteger.get(i));

			if (null != mqResult) {

				String[] split = mqResult.split(",");

				MqResult result = new MqResult(split, listInteger.get(i));

				jmsTemplate.convertAndSend("Santander_data", result.toString());

			}
		}

	}

	private List<BigDecimal> getIdFromInspections() {
		List<BigDecimal> list = repository.findIdFromInspections();
		return list;
	}

	private String getMqResult(Integer id) {
		String result = repository.findByData2(id);
		return result;
	}
}
