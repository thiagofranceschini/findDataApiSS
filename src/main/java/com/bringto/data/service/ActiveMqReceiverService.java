package com.bringto.data.service;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class ActiveMqReceiverService {
	
	private List<String> mqResultText = new ArrayList<>();
	
	@JmsListener(destination = "Santander_data")
	public Message onReceiverQueue(List<String> mQResult) {
		mqResultText.addAll(mQResult);
		return null;
		
	}

	public List<String> getMqResultText() {
		return mqResultText;
	}

	public void clearList() {
		if(!CollectionUtils.isEmpty(this.mqResultText)) {
			this.mqResultText.clear();
		}
	}
}
