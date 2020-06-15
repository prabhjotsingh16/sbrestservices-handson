package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

import ch.qos.logback.classic.Logger;

@RestController
public class CountryController {
	
	@Autowired
	private CountryService countryservice;
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(CountryController.class);

	
	ApplicationContext context;
	
	public CountryController() {
		LOGGER.info("START");
		LOGGER.debug("Inside CountryController Constructor");
		LOGGER.info("END");

	}

	 @RequestMapping("/country")
	public Country getCountryIndia(){
		 
		 LOGGER.info("START");
		  context=new ClassPathXmlApplicationContext("country.xml");
		Country in= context.getBean("in",Country.class);
		LOGGER.info("END");
		return in;
	}
	 
	 @GetMapping("/countries")
	 public List<Country> getAllCountries(){
		 LOGGER.info("START");
		// context=new ClassPathXmlApplicationContext("country.xml");
		// List<Country> l=context.getBean("CountryList",ArrayList.class);
		 ArrayList<Country> al=countryservice.getAllCountries();
		 LOGGER.info("END");
		 	return al;	
	 }
	 
	 @GetMapping("/countries/{code}")
	 public  Country getCountry(@PathVariable("code") String code) throws CountryNotFoundException {
		 LOGGER.info("START");
		 Country c=countryservice.getCountry(code);
		 LOGGER.info("END");
		 return c;
	 }
	 
	 @PostMapping("/postcountries")
	 public Country addCountry(@RequestBody @Valid  Country country) {
		 LOGGER.info("START");
		 LOGGER.debug(country.toString());
		 
		     /*******validation code
	        
	        // Create validator factory
	        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	        Validator validator = factory.getValidator();

	        // Validation is done against the annotations defined in country bean
	        Set<ConstraintViolation<Country>> violations = validator.validate(country);
	        List<String> errors = new ArrayList<String>();

	        // Accumulate all errors in an ArrayList of type String
	        for (ConstraintViolation<Country> violation : violations) {
	            errors.add(violation.getMessage());
	        }

	        // Throw exception so that the user of this web service receives appropriate error message
	        if (violations.size() > 0) {
	            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString());
	        }******************************/

		 return country;
	 }
	 @PutMapping()
		public void updateCountry(@RequestBody @Valid Country country) throws CountryNotFoundException {
		 LOGGER.info("START");
		 countryservice.updateCountry(country);
		 LOGGER.info("END");
	 }
	 
	    @DeleteMapping("/deletecountries/{code}")
	    public ArrayList<Country> deleteCountry(@PathVariable("code") String code)throws CountryNotFoundException{
	    	ArrayList<Country> l= countryservice.deleteCountry(code);
	    return l;
	    }
}
