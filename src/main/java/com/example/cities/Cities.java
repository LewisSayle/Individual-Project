package com.example.cities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(value = {
		@NamedQuery(
				name="Cities.findbiggestcity",
				query= "SELECT city FROM Cities WHERE population = (SELECT MAX(population) FROM Cities)"
				),
		@NamedQuery(
				name="Cities.findmaxpopulation",
				query="SELECT MAX(population) FROM Cities"
				)
})
public class Cities {

	@Id
	private String city;
	private int population;
	private String region;

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
}
