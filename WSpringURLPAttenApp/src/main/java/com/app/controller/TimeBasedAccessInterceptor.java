package com.app.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TimeBasedAccessInterceptor extends HandlerInterceptorAdapter{

	private static final Logger logger = LoggerFactory
			.getLogger(TimeBasedAccessInterceptor.class);
	
	private int openingTime;
	private int closingTime;
	public int getOpeningTime() {
		return openingTime;
	}
	public void setOpeningTime(int openingTime) {
		this.openingTime = openingTime;
	}
	public int getClosingTime() {
		return closingTime;
	}
	public void setClosingTime(int closingTime) {
		this.closingTime = closingTime;
		
	}
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle)throws Exception
	{
		Calendar cal=Calendar.getInstance();
		 int hour = cal.getFirstDayOfWeek();
		 
		 logger.info("Request URL::" + request.getRequestURL().toString()
					+ ":: Start Time=" + hour);
			request.setAttribute("startTime", closingTime);
	        
	        
	        
	        if (openingTime <= hour && hour < closingTime) {
	            return true;
	        }
	        response.sendRedirect("http://localhost:8080/controller/");
	        		//+ "http://host.com/outsideOfficeHours.html");
	        return false;
	}

}
