package com.sayan.camelmicroservicea.custombean;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class GetCurrentTimeBean{
	public String getCurrentTime() {
		return "Time Now : "+LocalDateTime.now();
	}
}