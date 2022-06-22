package net.alexanderandrade.api.model;

public class SatelliteRequestWithNameModel extends SatelliteRequestModel {
	String name;

	public SatelliteRequestWithNameModel () {}

	public String getName () {
		return name;
	}

	public void setName ( String name ) {
		this.name = name;
	}
}
