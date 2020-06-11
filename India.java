package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class India {
	private static final Logger LOGGER = LoggerFactory.getLogger(India.class);
	String code;
	String name;
	public String getCode() {
		LOGGER.debug("Inside India code getter field");
		return code;
	}
	public void setCode(String code) {
		LOGGER.debug("Inside India code setter method");
		this.code = code;
	}
	public String getName() {
		LOGGER.debug("Inside india name getter method");
		return name;
	}
	public void setName(String name) {
		LOGGER.debug("Inside india name setter method");
		this.name = name;
	}
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	
	
}
