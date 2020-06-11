package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnitedStates {
	private static final Logger LOGGER = LoggerFactory.getLogger(UnitedStates.class);
	String code;
	String name;
	public String getCode() {
		LOGGER.debug("Inside US code getter field");
		return code;
	}
	public void setCode(String code) {
		LOGGER.debug("Inside US code setter method");
		this.code = code;
	}
	public String getName() {
		LOGGER.debug("Inside US name getter method");
		return name;
	}
	public void setName(String name) {
		LOGGER.debug("Inside US name setter method");
		this.name = name;
	}
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
}
