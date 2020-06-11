package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



@SpringBootApplication
public class SpringLearnApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	private static ApplicationContext context;

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringLearnApplication.class, args);
		displayDate();
		displayCountry();
		displayCountries();
		LOGGER.info("Inside main");
	}
	
	static void displayCountries() {
		  LOGGER.info("START");
		//context= new ClassPathXmlApplicationContext("country.xml");
		ArrayList<?> al=context.getBean("CountryList",ArrayList.class);
		
		LOGGER.debug("Country : {}", al.toString());
		LOGGER.info("END");
	}
	
	static void displayCountry() {
		  LOGGER.info("START");
		context=new ClassPathXmlApplicationContext("country.xml");
		Country c=context.getBean("country", Country.class);
		
		//if we did not mention or mention as singeleton scope for country bean then c and another country will have same reference means 
		//constructor will be called only once
		//but if we mention scope as prototype for country bean different objet will be created for different request
		//means c and anothercountry will have diffrent reference and cons will called twice
		
		Country anotherCountry = context.getBean("country", Country.class);
		//bcs debug takes string therefor we can not write simply c 
		LOGGER.debug("Country : {}", c.toString());
		LOGGER.info("END");
	}
	
	static void displayDate() throws ParseException {
	    LOGGER.info("START");
	context = new ClassPathXmlApplicationContext("date-format.xml");
	 SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
	 Date date = format.parse("31/12/2018");
	 System.out.println(date);
	 
	 //to print in our own format
	 String d=format.format(date);
      System.out.println(d);
      
      // always use logging in real time application never use sopln
      
      LOGGER.debug(d);
      LOGGER.info("END");
}
}
