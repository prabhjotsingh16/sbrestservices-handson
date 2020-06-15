package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import com.cognizant.springlearn.model.Country;

public interface DaoInterface {
	public ArrayList<Country> getAllCountries();
	public void updateCountry(Country country);
	public ArrayList<Country> deleteCountry(String code);
}
