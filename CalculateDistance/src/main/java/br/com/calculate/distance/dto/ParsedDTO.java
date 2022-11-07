package br.com.calculate.distance.dto;

import java.io.Serializable;

public class ParsedDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	String housenumber;
	String street;
	String suburb;
	String postcode;
	String city;
	String state;
	String expected_type;

	// Getter Methods

	public String getHousenumber() {
		return housenumber;
	}

	public String getStreet() {
		return street;
	}

	public String getSuburb() {
		return suburb;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getExpected_type() {
		return expected_type;
	}

	// Setter Methods

	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setExpected_type(String expected_type) {
		this.expected_type = expected_type;
	}

	@Override
	public String toString() {
		return "Parsed [housenumber=" + housenumber + ", street=" + street + ", suburb=" + suburb + ", postcode="
				+ postcode + ", city=" + city + ", state=" + state + ", expected_type=" + expected_type + "]";
	}
}