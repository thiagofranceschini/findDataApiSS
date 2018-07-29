package com.bringto.data.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jms.core.JmsTemplate;

public class MessageListenerComponent implements ApplicationRunner{

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		jmsTemplate.convertAndSend("Santander_data", "{user: 'admin', usando: 'fila'}");
		
	}

}
