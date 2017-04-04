package com.challenge.copart;

public class USAddress {
	
	private String zipCode;
	private String latitude;
	private String longitude;
	private String city;
	private String state;
	private String county;
	
	public USAddress() {
		this.zipCode = null;
		this.latitude = null;
		this.longitude = null;
		this.city = null;
		this.state = null;
		this.county = null;		
	}
	
	public USAddress(String zipCode, String latitude, String longitude, String city, String state, String county) {
		this.zipCode = zipCode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.city = city;
		this.state = state;
		this.county = county;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}

}
