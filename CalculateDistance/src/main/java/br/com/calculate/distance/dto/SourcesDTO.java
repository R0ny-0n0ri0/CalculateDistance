package br.com.calculate.distance.dto;

import java.io.Serializable;
import java.util.Arrays;

public class SourcesDTO implements Serializable {

	private static final long serialVersionUID = 1L;


	Double[] location;

	public SourcesDTO () {
		
	}

	public Double[] getLocation() {
		return location;
	}

	public void setLocation(Double[] location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Sources [location=" + Arrays.toString(location) + "]";
	}



}