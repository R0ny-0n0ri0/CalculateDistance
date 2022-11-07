package br.com.calculate.distance.dto;

import java.io.Serializable;

public class BatchDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	QueryDTO query;
	DatasourceDTO datasource;
	String name;
	String housenumber;
	String street;
	String suburb;
	String district;
	String city;
	String county;
	String state;
	String postcode;
	String country;
	String country_code;
	Double lon;
	Double lat;
	String state_code;
	String formatted;
	String address_line1;
	String address_line2;
	String category;
	TimezoneDTO timezone;
	String result_type;
	RankDTO rank;
	String place_id;

	public BatchDTO() {
		
	}

	public QueryDTO getQuery() {
		return query;
	}

	public void setQuery(QueryDTO query) {
		this.query = query;
	}

	public DatasourceDTO getDatasource() {
		return datasource;
	}

	public void setDatasource(DatasourceDTO datasource) {
		this.datasource = datasource;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHousenumber() {
		return housenumber;
	}

	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public String getState_code() {
		return state_code;
	}

	public void setState_code(String state_code) {
		this.state_code = state_code;
	}

	public String getFormatted() {
		return formatted;
	}

	public void setFormatted(String formatted) {
		this.formatted = formatted;
	}

	public String getAddress_line1() {
		return address_line1;
	}

	public void setAddress_line1(String address_line1) {
		this.address_line1 = address_line1;
	}

	public String getAddress_line2() {
		return address_line2;
	}

	public void setAddress_line2(String address_line2) {
		this.address_line2 = address_line2;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public TimezoneDTO getTimezone() {
		return timezone;
	}

	public void setTimezone(TimezoneDTO timezone) {
		this.timezone = timezone;
	}

	public String getResult_type() {
		return result_type;
	}

	public void setResult_type(String result_type) {
		this.result_type = result_type;
	}

	public RankDTO getRank() {
		return rank;
	}

	public void setRank(RankDTO rank) {
		this.rank = rank;
	}

	public String getPlace_id() {
		return place_id;
	}

	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}

	@Override
	public String toString() {
		return "ObjectDTO [query=" + query + ", datasource=" + datasource + ", name=" + name
				+ ", housenumber=" + housenumber + ", street=" + street + ", suburb=" + suburb + ", district="
				+ district + ", city=" + city + ", county=" + county + ", state=" + state + ", postcode=" + postcode
				+ ", country=" + country + ", country_code=" + country_code + ", lon=" + lon + ", lat=" + lat
				+ ", state_code=" + state_code + ", formatted=" + formatted + ", address_line1=" + address_line1
				+ ", address_line2=" + address_line2 + ", category=" + category + ", timezone=" + timezone
				+ ", result_type=" + result_type + ", rank=" + rank + ", place_id=" + place_id + "]";
	}

	
}