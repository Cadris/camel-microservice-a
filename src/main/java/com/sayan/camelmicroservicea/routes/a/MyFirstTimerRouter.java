package com.sayan.camelmicroservicea.routes.a;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyFirstTimerRouter extends RouteBuilder{

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
		 *  Now Start :
		 *  timer
		 *  transformation
		 *  log
		 */
		
		from("timer:first-timer")
			.transform().constant("My Constant Message")
			.to("log:first-timer");
		
	}

}
