package com.example.demo.validation;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Access(AccessType.FIELD)
public class City {

	public City() {

	}

	public City(String name, String country, String provice, int population, double longitude, double latitude) {
		super();
		this.name = name;
		this.country = country;
		this.province = provice;
		this.population = population;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	@Id
	public String name;
	public String country, province;
	public Integer population;
	public Double longitude, latitude;

	@Override
	public String toString() {
		return "City [name=" + name + ", country=" + country + ", Population=" + population + ", Longitude=" + longitude
				+ ", Latitude=" + latitude + "]";
	}

}
