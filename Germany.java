package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Germany {
	private static final Logger LOGGER = LoggerFactory.getLogger(Germany.class);
	String code;
	String name;
	public String getCode() {
		LOGGER.debug("Inside germany code getter field");
		return code;
	}
	public void setCode(String code) {
		LOGGER.debug("Inside germany code setter method");
		this.code = code;
	}
	public String getName() {
		LOGGER.debug("Inside germany name getter method");
		return name;
	}
	public void setName(String name) {
		LOGGER.debug("Inside germany name setter method");
		this.name = name;
	}
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
}
