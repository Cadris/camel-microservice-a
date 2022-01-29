package com.sayan.camelmicroservicea.custombean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleLoggingProcessingComponent {
	
	private Logger logger = LoggerFactory.getLogger(SimpleLoggingProcessingComponent.class);

	public void process(String message1,String message2) {
		// TODO : Logging (Some Task)
		logger.info(message1+" {}", message2);
	}
}
