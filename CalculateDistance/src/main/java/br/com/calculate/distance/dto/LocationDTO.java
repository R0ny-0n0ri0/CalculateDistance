package br.com.calculate.distance.dto;

import java.io.Serializable;
import java.util.Arrays;

public class LocationDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	Float[] location;

	public LocationDTO () {
		
	}

	public Float[] getLocation() {
		return location;
	}

	public void setLocation(Float[] location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Sources : [location=" + Arrays.toString(location) + "]";
	}



}