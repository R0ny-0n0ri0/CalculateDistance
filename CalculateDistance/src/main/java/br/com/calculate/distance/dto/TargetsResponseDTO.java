package br.com.calculate.distance.dto;

import java.io.Serializable;
import java.util.Arrays;

public class TargetsResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;


	Double[] original_location;
	Double[] location;

	public TargetsResponseDTO() {

	}

	public Double[] getOriginal_location() {
		return original_location;
	}

	public void setOriginal_location(Double[] original_location) {
		this.original_location = original_location;
	}

	public Double[] getLocation() {
		return location;
	}

	public void setLocation(Double[] location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "TargetsResponse [original_location=" + Arrays.toString(original_location) + ", location="
				+ Arrays.toString(location) + "]";
	}

	

}