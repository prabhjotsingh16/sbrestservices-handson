package com.cognizant.springlearn.service;

import java.util.ArrayList;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;


import com.cognizant.springlearn.dao.DaoInterface;
import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;




@Service
public class CountryService  {

	private final static Logger LOGGER = LoggerFactory.getLogger(Country.class);
	
	ApplicationContext context;
	
	@Autowired
	DaoInterface cdimpl;
	
	 
	
	public ArrayList<Country> getAllCountries(){
		return cdimpl.getAllCountries();
	}
	public void updateCountry(Country country) throws CountryNotFoundException {
		cdimpl.updateCountry(country);
	}
	
	public ArrayList<Country> deleteCountry(String code) throws CountryNotFoundException{
		ArrayList<Country> a=cdimpl.deleteCountry(code);
		return a;
	}

	
	public Country getCountry(String code)throws CountryNotFoundException {
		
		LOGGER.info("START");
		context=new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> al=context.getBean("CountryList", ArrayList.class);
		for( Country c:al) {
			if(code.equalsIgnoreCase(c.getCode()))
				return c;
		}
		throw new CountryNotFoundException();

			
	}
}
