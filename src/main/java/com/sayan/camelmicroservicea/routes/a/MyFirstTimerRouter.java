package com.sayan.camelmicroservicea.routes.a;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sayan.camelmicroservicea.custombean.GetCurrentTimeBean;
import com.sayan.camelmicroservicea.custombean.SimpleLoggingProcessingComponent;

@Component
public class MyFirstTimerRouter extends RouteBuilder{
	
	@Autowired
	private GetCurrentTimeBean getCurrentTimeBean;
	
	@Autowired
	private SimpleLoggingProcessingComponent loggingComponent;

	@Override
	public void configure() throws Exception {
		/*
		 * Final Plan :
		 * Listen to a :: Queue
		 * Do Processing :: Some Transformation
		 * Output :: Save it to database
		 * 
		 * Endpoints Here 2 : Queue, Database
		 * 
		 * Transform 	:: 	Change the Message Body
		 * Processing 	::	Does not Change the body but use the data 
		 * 					to do Some Work
		 * 
		 *  Now Start :
		 *  timer
		 *  transformation
		 *  log
		 */
		
		from("timer:first-timer")
//			.transform().constant("My Constant Message")
//			.transform().constant("Time Now : "+LocalDateTime.now())
//			.bean("getCurrentTime")
			.bean(getCurrentTimeBean, "getCurrentTime")
			.bean(loggingComponent)
			.to("log:first-timer");
	}

}