package com.bringto.data.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.bringto.data.model.MqResult;
import com.bringto.data.repository.InspectionRepository;

/*
 * Classe de serviços recupera por meio de uma querie os ids das inspeções e dispara a function para cada inspeção;
 * Cria um cachlist (TempList) para verificar a duplicidade e não enviar um dado repetido para a view
 */
@Service
public class InspectionService {
	@Autowired
	private InspectionRepository repository;
	@Autowired
	private JmsTemplate jmsTemplate;

	private List<MqResult> tempList = new ArrayList<>();
	private List<MqResult> tempList2 = new ArrayList<>();
	private List<MqResult> listResult = new ArrayList<>();
	private Boolean isFirstTime = true;

	public void getInspecitonsResultsAndSendMqResults() {

		List<BigDecimal> idList = getIdFromInspections();

		if (CollectionUtils.isEmpty(idList)) {
			throw new RuntimeException("NÃO FORAM ENCONTRADAS INSPEÇÕES");
		}

		List<Integer> listInteger = new ArrayList<>();

		for (BigDecimal b : idList) {
			listInteger.add(Integer.valueOf(b.toString()));

		}

		for (int i = 0; i < listInteger.size(); i++) {
			String mqResult = getMqResult(listInteger.get(i));
			if (null != mqResult) {
				String[] split = mqResult.split(",");
				MqResult result = new MqResult(split, listInteger.get(i));
				listResult.add(result);
			}
		}

		listResult.addAll(createMock(5000));

		if (null != listResult) {

			for (int i = 0; i < listResult.size(); i++) {

				if (null == tempList || CollectionUtils.isEmpty(tempList)) {
					tempList.addAll(listResult);

				} else {

					if (!isFirstTime) {
						if (!containsId(listResult.get(i).getId(), tempList)) {
							tempList2.add(listResult.get(i));
						}

					} else {
						tempList2.addAll(tempList);
						System.out.println("*ACIONADO PELA PRIMEIRA VEZ!*");
						isFirstTime = false;
						break;
					}
				}

			}

		}

		List<String> list = new ArrayList<>();

		if (!CollectionUtils.isEmpty(tempList2)) {

			for (MqResult mq : tempList2) {

				list.add(mq.toString());
			}

			jmsTemplate.convertAndSend("Santander_data", list);
			tempList2.clear();
			list.clear();

		}
		listResult.clear();
	}

	private List<BigDecimal> getIdFromInspections() {
		List<BigDecimal> list = repository.findIdFromInspections();
		return list;
	}

	private String getMqResult(Integer id) {
		String result = repository.findByData2(id);
		return result;
	}

	public List<MqResult> getTempList() {
		return tempList;
	}

	public void setTempList(List<MqResult> tempList) {
		this.tempList = tempList;
	}

	public Boolean containsId(String id, List<MqResult> list) {
		for (MqResult mq : list) {
			if (id.equals(mq.getId())) {
				return true;
			}
		}
		return false;
	}

	public void clearlists() {
		tempList.clear();
		isFirstTime = true;

	}

	/*
	 * método para mock de inspeções comentar em produção assim como a linha nº55 e
	 * o método abaixo createMock()
	 */
	public MqResult mock() {
		MqResult mock = new MqResult();
		int nextInt = new Random().nextInt();
		mock.setId(String.valueOf(nextInt));
		mock.setSistema("xxxx");
		mock.setHorarioColeta("2018-06-21 11:31:32.043");
		mock.setStatus(11);
		mock.setStatusDescription("Atencao");
		mock.setConjuntoRobo("MockAcervo");
		mock.setStepFalha("falhadeautenticacao");
		mock.setTipoFalha(3);
		mock.setTipoFalhaDescription("erro geral");
		mock.setDuracaoInspecao(3);
		mock.setUrlEvidencia("http");
		return mock;
	}

	public List<MqResult> createMock(Integer numeroDeMock) {
		List<MqResult> list = new ArrayList<>();

		for (int i = 0; i < numeroDeMock; i++) {
			list.add(mock());
		}
		return list;
	}

}
