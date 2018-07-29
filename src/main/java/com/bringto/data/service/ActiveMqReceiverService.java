package com.bringto.data.service;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class ActiveMqReceiverService {
	private List<String> mqResultText = new ArrayList<>();

	@JmsListener(destination = "Santander_data")
	public Message onReceiverQueue(String mQResult) {
		// linha só será necessária após entender como devemos "limpar" a variável
		this.mqResultText.clear();// remover essa linha caso não seja necessário limpar a variável
		this.mqResultText.add(mQResult);
		return null;
	}

	public List<String> getMqResultText() {
		return mqResultText;
	}

}
