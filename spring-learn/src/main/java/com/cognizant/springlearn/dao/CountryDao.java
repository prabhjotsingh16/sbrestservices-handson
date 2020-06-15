package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.model.Country;

@Repository
public class CountryDao implements DaoInterface{
	
	private  ArrayList<Country> countryList;
	private final static Logger LOGGER  = LoggerFactory.getLogger(CountryDao.class);
	private ApplicationContext context;
	public CountryDao() {
		context = new ClassPathXmlApplicationContext("country.xml");
		countryList = (ArrayList<Country>)context.getBean("CountryList");
	}
	
	
	@Override
	public  ArrayList<Country> getAllCountries() {
		LOGGER.info("START");
		return countryList;
		
	}


	@Override
	public void updateCountry(Country country) {
		// TODO Auto-generated method stub
		LOGGER.info("START");
		LOGGER.info("END");
		
	}


	@Override
	public ArrayList<Country> deleteCountry(String code) {
		// TODO Auto-generated method stub
		LOGGER.info("START");
		for(Country cl:countryList)
			if(cl.getCode().equalsIgnoreCase(code))
				countryList.remove(cl);
		return countryList;
		
		
	}

}
