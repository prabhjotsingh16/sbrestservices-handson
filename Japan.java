package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Japan {
	private static final Logger LOGGER = LoggerFactory.getLogger(Japan.class);
	String code;
	String name;
	public String getCode() {
		LOGGER.debug("Inside japan code getter field");
		return code;
	}
	public void setCode(String code) {
		LOGGER.debug("Inside japan code setter method");
		this.code = code;
	}
	public String getName() {
		LOGGER.debug("Inside japan name getter method");
		return name;
	}
	public void setName(String name) {
		LOGGER.debug("Inside japan name setter method");
		this.name = name;
	}
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
}
