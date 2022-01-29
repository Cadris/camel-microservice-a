package com.sayan.camelmicroservicea.routes.a;

import java.io.File;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sayan.camelmicroservicea.custombean.SimpleLoggingProcessingComponent;

@Component
public class MyFileRouter extends RouteBuilder{

	@Autowired
	private SimpleLoggingProcessingComponent loggingComponent;
	
	@Override
	public void configure() throws Exception {
		
		/*
		 * pick from a folder and output it to another
		 */
		from("file:files"+File.separator+"input")
			//.log("${header.CamelFileName}")
			.bean(loggingComponent,"process(\"File Encountered\",${header.CamelFileName})")
			.to("file:files"+File.separator+"output");
	}

}
