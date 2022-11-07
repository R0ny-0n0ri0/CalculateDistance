package br.com.calculate.distance.dto;

import java.io.Serializable;

public class ReturnDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	String departureAddress;

	DistanceResponseDTO distance;

	String description;
	
	
	public ReturnDTO() {
		
	}


	public String getDepartureAddress() {
		return departureAddress;
	}


	public void setDepartureAddress(String departureAddress) {
		this.departureAddress = departureAddress;
	}


	public DistanceResponseDTO getDistance() {
		return distance;
	}


	public void setDistance(DistanceResponseDTO distance) {
		this.distance = distance;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "ReturnDTO [departureAddress=" + departureAddress + ", distance=" + distance + ", description=" + description + "]";
	}
	
	
}
