package com.cognizant.springlearn.model;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);
	
	public Country() {
		LOGGER.debug("Inside Country Constructor");
	}
	
	@NotNull
    @Size(min=2, max=2, message="Country code should be 2 characters")
	String code;
	String name;
	public String getCode() {
		LOGGER.debug("Inside Country code getter field");
		return code;
	}
	public void setCode(String code) {
		LOGGER.debug("Inside Country code setter method");
		this.code = code;
	}
	public String getName() {
		LOGGER.debug("Inside Country name getter method");
		return name;
	}
	public void setName(String name) {
		LOGGER.debug("Inside Country name setter method");
		this.name = name;
	}
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	
	
	

}
